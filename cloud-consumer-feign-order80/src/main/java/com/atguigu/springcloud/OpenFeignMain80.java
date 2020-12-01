package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zbh
 * @date 2020/12/1
 */
@SpringBootApplication
@EnableFeignClients
public class OpenFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignMain80.class,args);
    }

}
