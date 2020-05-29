package com.charver.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName ZuulGatewayApp <br>
 * @Description TODO <br>
 * @Author njchen
 * @Date 2020/1/6 16:10
 * @Version 1.0
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayApp {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApp.class);
    }

}
