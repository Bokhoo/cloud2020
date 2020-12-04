package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbh
 * @date 2020/12/4
 */
@RestController
@Slf4j
/*
* 1.刷新功能, 配置上有修改时, 发送curl -X POST "http://localhost:3355/actuator/refresh"通知3355进行刷新, 从而达到刷新配置信息
* 2.
* */
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;


    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }


}
