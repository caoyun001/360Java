package com.itheima.domain;

import lombok.Data;

import java.io.Serializable;

/**
 *   一个类包含私有成员变量,包含get/set方法,包含无参数构造
 *    称为JavaBean对象
 *    应该可以被序列化 (目前省略)
 */
@Data
public class Product {
   private int  pid ;
   private String pname ;
   private double price ;
   private String category_id ;
}
