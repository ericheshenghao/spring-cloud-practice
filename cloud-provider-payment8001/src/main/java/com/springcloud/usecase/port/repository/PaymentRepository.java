package com.springcloud.usecase.port.repository;

        import com.springcloud.entity.PaymentEntity;
        import org.springframework.data.repository.query.Param;


public interface PaymentRepository {
    public Long create(PaymentEntity paymentEntity);
    PaymentEntity getPaymentById(@Param("id") Long id);
}
