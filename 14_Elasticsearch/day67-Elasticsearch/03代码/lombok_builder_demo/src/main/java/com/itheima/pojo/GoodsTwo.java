package com.itheima.pojo;

import lombok.*;

/**
 * 使用Lombok
 */
//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode
@Data//一个顶四个
//@NoArgsConstructor//空参数构造
//@AllArgsConstructor//全参数构造
@Builder//构建对象注解
public class GoodsTwo {
    private Long id;//商品的唯一标识
    private String title;//标题
    private String category;//分类
    private String brand;//品牌
    private Double price;//价格
    private String images;//图片地址
}
