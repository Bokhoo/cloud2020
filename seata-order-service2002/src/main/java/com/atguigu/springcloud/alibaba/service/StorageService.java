package com.atguigu.springcloud.alibaba.service;

/**
 * @author zbh
 * @date 2020/12/11
 */
public interface StorageService {

    // 扣减库存
    void decrease(Long productId, Integer count);

}
