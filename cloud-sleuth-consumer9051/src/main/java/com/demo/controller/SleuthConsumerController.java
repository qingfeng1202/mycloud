package com.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class SleuthConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/sleuthConsumer")
    public String sleuthConsumer(){
        String forObject = restTemplate.getForObject("http://SLEUTH-PROVIDER/sleuthProvider", String.class);
        System.out.println("***SleuthConsumer***" + forObject);

        return  "***SleuthConsumer***" + forObject;
    }
}
