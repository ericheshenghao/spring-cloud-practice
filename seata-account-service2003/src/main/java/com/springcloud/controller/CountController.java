package com.springcloud.controller;

import com.springcloud.domain.RootDto;
import com.springcloud.usecase.CountUsecase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class CountController {

    @Resource
    CountUsecase countUsecase;

    @RequestMapping("/test")
    public String text(){
        return "hello";
    }

    @RequestMapping("/account/decrease")
    public RootDto decrease(@RequestParam("userId") Long  userId,@RequestParam("money") BigDecimal money){
        countUsecase.decrease(userId,money);
        return new RootDto(200,"扣减现金成功",null);
    }

}
