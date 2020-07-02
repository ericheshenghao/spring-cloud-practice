package com.springcloud.service;

import org.springframework.stereotype.Component;

// 全局异常处理类
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "-----PaymentFallback paymentInfo_ok /(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_Time_out(Integer id) {
        return "-----PaymentFallback paymentInfo_Time_out /(ㄒoㄒ)/~~";
    }
}
