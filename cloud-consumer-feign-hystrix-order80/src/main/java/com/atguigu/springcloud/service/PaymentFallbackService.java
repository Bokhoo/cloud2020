package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author zbh
 * @date 2020/12/1
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----------PaymentFallbackService fall back paymentInfo_OK ,┭┮﹏┭┮";
    }

    @Override
    public String paymentInfo_Timout(Integer id) {
        return "----------PaymentFallbackService fall back paymentInfo_Timout ,┭┮﹏┭┮";
    }
}
