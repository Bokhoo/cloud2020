package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zbh
 * @date 2020/11/27
 */
@Data//lombook
@AllArgsConstructor//全参
@NoArgsConstructor//空参
public class Payment implements Serializable {

    private long id;
    private String serial;

}
