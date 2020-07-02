package com.springcloud.adapter.controller;




import com.springcloud.entity.PaymentEntity;
import com.springcloud.lb.LoadBalance;
import com.springcloud.usecase.port.service.dto.PaymentDto;
import com.springcloud.usecase.port.service.dto.RootDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    public static final  String PAYMENT_URL ="http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalance loadBalance;

    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping("/consumer/payment/create")
    public RootDto<PaymentDto> create(@RequestBody PaymentEntity paymentEntity) {
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",paymentEntity,RootDto.class);
    }

    @GetMapping("/consumer/payment/{id}")
    public RootDto getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id, RootDto.class);
    }

    @GetMapping("/consumer/payment/entity/{id}")
    public RootDto getPayment2(@PathVariable("id") Long id){

        ResponseEntity<RootDto> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/"+id, RootDto.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new RootDto(444,"失败",null);

        }
    }

    @GetMapping("/consumer/payment/lb")
    public  String   getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances ==null || instances.size()<=0){
            return null;
        }

        ServiceInstance serviceInstance = loadBalance.intances(instances);
        URI uri =  serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
    @GetMapping("/consumer/payment/zipkin")
    public  String   paymentZipkin(){
        String forObject = restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin" , String.class);
        return  forObject;
    }


}
