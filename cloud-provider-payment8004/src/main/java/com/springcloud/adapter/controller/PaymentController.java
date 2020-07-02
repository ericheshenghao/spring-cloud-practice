package com.springcloud.adapter.controller;





import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
public class PaymentController extends BaseController {


    @Value("${server.port}")
    private String port;

    @RequestMapping("/payment/zk")
    public String paymentzk(){
        return "spring with zookeeper "+port+"/t"+ UUID.randomUUID().toString();
    }


}
