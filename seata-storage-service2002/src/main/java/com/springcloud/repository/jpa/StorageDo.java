package com.springcloud.repository.jpa;



import com.springcloud.domain.StorageDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "t_storage")
//@Table(name="t_order")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorageDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long productId;
    @Column
    private Integer total;
    @Column
    private Integer used;
    @Column
    private Integer residue;


    public static StorageDo fromEntity(StorageDto storageDto){
        return StorageDo.builder().id(storageDto.getId())
                .productId(storageDto.getProductId()).total(storageDto.getTotal()).used(storageDto.getUsed()).residue(storageDto.getResidue()).build();

    }

    public StorageDto toEntity(){
        return StorageDto.builder().id(id).total(total).productId(productId).used(used).residue(residue).build();
    }

}
