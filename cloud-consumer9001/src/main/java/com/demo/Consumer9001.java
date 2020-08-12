package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Consumer9001 {

    public static void main(String[] args) {
        SpringApplication.run(Consumer9001.class);
    }
}
