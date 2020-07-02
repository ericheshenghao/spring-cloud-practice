package com.springcloud.adapter.repository.jpa;

import com.springcloud.adapter.repository.jpa.entity.PaymentDo;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.querydsl.QuerydslPredicateExecutor;
        import org.springframework.stereotype.Repository;

@Repository
public interface PaymentJpaRepository extends JpaRepository<PaymentDo, Long>, QuerydslPredicateExecutor<PaymentDo> {
}
