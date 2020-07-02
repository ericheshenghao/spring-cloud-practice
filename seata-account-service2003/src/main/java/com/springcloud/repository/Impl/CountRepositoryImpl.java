package com.springcloud.repository.Impl;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springcloud.repository.CountJpaRepository;

import com.springcloud.repository.jpa.QCountDo;
import com.springcloud.usecase.repository.CountRepository;
import lombok.var;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Component
public class CountRepositoryImpl implements CountRepository {
    @Resource
    CountJpaRepository countJpaRepository;

    @Resource
    JPAQueryFactory jpaQueryFactory;


    @Override
    @Transactional
    public void decrease(Long userId, BigDecimal money) {
        QCountDo count = QCountDo.countDo;

        var res= jpaQueryFactory.update(count).where(count.userId.eq(userId))
                .set(count.residue,count.residue.subtract(money)).set(count.used,count.used.add(money)).execute();
        System.out.println(userId+""+money+""+count.residue.hashCode()+money);
    }
}
