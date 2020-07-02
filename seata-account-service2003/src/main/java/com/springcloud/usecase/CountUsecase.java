package com.springcloud.usecase;


import com.springcloud.usecase.repository.CountRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class CountUsecase {

    @Resource
    CountRepository countRepository;



    public void decrease(Long userId, BigDecimal money)
    {

        log.info(">>>>>>>>>>>>>>>>>扣减账户余额开始");
        // 模拟超时异常
        try{ TimeUnit.SECONDS.sleep(20);} catch (InterruptedException e ){e.printStackTrace();}
        countRepository.decrease(userId,money);
        log.info(">>>>>>>>>>>>>>>>>扣减账户余额结束");
    }

}
