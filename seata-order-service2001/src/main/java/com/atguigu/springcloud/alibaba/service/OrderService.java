package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.Order;

/**
 * @author zbh
 * @date 2020/12/11
 */
public interface OrderService {
    //新建订单
    void create(Order order);

    //修改订单状态，从零改为1
    //void update(@Param("userId") Long userId, @Param("status") Integer status);
}
