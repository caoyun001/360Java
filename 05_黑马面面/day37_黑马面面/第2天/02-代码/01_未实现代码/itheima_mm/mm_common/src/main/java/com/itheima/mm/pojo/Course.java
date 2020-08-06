package com.itheima.mm.pojo;

import lombok.Data;

import java.util.List;
/**
 * @author ：seanyang
 * @date ：Created in 2019/8/12
 * @description : 学科POJO类
 * 扩展字段为非数据库表对应字段，用于前端页面显示使用
 * @version: 1.0
 */
@Data
public class Course {

  private Integer id;
  private String name;    // 学科名
  private String icon;    //
  private String createDate;
  private Integer isShow;     // 0 显示  1 不显示
  private Integer userId;
  private Integer orderNo;    // 显示顺序权重，提高该值的显示顺序

  //  学科下的目录列表
  private List<Catalog> catalogList;
  //  学科下的标签列表
  private List<Tag> tagList;

  // 扩展字段，用户前端页面显示
  private String creator; // 创建者
  private Integer catalogQty; // 学科目录数量
  private Integer tagQty;     // 学科标签数量
  private Integer questionQty; // 题目数量
  private String title;

}
