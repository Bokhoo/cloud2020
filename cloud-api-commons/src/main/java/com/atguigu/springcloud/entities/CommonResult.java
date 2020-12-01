package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zbh
 * @date 2020/11/27
 */
@Data//lombook
@AllArgsConstructor//全参
@NoArgsConstructor//空参
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public  CommonResult(Integer code, String message){
        this(code,message,null);
    }

}
