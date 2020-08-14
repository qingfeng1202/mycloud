package com.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-provider",fallback = ProviderFallbackService.class)
public interface ProviderService {

    @GetMapping(value = "/paymentSQL/{id}")
    String paymentSQL(@PathVariable("id") Long id);
}

@Component
class ProviderFallbackService implements ProviderService {

    @Override
    public String paymentSQL(Long id) {
        return "服务降级返回,---ProviderFallbackService";
    }
}
