package com.itheima.mm.pojo;

import lombok.Data;
/**
 * @author ：seanyang
 * @date ：Created in 2019/8/12
 * @description : 题目选项POJO类
 * 扩展字段为非数据库表对应字段，用于前端页面显示使用
 * @version: 1.0
 */
@Data
public class QuestionItem {

  private Integer id;
  private String content;
  private String imgUrl;
  private Integer isRight;
  private Integer questionId;
  // 扩展字段
  private String code;
  private String title;

  /**
   * 页面返回时需要boolean类型
   * @return
   */
  public boolean getIsRight() {
    return isRight == 1;
  }
}
