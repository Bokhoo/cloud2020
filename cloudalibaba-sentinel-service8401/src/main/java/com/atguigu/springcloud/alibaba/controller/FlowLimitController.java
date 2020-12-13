package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zbh
 * @date 2020/12/10
 */
@RestController
@Slf4j
public class FlowLimitController
{
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {

        return "------testB";
    }

    @GetMapping("/testD")
    public String testD()
    {
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");

        return "------testD";
    }
    @GetMapping("/testE")
    public String testE()
    {
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        // 在给定的时间内以秒为单位,错误失败的请求占总请求的0-1 百分比 则服务熔断降级
        log.info("testE 异常比例");
        int age = 10/0;
        return "------testE";
    }
    @GetMapping("/testF")
    public String testF()
    {
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        // 在给定的时间内以秒为单位,有多少错误失败请求则服务熔断
        log.info("testF 异常数");

        return "------testF";
    }

    @GetMapping("/testHotKey")
    //                唯一表示              违背热点规则则由这个处理,兜底方法
                                                            /*
                                                            * 如果没有blockHandler就不会有兜底的方法,错误会打到页面上
                                                            * */
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(
            @RequestParam(value = "p1",required = false) String p1,
            @RequestParam(value = "p2",required = false) String p2
    ){
        // int age = 10/0; 这个是runTimeException SentinelResource处理的是Sentinel控制台配置的违规情况,有blockHandler方法配置的兜底处理
        // runTimeException @SentinelResource 不管
        //int age = 10/0;
        return "---------testHotKey";
    }
    // 方法testHotKey里面第一个参数只要qps超过每秒1此,马上降级处理
    public String deal_testHotKey(String p1, String p2, BlockException blockException){

        // sentinel系统默认的提示: Blocked by Sentinel (flow limiting)
        // 参数索引为传入参数的下标,流控模式仅支持qps
        return "---------deal_testHotKey";
    }
}