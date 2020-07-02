package com.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String port;

    @GetMapping("/info")
    public String getInfo(){
       return "serverport:"+port+"\t\n\n configinfo: "+configInfo;
    }
}
