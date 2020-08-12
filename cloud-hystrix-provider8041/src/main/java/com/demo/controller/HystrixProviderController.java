package com.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class HystrixProviderController {

    @GetMapping("/provider/ok")
    public String provider_OK(){
        String result = "线程池：" + Thread.currentThread().getName() + "   provider_OK";
        System.out.println("*******result:" + result);
        return result;
    }

    @GetMapping("/provider/timeout")
    // 一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "provider_TimeOutHandler", commandProperties = {
            // 限制超时时间，超过3秒服务降级
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String provider_TimeOut() {
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String result = "线程池：" + Thread.currentThread().getName() + "   paymentInfo_TimeOut," + " 耗时(秒)" + timeNumber;

        System.out.println("*******result:" + result);
        return result;
    }

    /**
     * provider_TimeOut降级之后会调用的方法，方法参数和返回值类型必须与provider_TimeOut方法一致
     */
    public String provider_TimeOutHandler(){
        String result = "线程池：" + Thread.currentThread().getName() + "   paymentInfo_TimeOutHandler";

        System.out.println("*******result:" + result);
        return result;
    }

}
