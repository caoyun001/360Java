package com.itheima.mm.pojo;

import lombok.Data;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/12
 * @description : 权限POJO类
 * @version: 1.0
 */
@Data
public class Permission {
  private Integer id;
  private String name;
  private String keyword;
  private String description;
}
