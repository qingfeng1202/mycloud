package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZKConsumer9011 {

    public static void main(String[] args) {
        SpringApplication.run(ZKConsumer9011.class);
    }
}
