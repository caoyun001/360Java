package com.itheima.mm.pojo;

import lombok.Data;

import java.util.List;
/**
 * @author ：seanyang
 * @date ：Created in 2019/8/12
 * @description : 数据字典POJO类
 * 扩展字段为非数据库表对应字段，用于前端页面显示使用
 * @version: 1.0
 */
@Data
public class Dict {
  private Integer id;
  private Integer pid;
  private Integer dataType;   // 数据类型，0-表示省 1-表示城市
  private String dataCode;    // 数据编码，
  private String dataValue;   // 数据值
  private Integer dataTag;    // 数据标记，比如省市列表中，0 表示不首页显示 1首页显示，根据业务定义
  private String dataDesc;
  private Integer orderNo;    // 显示顺序权重，提高该值的显示顺序

  // 二级数据
  private List<Dict> subList;
  // 扩展字段
  private String title;
}
