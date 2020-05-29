package com.charver.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName ConfigClientRestController <br>
 * Description TODO <br>
 *
 * @author njchen
 * @version 1.0
 * @date 2020/5/13 10:21
 */
@RestController
public class ConfigClientController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.serviceUrl.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig() {
        System.out.println("applicationName:" + applicationName + "\t eurekaServers:" + eurekaServers + "\t port: " + port);
        return "applicationName:【" + applicationName + "】，eurekaServers:【" + eurekaServers + "】，port:【" + port + "】";
    }

}
