package com.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @RequestMapping("/provider")
    public String provider(){
        System.out.println("接口被调用---------");
        return "this is provider";
    }

}
