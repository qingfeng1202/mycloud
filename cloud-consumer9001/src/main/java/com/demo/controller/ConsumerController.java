package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/onsumer")
    public String consumer(){
        String forObject = restTemplate.getForObject("http://PROVIDER/provider", String.class);
        System.out.println("consumer: " + forObject);
        return forObject;
    }
}
