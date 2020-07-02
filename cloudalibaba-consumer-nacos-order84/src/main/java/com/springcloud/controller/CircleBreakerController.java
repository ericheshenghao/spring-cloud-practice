package com.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;


import com.springcloud.service.PaymentService;
import com.springcloud.usecase.port.service.dto.PaymentDto;
import com.springcloud.usecase.port.service.dto.RootDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;



    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback") //没有配置
//    @SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规,不负责处理业务违规
//    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",//既配置业务异常，也配置控制台违规异常 需重启一下
//            exceptionsToIgnore = {IllegalArgumentException.class}
//            )
    public RootDto<PaymentDto> fallback(@PathVariable Long id) {
        RootDto<PaymentDto> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id, RootDto.class,id);

        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }

    //fallback
    public RootDto handlerFallback(@PathVariable  Long id,Throwable e) {
        PaymentDto payment = new PaymentDto(id,"null");
        return new RootDto<>(444,"兜底异常handlerFallback,exception内容  "+e.getMessage(),payment);
    }

    //blockHandler
    public RootDto blockHandler(@PathVariable  Long id,BlockException blockException) {
        PaymentDto payment = new PaymentDto(id,"null");
        return new RootDto<>(445,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }


    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler"
    )
    public RootDto<PaymentDto> paymentSQL(@PathVariable("id") Long id){
        RootDto<PaymentDto> res = paymentService.paymentSQL(id);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        } else if (res.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }


        return res;
    }


}


