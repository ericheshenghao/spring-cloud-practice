package com.springcloud.usecase.repository;


import com.springcloud.domain.RootDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageRepository {
    @PostMapping(value = "/storage/decrease")
    RootDto decrease(@RequestParam("productId")Long productId,@RequestParam("count") Integer count);
}
