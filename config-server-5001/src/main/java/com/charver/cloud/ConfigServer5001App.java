package com.charver.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * ClassName ConfigServer5001App <br>
 * Description TODO <br>
 *
 * @author njchen
 * @version 1.0
 * @date 2020/5/12 10:50
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer5001App {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer5001App.class, args);
    }
}
