package com.learning.learningcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.Async;

@SpringBootApplication
@Async
@EnableDiscoveryClient
@EnableFeignClients
public class LearningCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningCoreApplication.class, args);
    }

}
