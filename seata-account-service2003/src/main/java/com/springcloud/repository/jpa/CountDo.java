package com.springcloud.repository.jpa;



import com.springcloud.domain.CountDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "t_account")
//@Table(name="t_order")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;
    @Column
    private BigDecimal total;
    @Column
    private BigDecimal used;
    @Column
    private BigDecimal residue;


    public static CountDo fromEntity(CountDto countDto){
        return CountDo.builder().id(countDto.getId())
                .userId(countDto.getUserId()).total(countDto.getTotal()).used(countDto.getUsed()).residue(countDto.getResidue()).build();

    }

    public CountDto toEntity(){
        return CountDto.builder().id(id).total(total).userId(userId).used(used).residue(residue).build();
    }

}
