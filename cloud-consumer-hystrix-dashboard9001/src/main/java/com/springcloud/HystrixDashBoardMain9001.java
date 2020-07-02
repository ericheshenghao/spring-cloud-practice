package com.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
// 监控8001、8002、8003
@EnableHystrixDashboard
public class HystrixDashBoardMain9001 {
    public static void main(String[]  args) {
        SpringApplication.run(HystrixDashBoardMain9001.class,args);
    }
}
