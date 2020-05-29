package com.charver.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @ClassName MyRoundRobinRule <br>
 * @Description TODO <br>
 * @Author njchen
 * @Date 2020/1/15 17:26
 * @Version 1.0
 */
public class MyRoundRobinRule extends AbstractLoadBalancerRule {

    /** 一台机器每次被连续调用的次数，目前要求5次 */
    private static final int CALL_COUNT = 5;

    /** 当前提供服务的机器号 */
    private int currentIndex = 0;
    private int currentTotal = 0;

    private static Logger log = LoggerFactory.getLogger(RoundRobinRule.class);

    public MyRoundRobinRule() {
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            if (currentTotal < CALL_COUNT) {
                //当前机器被调用的次数未达到总次数5次，继续调用
                server = upList.get(currentIndex);
                currentTotal++;
            } else {
                //当前机器已被连续调用5次，调用下一台机器
                currentTotal = 0;
                currentIndex++;
                if (currentIndex >= upList.size()) {
                    //计算出的下一台机器号超限，则初始化
                    currentIndex = 0;
                }
            }

            if (server == null) {
                //服务列表在某个时刻中断，暂停当前正在执行的线程对象并执行其他线程
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();
        }

        return server;

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
