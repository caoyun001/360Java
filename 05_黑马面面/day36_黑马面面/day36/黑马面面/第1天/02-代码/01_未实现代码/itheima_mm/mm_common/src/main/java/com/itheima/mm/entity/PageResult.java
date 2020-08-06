package com.itheima.mm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/12
 * @description : 封装分页返回结果
 * @version: 1.0
 */
@Data
@AllArgsConstructor
public class PageResult implements Serializable{
    private Long total;//总记录数
    private List rows;//当前页结果
}
