package com.itheima.mm.pojo;

import lombok.Data;
/**
 * @author ：seanyang
 * @date ：Created in 2019/8/12
 * @description : 成员POJO类
 * @version: 1.0
 */
@Data
public class WxMember {

  private int id;
  private String nickName;
  private String avatarUrl;
  private String gender;
  private String city;
  private String province;
  private String country;
  private String language;
  private String openId;
  private String unionId;
  private String createTime;
  private Integer cityId;
  private Integer courseId;
  private Integer lastCategoryKind; // 最后做题分类种类 按技术（学科目录）-1、按企业-2、按方向-3
  private Integer lastCategoryType; // 最后做题分类类型  101-刷题,、201-错题本、202-我的练习、203-收藏题目
  private Integer lastCategoryId;   // 最后做题分类种类列表项Id  种类为1，代表学科目录ID，种类2，代表企业ID，种类3，代表行业方向Id
  private Integer lastQuestionId;   // 最后题目Id

}
