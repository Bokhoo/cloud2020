package com.atguigu.springcloud.service;

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


    public String paymentInfo_Timeout(Integer id){

        int timeoutNum = 3;
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(timeoutNum);
        }catch (InterruptedException e){
            e.printStackTrace();

        }

        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_Timeout, id: "+"\t"+id+"\t"+"O(∩_∩)O哈哈~"+" 耗时"+timeoutNum+"秒钟";
    }
}
