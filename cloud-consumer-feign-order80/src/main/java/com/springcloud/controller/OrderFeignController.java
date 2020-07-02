package com.springcloud.controller;

import com.springcloud.entity.PaymentEntity;
import com.springcloud.service.PaymentFeignService;
import com.springcloud.usecase.port.service.dto.RootDto;
import feign.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
  private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/{id}")
    public RootDto<PaymentEntity> getPaymentById(@PathVariable Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        // 一般默认等待1秒钟
        // 业务处理需要3秒
        return paymentFeignService.paymentFeignTimeout();
    }

}
