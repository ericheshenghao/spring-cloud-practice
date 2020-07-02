package com.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {
    ServiceInstance intances(List<ServiceInstance> serviceInstances);
}
