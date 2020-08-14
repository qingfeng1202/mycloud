package com.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/test/nacos")
    public String test()
    {
        return "nacos registry, test: "+ serverPort;
    }
}
