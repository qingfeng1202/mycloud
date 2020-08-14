package com.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler", exceptionsToIgnore = {IllegalArgumentException.class})
    public String fallback(@PathVariable Long id)
    {
        String result = restTemplate.getForObject("http://nacos-provider/paymentSQL/"+id, String.class, id);
        System.out.println(result);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.equals("from mysql,serverPort:  9110-----null")) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }

    public String handlerFallback(@PathVariable Long id, Throwable e){
        return "this is handlerFallback";
    }

    public String blockHandler(@PathVariable Long id, BlockException blockException){
        return "this is blockHandler";
    }
}
