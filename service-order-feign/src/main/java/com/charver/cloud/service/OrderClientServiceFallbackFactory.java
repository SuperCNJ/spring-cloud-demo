package com.charver.cloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName OrderClientServiceFallbackFactory <br>
 * Description TODO <br>
 * @Author njchen
 * @Date 2020/4/13 15:40
 * @Version 1.0
 */
@Component
public class OrderClientServiceFallbackFactory implements FallbackFactory<OrderClientService> {

    @Override
    public OrderClientService create(Throwable throwable) {
        return new OrderClientService() {
            @Override
            public Map<String, String> getMemberList() {
                return (Map<String, String>)getShowInfo();
            }

            @Override
            public Object discovery() {
                return getShowInfo();
            }

            private Object getShowInfo() {
                HashMap<String, String> map = new HashMap<String, String>(1);
                map.put("9999", "暂停服务！");
                return map;
            }
        };
    }
}
