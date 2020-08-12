package com.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixProviderController3 {

    @GetMapping("/provider3/circuitBreaker/{id}")
    @HystrixCommand(fallbackMethod = "providerCircuitBreakerFallbackHandler", commandProperties={
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String provider_circuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0){
            int i = 1/0;
        }

        String result = "线程池：" + Thread.currentThread().getName() + "   provider_circuitBreaker";
        System.out.println("*******result:" + result);
        return result;
    }

    public String providerCircuitBreakerFallbackHandler(Integer id){
        return "defaultFallback...";
    }

}
