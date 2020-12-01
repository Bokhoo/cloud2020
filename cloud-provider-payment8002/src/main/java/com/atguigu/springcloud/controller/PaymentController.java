package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zbh
 * @date 2020/11/27
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        if (result>0){
            return new CommonResult(200,"插入数据库成功"+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){

        Payment pay = paymentService.getPaymentById(id);
        if (pay != null){
            return new CommonResult(200,"查询成功"+serverPort,pay);
        }else {
            return new CommonResult(444,"没有对应记录,查询id: "+id,null);
        }
    }
    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

}
