package com.itheima.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Document 定义索引库，类型，配置索引库(分片默认5，副本默认1)
 */
@Data
@Document(indexName = "heima6",type = "goods",shards = 5,replicas = 1)
public class Goods {

    /**
     * 主键绑定
     */
    @Id
    private Long id;//商品的唯一标识
    /**
     * @Field 配置字段基本信息
     * type类型
     * analyzer分析器
     * index是否索引
     * store是否独立进行存储
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;//标题
    @Field(type = FieldType.Keyword)
    private String category;//分类
    @Field(type = FieldType.Keyword)
    private String brand;//品牌
    @Field(type = FieldType.Double)
    private Double price;//价格
    @Field(type = FieldType.Keyword,index = false)
    private String images;//图片地址
}
