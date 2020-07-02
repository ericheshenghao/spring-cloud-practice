package com.springcloud.controller;

import com.springcloud.domain.StorageDto;
import com.springcloud.domain.RootDto;
import com.springcloud.usecase.StorageUsecase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    StorageUsecase storageUsecase;

    @RequestMapping("/test")
    public String text(){
        return "hello";
    }

    @RequestMapping("/storage/decrease")
    public RootDto decrease(Long  productId,Integer count){
        storageUsecase.decrease(productId,count);
        return new RootDto(200,"扣减库存成功",null);
    }

}
