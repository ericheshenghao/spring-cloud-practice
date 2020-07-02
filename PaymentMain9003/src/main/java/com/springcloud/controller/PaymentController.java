package com.springcloud.controller;


import com.springcloud.usecase.port.service.dto.PaymentDto;
import com.springcloud.usecase.port.service.dto.RootDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
public class PaymentController
{
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, PaymentDto> hashMap = new HashMap<>();
    static{
        hashMap.put(1L,new PaymentDto(1L,"28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2L,new PaymentDto(2L,"bba8c1e3bc2742d8848569891ac32182"));
        hashMap.put(3L,new PaymentDto(3L,"6ua8c1e3bc2742d8848569891xt92183"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public RootDto<PaymentDto> paymentSQL(@PathVariable("id") Long id){
        PaymentDto payment = hashMap.get(id);
        RootDto<PaymentDto> result = new RootDto<>(200,"from mysql,serverPort:  "+serverPort,payment);
        return result;
    }



}


