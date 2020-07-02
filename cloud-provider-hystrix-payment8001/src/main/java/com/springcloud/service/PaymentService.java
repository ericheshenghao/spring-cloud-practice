package com.springcloud.service;


import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_ok(Integer id){
        return "线程池"+Thread.currentThread().getName()+"PaymentInfo_ok"+id+"\t"+"O(∩_∩)O";
        }

        // 超时处理
        @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="5000")
        })
public String paymentInfo_Time_out(Integer id){
        int timeNumber =3;
//        int age = 10/0;
        try{ TimeUnit.SECONDS.sleep(timeNumber);} catch (InterruptedException e ){e.printStackTrace();}
        return "线程池"+Thread.currentThread().getName()+"PaymentInfo_Time_out"+id+"\t"+"O(∩_∩)O"+"耗时:"+timeNumber;
        }

        public String paymentInfo_TimeoutHandler(Integer id){
            return "线程池"+Thread.currentThread().getName()+"paymentInfo_TimeoutHandler"+id+"\t"+"/(ㄒoㄒ)/~~"+"耗时:";
        }
    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value="true"), //开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"), // 请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"), //时间范围
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60"), // 失败率达到多少跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: "+serialNumber;

    }


    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {

        return "id 不能为负数，请稍后再试，/(ㄒoㄒ)/~~"+id;
    }
}
