package com.charver.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName MemberApp <br>
 * @Description TODO <br>
 *
 * @Author njchen
 * @Date 2020/1/6 16:03
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册到Eureka服务列表中
@EnableDiscoveryClient //服务发现
public class MemberApp {

    public static void main(String[] args) {
        SpringApplication.run(MemberApp.class, args);
    }
}
