package com.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RootDto<T>
{
    private Integer code;
    private String  message;
    private T       data;

    public RootDto(Integer code, String message)
    {
        this(code,message,null);
    }
}

