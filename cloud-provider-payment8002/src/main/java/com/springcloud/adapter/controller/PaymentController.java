package com.springcloud.adapter.controller;



import com.springcloud.entity.PaymentEntity;

import com.springcloud.usecase.port.service.dto.RootDto;
import lombok.var;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.springcloud.usecase.port.repository.PaymentRepository;

import javax.annotation.Resource;

@RestController
public class PaymentController extends BaseController {
    @Resource
    PaymentRepository paymentRepository;

    @Value("${server.port}")
    private String port;

    @PostMapping("/payment/create")
    public RootDto create(@RequestBody PaymentEntity paymentEntity){
        paymentRepository.create(paymentEntity);

        return new RootDto(201,"成功"+port,null);
    }

    @GetMapping("/payment/{id}")
    public RootDto getPaymentById(@PathVariable("id") Long id){

        var res = paymentRepository.getPaymentById(id);
        if(res!=null){
            return new RootDto(200,"成功"+port,res);
        }else{
            return new RootDto(444,"查询失败",res);
        }
    }
    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return port;
    }
}
