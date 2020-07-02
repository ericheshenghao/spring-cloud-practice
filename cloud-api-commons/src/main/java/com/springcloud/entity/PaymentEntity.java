package com.springcloud.entity;


        import lombok.AllArgsConstructor;
        import lombok.Builder;
        import lombok.Data;
        import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PaymentEntity {

    private Long id;

    private String serial;
}
