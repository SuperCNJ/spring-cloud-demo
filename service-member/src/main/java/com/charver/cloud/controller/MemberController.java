package com.charver.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Map<String, String> getAllMember() {

        Map<String, String> members = new HashMap<>(4);
        members.put("zhangsan", "v3");
        members.put("lisi", "v4");
        members.put("wangwu", "v5");
        members.put("zhaoliu", "v6");
        String s = new String();

        return members;
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
