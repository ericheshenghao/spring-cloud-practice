package com.springcloud.usecase;


import com.springcloud.domain.OrderDto;
import com.springcloud.usecase.repository.AccountRepository;
import com.springcloud.usecase.repository.OrderRepository;
import com.springcloud.usecase.repository.StorageRepository;

import com.springcloud.utilts.IdGeneratorSnowflake;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class OrderUsecase {
    @Resource
    OrderRepository orderRepository;
    @Resource
    StorageRepository storageRepository;

    @Resource
    IdGeneratorSnowflake idGeneratorSnowflake;

    @Resource
    AccountRepository accountRepository;
//    @GlobalTransactional(name="fsp-create-order",rollbackFor = Exception.class)

    public String createSnowFlake(){
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for ( int i = 1 ;i<=20;i++) {
            threadPool.submit(() -> {
                System.out.println(idGeneratorSnowflake.snowflakeId());
            });
        }

        threadPool.shutdown();
        return "hello";
    }

    public void create(OrderDto orderDto)
    {
        log.info("开始创建订单");
        orderRepository.create(orderDto);
        log.info("调用微服务");

//        storageRepository.decrease(orderDto.getProductId(),orderDto.getCount());
//        log.info("扣钱");
//        accountRepository.decrease(orderDto.getUserId(),orderDto.getMoney());
//        /// 修改订单的状态
////        log.info("修改订单的状态);"
//        orderRepository.update(orderDto.getUserId(),1);
    }

}
