package com.springcloud.repository.Impl;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springcloud.domain.OrderDto;
import com.springcloud.repository.OrderJpaRepository;
import com.springcloud.repository.jpa.OrderDo;
import com.springcloud.repository.jpa.QOrderDo;
import com.springcloud.usecase.repository.OrderRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class OrderRepositoryImpl implements OrderRepository {
    @Resource
    OrderJpaRepository orderJpaRepository;

    @Resource
    JPAQueryFactory jpaQueryFactory;

    @Override
    @Transactional
    public void create(OrderDto orderDto) {
            orderJpaRepository.save(OrderDo.fromEntity(orderDto));
    }

    @Override
    @Transactional
    public void update(Long userId, Integer status) {
        QOrderDo order = QOrderDo.orderDo;

        jpaQueryFactory.update(order).set(order.status,status).where(order.userId.eq(userId)).execute();
    }
}
