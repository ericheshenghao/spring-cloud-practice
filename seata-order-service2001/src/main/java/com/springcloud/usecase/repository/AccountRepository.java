package com.springcloud.usecase.repository;


import com.springcloud.domain.RootDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service")
public interface AccountRepository {
    @PostMapping(value = "/account/decrease")
    RootDto decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
