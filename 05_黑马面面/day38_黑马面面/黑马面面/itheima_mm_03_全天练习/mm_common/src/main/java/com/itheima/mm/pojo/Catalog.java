package com.itheima.mm.pojo;

import lombok.Data;
/**
 * @author ：seanyang
 * @date ：Created in 2019/8/12
 * @description : 学科目录POJO类
 * 扩展字段为非数据库表对应字段，用于前端页面显示使用
 * @version: 1.0
 */
@Data
public class Catalog {
  private Integer id;
  private String name;  // 学科目录名
  private String createDate;
  private Integer status;   // 0 启动 1 禁用
  private Integer userId;
  private Integer courseId;
  private Integer orderNo; // 显示顺序权重，提高该值的显示顺序
  // 扩展字段，用于前台显示
  private String creator; // 创建者
  private Integer questionQty;   // 面试题数量;
  private Course course;  // 所属学科
  private String courseName;  // 所属学科名称
}
