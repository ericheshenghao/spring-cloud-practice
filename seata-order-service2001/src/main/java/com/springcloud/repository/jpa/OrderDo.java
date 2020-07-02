package com.springcloud.repository.jpa;



import com.springcloud.domain.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "t_order")
//@Table(name="t_order")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long productId;

    @Column
    private Integer count;

    @Column
    private BigDecimal money;
    @Column(columnDefinition = "int default 0")
    private Integer status; //订单状态：0：创建中；1：已完结

    public static OrderDo fromEntity(OrderDto orderDto){
        return OrderDo.builder().id(orderDto.getId()).userId(orderDto.getUserId())
                .productId(orderDto.getProductId()).count(orderDto.getCount()).money(orderDto.getMoney()).build();

    }

    public OrderDto toEntity(){
        return OrderDto.builder().id(id).userId(userId).productId(productId).count(count).money(money).status(status).build();
    }

}
