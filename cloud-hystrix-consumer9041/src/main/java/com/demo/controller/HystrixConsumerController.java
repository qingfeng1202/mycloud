package com.demo.controller;

import com.demo.service.HystrixProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HystrixConsumerController {

    @Resource
    private HystrixProviderService hystrixProviderService;

    @GetMapping("/consumer/ok")
    public String provider_OK(){
        String result = hystrixProviderService.provider_OK();
        System.out.println("*******HystrixConsumerController:" + result);
        return "*******HystrixConsumerController:" + result;
    }

    @GetMapping("/consumer/timeout")
    public String provider_TimeOut() {
        String result = hystrixProviderService.provider_TimeOut();
        System.out.println("*******HystrixConsumerController:" + result);
        return "*******HystrixConsumerController:" + result;
    }
}
