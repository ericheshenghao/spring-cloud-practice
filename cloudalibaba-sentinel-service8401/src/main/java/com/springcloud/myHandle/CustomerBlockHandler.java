package com.springcloud.myHandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.usecase.port.service.dto.PaymentDto;
import com.springcloud.usecase.port.service.dto.RootDto;

public class CustomerBlockHandler {
    public static RootDto hanlerException(BlockException exception){
        return new RootDto(4444,"按客戶自定义,全局");
    }

    public static RootDto hanlerException2(BlockException exception){
        return new RootDto(4444,"按客戶自定义,全局");
    }
}
