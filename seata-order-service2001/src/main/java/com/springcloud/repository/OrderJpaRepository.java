package com.springcloud.repository;

import com.springcloud.repository.jpa.OrderDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderDo,Long>, QuerydslPredicateExecutor<OrderDo> {

}
