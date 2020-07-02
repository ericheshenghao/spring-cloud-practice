package com.springcloud.adapter.controller;




import com.springcloud.adapter.controller.BaseController;
import com.springcloud.entity.PaymentEntity;
import com.springcloud.service.PaymentService;
import com.springcloud.usecase.port.repository.PaymentRepository;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController extends BaseController {
    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
         String res = paymentService.paymentInfo_ok(id);
         log.info("****result: "+res);
        return res;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
        String res = paymentService.paymentInfo_Time_out(id);
        log.info("****result: "+res);
        return res;
    }
  // 服务熔断
    // 多次提供负数后，断路器开启，即使提供正确的id也会报错
  @GetMapping("/payment/circuit/{id}")
  public String paymentInfo_circuit(@PathVariable("id") Integer id){
      String res = paymentService.paymentCircuitBreaker(id);
      log.info("****result: "+res);
      return res;
  }
}
