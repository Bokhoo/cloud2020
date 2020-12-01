package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author zbh
 * @date 2020/11/30
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
