package com.demo.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DiscoveryController {

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/discovery")
    public Object discovery(){
        // 获取所有注册的服务名
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println("***** element:"+element);

            // 根据服务名获取实例信息
            List<ServiceInstance> instances = discoveryClient.getInstances(element);
            for (ServiceInstance instance : instances) {
                System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
            }
        }
        return this.discoveryClient;
    }

}
