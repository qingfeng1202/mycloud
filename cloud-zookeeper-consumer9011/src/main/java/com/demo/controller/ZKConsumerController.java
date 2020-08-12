package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ZKConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String consumer(){
        String forObject = restTemplate.getForObject("http://ZKProvider/provider", String.class);
        System.out.println("ZKConsumer: " + forObject);
        return forObject;
    }
}
