package com.springcloud.usecase.repository;


import com.springcloud.domain.OrderDto;
import org.springframework.data.repository.query.Param;

public interface OrderRepository {
    // 1.新建订单
    void create(OrderDto orderDto);

    // 1.修改订单状态，从零改为1
    void update(@Param("userId") Long userId,@Param("status") Integer status);
}

