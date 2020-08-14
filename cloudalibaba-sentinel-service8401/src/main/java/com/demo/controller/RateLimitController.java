package com.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.demo.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;

public class RateLimitController {

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException")
    public String customerBlockHandler()
    {
        return "按客戶自定义";
    }
}
