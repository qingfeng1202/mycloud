package com.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixProviderController2 {

    @GetMapping("/provider2/error")
    @HystrixCommand
    public String provider_error() {
        int i = 1/0;

        String result = "线程池：" + Thread.currentThread().getName() + "   paymentInfo_TimeOut";
        System.out.println("*******result:" + result);
        return result;
    }

    public String defaultFallback(){
        return "defaultFallback...";
    }

}
