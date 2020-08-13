package com.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SleuthProviderController {

    @RequestMapping("/sleuthProvider")
    public String sleuthProvider(){
        return "this is sleuthProvider";
    }
}
