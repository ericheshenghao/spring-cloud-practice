package com.springcloud.usecase.repository;


import com.springcloud.domain.RootDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;


public interface CountRepository {

   void decrease(@Param("userId")Long userId,@Param("money") BigDecimal money);
}
