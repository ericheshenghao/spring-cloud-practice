package com.springcloud.service;


import com.springcloud.usecase.port.service.dto.PaymentDto;
        import com.springcloud.usecase.port.service.dto.RootDto;
        import org.springframework.cloud.openfeign.FeignClient;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {

        @GetMapping(value = "/paymentSQL/{id}")
        public RootDto<PaymentDto> paymentSQL(@PathVariable("id") Long id);
}