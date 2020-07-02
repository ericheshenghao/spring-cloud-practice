package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients

@SpringBootApplication()//取消数据源自动创建的配置
public class SeataOrderMainApp2002 {

    public static void main(String[] args)
    {
        SpringApplication.run(SeataOrderMainApp2002.class, args);
    }
}

