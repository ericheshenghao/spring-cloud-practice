package com.springcloud.service;


import com.springcloud.entity.PaymentEntity;
import com.springcloud.usecase.port.service.dto.RootDto;
import feign.Param;
        import org.springframework.cloud.openfeign.FeignClient;
        import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/{id}")
   public  RootDto<PaymentEntity> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
