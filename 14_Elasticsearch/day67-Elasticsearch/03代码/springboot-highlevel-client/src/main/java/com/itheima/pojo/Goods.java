package com.itheima.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder//构建者模式创建goods对象
public class Goods {
    private Long id;//商品的唯一标识
    private String title;//标题
    private String subtitle;//子标题
    private String category;//分类
    private String brand;//品牌
    private Double price;//价格
    private String images;//图片地址
}
