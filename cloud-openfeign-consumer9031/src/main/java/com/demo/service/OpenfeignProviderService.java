package com.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "OPENFEIGN-PROVIDER")
public interface OpenfeignProviderService {

    @RequestMapping("/provider")
    String provider();

}
