package com.springcloud.controller;



import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
// 全局配置降级方法
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        String res = paymentHystrixService.paymentInfo_ok(id);
        return res ;
    }


    // 消费端的超时处理
    //消费端允许2s
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="2000")
//    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_Time_out(@PathVariable("id") Integer id){
            String res = paymentHystrixService.paymentInfo_Time_out(id);
            return  res ;
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "消费80忙/(ㄒoㄒ)/~~"+"耗时:";
    }

    public String payment_Global_FallbackMethod(){
        return "服务出现异常，请稍后再试";
    }

}
