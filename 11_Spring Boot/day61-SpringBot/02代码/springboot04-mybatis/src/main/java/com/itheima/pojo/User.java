package com.itheima.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer id;
    private String username;//用户名
    private String password;//密码
    private String name;//姓名
}
