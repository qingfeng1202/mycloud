package com.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateWay")
public class GateWayTestController {

    @RequestMapping("/test/1")
    private String test1(){
        return "test1";
    }

    @RequestMapping("/test/2")
    private String test2(){
        return "test2";
    }

}
