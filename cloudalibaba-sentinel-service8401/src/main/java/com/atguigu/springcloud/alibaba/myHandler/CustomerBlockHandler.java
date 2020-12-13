package com.atguigu.springcloud.alibaba.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @author zbh
 * @date 2020/12/10
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException blockException){
        return new CommonResult(4444,"按客户自定义,global handlerException--------------1");
    }
    public static CommonResult handlerException2(BlockException blockException){
        return new CommonResult(4444,"按客户自定义,global handlerException--------------2");
    }
}
