package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zbh
 * @date 2020/11/27
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced// 实现负载均衡

    /** restTemplate访问远程Http服务
     * (url,requestMap,ResponseBean.class)这是三个参数分别代表
     * REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
