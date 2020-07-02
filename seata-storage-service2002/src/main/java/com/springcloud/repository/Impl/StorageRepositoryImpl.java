package com.springcloud.repository.Impl;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springcloud.domain.StorageDto;
import com.springcloud.repository.StorageJpaRepository;

import com.springcloud.repository.jpa.QStorageDo;
import com.springcloud.usecase.repository.StorageRepository;
import lombok.var;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class StorageRepositoryImpl implements StorageRepository {
    @Resource
    StorageJpaRepository storageJpaRepository;

    @Resource
    JPAQueryFactory jpaQueryFactory;


    @Override
    @Transactional
    public void decrease(Long productId, Integer count) {
        QStorageDo storage = QStorageDo.storageDo;
       var res =  jpaQueryFactory.update(storage).where(storage.productId.eq(productId))
               .set(storage.used,storage.used.add(count)).set(storage.residue,storage.residue.subtract(count)).execute();
        System.out.println(res);
    }
}
