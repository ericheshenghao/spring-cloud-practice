package com.springcloud.usecase.port.service.dto;


import com.springcloud.entity.PaymentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private Long id;

    private String serial;

    // 静态方法不能调用非静态成员，编译会报错

    private static PaymentDto FromEntity(PaymentEntity paymentEntity){
        return PaymentDto.builder().id(paymentEntity.getId()).serial(paymentEntity.getSerial()).build();
    }

    private  PaymentEntity toEntity(){
        return PaymentEntity.builder().id(id).serial(serial).build();
    }
}
