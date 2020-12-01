package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.TimeUnit;

/**
 * @author zbh
 * @date 2020/12/1
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_OK, id: "+"\t"+id+"\t"+"O(∩_∩)O哈哈~";
    }


    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Timeout(Integer id){

        //int timeoutNum = 5;
        //int age = 10/0;
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();

        }

        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_Timeout, id: "+"\t"+id+"\t"+"O(∩_∩)O哈哈~"+" 耗时"+"5"+"秒钟";
    }
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池: "+Thread.currentThread().getName()+" 系统忙, 请稍后再试, id: "+"\t"+id+"\t"+"┭┮﹏┭┮";
    }
}
