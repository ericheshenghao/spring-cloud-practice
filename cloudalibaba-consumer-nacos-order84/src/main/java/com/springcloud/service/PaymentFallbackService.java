package com.springcloud.service;

import com.springcloud.usecase.port.service.dto.PaymentDto;
import com.springcloud.usecase.port.service.dto.RootDto;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public RootDto<PaymentDto> paymentSQL(Long id) {
        return new RootDto<>(444,"服务降级");
    }
}
