package com.springcloud.controller;

import com.springcloud.domain.OrderDto;
import com.springcloud.domain.RootDto;
import com.springcloud.usecase.OrderUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;



@RestController
public class OrderController {

    @Autowired
    OrderUsecase orderUsecase;


    @GetMapping("/create")
    public RootDto create(OrderDto orderDto){
        orderUsecase.create(orderDto);
        return new RootDto(200,"订单创建成功s",null);
    }

    @GetMapping("/snowflake")
    public RootDto snowflake(OrderDto orderDto){
        orderUsecase.createSnowFlake();
        return new RootDto(200,"成功",null);
    }

}
