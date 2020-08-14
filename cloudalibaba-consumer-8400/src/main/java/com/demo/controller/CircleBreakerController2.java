package com.demo.controller;

import com.demo.service.ProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController2 {

    @Resource
    private ProviderService providerService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public String paymentSQL(@PathVariable("id") Long id) {
        return providerService.paymentSQL(id);
    }

}
