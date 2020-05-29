package com.charver.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @ClassName DashboardApp <br>
 * @Description TODO <br>
 *
 * @Author njchen
 * @Date 2020/1/6 16:03
 * @Version 1.0
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashboardApp {

    public static void main(String[] args) {
        SpringApplication.run(DashboardApp.class, args);
    }
}
