package com.springcloud.usecase;


import com.springcloud.domain.StorageDto;

import com.springcloud.usecase.repository.StorageRepository;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class StorageUsecase {

    @Resource
    StorageRepository storageRepository;



    public void decrease(Long productId,Integer count)
    {
        storageRepository.decrease(productId,count);
    }

}
