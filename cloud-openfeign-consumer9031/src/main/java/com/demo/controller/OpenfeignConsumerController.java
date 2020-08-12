package com.demo.controller;

import com.demo.service.OpenfeignProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OpenfeignConsumerController {

    @Resource
    private OpenfeignProviderService openfeignProviderService;


    @GetMapping("/consumer")
    public String consumer(){
        String provider = openfeignProviderService.provider();
        System.out.println("OpenfeignConsumerController: " + provider);
        return "OpenfeignConsumerController: " + provider;
    }
}
