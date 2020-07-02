package com.springcloud.adapter.controller;




import com.springcloud.entity.PaymentEntity;
import com.springcloud.usecase.port.repository.PaymentRepository;
import com.springcloud.usecase.port.service.dto.RootDto;
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
    PaymentRepository paymentRepository;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public RootDto create(@RequestBody PaymentEntity paymentEntity){
        paymentRepository.create(paymentEntity);

        return new RootDto(201,"成功"+port,null);
    }

    @GetMapping("/payment/get/{id}")
    public RootDto getPaymentById(@PathVariable("id") Long id){
        var res = paymentRepository.getPaymentById(id);
        if(res!=null){
            return new RootDto(200,"成功"+port,res);
        }else{
            return new RootDto(444,"查询失败",res);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public  Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String e :services){
            log.info("****element: "+e);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
            for ( ServiceInstance instance:instances ){
                log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
            }

            return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return port;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        try{ TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e ){e.printStackTrace();}
        return port;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){

        return "hi, zipkin";
    }
}
