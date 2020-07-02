package com.springcloud.adapter.repository;



import com.springcloud.adapter.repository.jpa.entity.PaymentDo;
import com.springcloud.entity.PaymentEntity;
import com.springcloud.usecase.port.repository.PaymentRepository;
import lombok.var;
import org.springframework.stereotype.Component;
import com.springcloud.adapter.repository.jpa.PaymentJpaRepository;

import javax.annotation.Resource;

@Component
public class PaymentRepositoryImpl implements PaymentRepository {

    @Resource
    PaymentJpaRepository paymentJpaRepository;


    @Override
    public Long create(PaymentEntity paymentEntity) {
        var res = paymentJpaRepository.save(PaymentDo.fromEntity(paymentEntity)).toEntity();
        return res.getId();
    }

    @Override
    public PaymentEntity getPaymentById(Long id) {

        PaymentEntity paymentDto=paymentJpaRepository.findById(id).map(paymentDo -> paymentDo.toEntity()).get();
        return paymentDto;
    }
}
