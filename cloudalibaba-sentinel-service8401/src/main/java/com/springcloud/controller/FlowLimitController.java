package com.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return ".....testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return ".....testB";
    }
    @GetMapping("/testHotKey")
    @SentinelResource(value="testHotKey",blockHandler = "deal_testHotKey")
    public String testHostKey(@RequestParam(value="p1",required = false) String p1,
                              @RequestParam(value="p2",required = false) String p2
                              ){
            return "成功";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "/(ㄒoㄒ)/~~";
    }

}
