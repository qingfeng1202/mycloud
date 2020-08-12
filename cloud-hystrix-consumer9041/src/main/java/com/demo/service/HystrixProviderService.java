package com.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "HYSTRIX-PROVIDER", fallback = HystrixProviderServiceImpl.class)
public interface HystrixProviderService {

    @GetMapping("/provider/ok")
    String provider_OK();

    @GetMapping("/provider/timeout")
    String provider_TimeOut();
}

@Service
class HystrixProviderServiceImpl implements HystrixProviderService{

    @Override
    public String provider_OK() {
        return "-----HystrixProviderService fallback provider_OK , (┬＿┬)";
    }

    @Override
    public String provider_TimeOut() {
        return "-----HystrixProviderService fallback provider_TimeOut , (┬＿┬)";
    }
}