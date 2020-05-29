package com.charver.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @ClassName OrderFeignApp <br>
 * @Description TODO <br>
 * @Author njchen
 * @Date 2020/1/6 16:10
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(/*basePackages = {"com.charver.cloud.service"}*/)
public class OrderFeignApp {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApp.class);
    }

}
