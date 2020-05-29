package com.charver.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaServerApp <br>
 * @Description TODO <br>
 *
 * @Author njchen
 * @Date 2020/1/6 15:51
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer //表示EurekaServer服务端启动类，接受其他微服务注册进来
public class EurekaServer7777App {

    public static void main(String[] args) {

        SpringApplication.run(EurekaServer7777App.class, args);
    }
}
