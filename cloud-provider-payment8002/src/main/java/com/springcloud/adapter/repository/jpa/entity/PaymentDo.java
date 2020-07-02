package com.springcloud.adapter.repository.jpa.entity;


import com.springcloud.entity.PaymentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "payment")
//@Table(name="payment")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String serial;

   public static PaymentDo fromEntity(PaymentEntity paymentEntity){
       return PaymentDo.builder().id(paymentEntity.getId()).serial(paymentEntity.getSerial()).build();

   }

   public PaymentEntity toEntity(){
       return PaymentEntity.builder().id(id).serial(serial).build();
   }


}
