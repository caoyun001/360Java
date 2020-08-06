package com.itheima.mm.pojo;

import lombok.Data;

import java.util.Collection;
import java.util.List;
/**
 * @author ：seanyang
 * @date ：Created in 2019/8/12
 * @description : 公司POJO类
 * 扩展字段为非数据库表对应字段，用于前端页面显示使用
 * @version: 1.0
 */
@Data
public class Company {

  private Integer id;
  private String shortName;   // 公司简称
  private String fullName;    // 公司全称
  private Integer isFamous;   // 是否名企
  private Integer state;
  private String remark;
  private String createDate;
  private Integer cityId;
  private Integer userId;
  private Integer orderNo; // 显示顺序权重，提高该值的显示顺序

  private List<Industry> industryList;

  // 扩展字段
  private  String city; // 城市名称
  private List<String> industryNameList; // 所属行业名称列表
}
