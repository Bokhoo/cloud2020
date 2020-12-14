package com.atguigu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zbh
 * @date 2020/12/11
 */
@Configuration
@MapperScan("com.atguigu.springcloud.alibaba.dao")
public class MyBatisConfig {
}
