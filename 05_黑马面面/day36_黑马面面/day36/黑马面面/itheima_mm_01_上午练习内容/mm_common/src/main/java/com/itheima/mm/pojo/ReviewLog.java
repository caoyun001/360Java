package com.itheima.mm.pojo;

import lombok.Data;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/12
 * @description : 题目审核POJO类
 * 扩展字段为非数据库表对应字段，用于前端页面显示使用
 * @version: 1.0
 */
@Data
public class ReviewLog {

  private Integer id;
  private String comments;
  private Integer status;
  private Integer questionId;
  private Integer userId;
  private String createDate;
  // 扩展字段
  private String reviewer;       // 审核人
}
