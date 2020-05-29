package com.charver.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MemberController <br>
 * @Description TODO <br>
 *
 * @Author njchen
 * @Date 2020/1/6 15:57
 * @Version 1.0
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/list")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "processGetMember")
    public Map<String, String> getAllMember() {

        //构造异常
//        throw new RuntimeException("查询数据库异常");
        Map<String, String> members = new HashMap<>(4);
        members.put("zhangsan", "v3");
        members.put("lisi", "v4");
        members.put("wangwu", "v5");
        members.put("zhaoliu", "v6");

        return members;
    }

    public Map<String, String> processGetMember() {

        HashMap<String, String> map = new HashMap<>(1);
        map.put("9999", "系统异常，请稍后访问！");
        return map;
    }

    @RequestMapping("/discovery")
    @ResponseBody
    public Object discovery() {

        System.out.println("Current client : " + client.description());

        List<String> services = client.getServices();
        System.out.println("Current service list : " + services);

        for (String service : services) {
            List<ServiceInstance> instances = client.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t"
                        + instance.getPort() + "\t" + instance.getUri());
            }
        }

        return client;
    }
}
