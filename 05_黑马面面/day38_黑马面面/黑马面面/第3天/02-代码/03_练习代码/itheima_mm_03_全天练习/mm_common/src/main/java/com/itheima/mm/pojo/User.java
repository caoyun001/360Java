package com.itheima.mm.pojo;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/12
 * @description : 用户POJO类
 * 扩展字段为非数据库表对应字段
 * @version: 1.0
 */
@Data
public class User {
  private Integer id;
  private String username;
  private String password;
  private Integer state;
  private String email;
  private String source;
  private String createDate;
  private String remark;
  // 扩展字段(角色关键字、权限关键字)
  private List<String> authorityList;
}
