package com.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
public class PaymentController  {


    @Value("${server.port}")
    private String port;

    @RequestMapping("/payment/consul")
    public String paymentzk(){
        return "spring with consul "+port+"/t"+ UUID.randomUUID().toString();
    }


}
