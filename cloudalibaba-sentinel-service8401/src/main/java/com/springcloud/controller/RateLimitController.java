package com.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.myHandle.CustomerBlockHandler;
import com.springcloud.usecase.port.service.dto.PaymentDto;
import com.springcloud.usecase.port.service.dto.RootDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value="byResource",blockHandler ="handleException")
    public RootDto byResource(){
        return  new RootDto(200,"限流测试",new PaymentDto(2020L,"serial01"));

    }
    public  RootDto handleException(BlockException exception){
        return  new RootDto(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public RootDto byUrl()
    {
        return new RootDto(200,"按url限流测试OK",new PaymentDto(2020L,"serial002"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "hanlerException2")
    public RootDto customerBlockHandler()
    {
        return new RootDto(200,"按客戶自定义",new PaymentDto(2020L,"serial003"));
    }



}


