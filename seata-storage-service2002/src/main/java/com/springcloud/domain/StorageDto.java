package com.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StorageDto
{
    private Long id;

    private Long productId;

    private Integer total;

    private Integer used;

    private Integer residue;

}

