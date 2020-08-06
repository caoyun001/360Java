package com.itheima.dao;

import com.itheima.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * 继承通用的repository。
 * ElasticsearchRepository<"实体类","实体类的注解的数据类型">，常用所有功能默认实现
 */
public interface GoodsDao extends ElasticsearchRepository<Goods,Long> {
    //根据title及price查询
    List<Goods> findAllByTitleAndPrice(String title,Double price);
}
