package com.itheima;

import com.itheima.dao.GoodsDao;
import com.itheima.pojo.Goods;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 文档的基本操作
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo03Search {

    @Autowired
    private GoodsDao goodsDao;


    //匹配查询(match)
    @Test
    public void matchQuery(){
        goodsDao.search(QueryBuilders.matchQuery("title","小米"))
                .forEach(goods -> System.out.println(goods));
    }
    //关键词精确查询(term)
    //布尔查询
    @Test
    public void boolQuery(){
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.matchQuery("title","小米"));
        boolQueryBuilder.mustNot(QueryBuilders.matchQuery("title","手机"));
        boolQueryBuilder.should(QueryBuilders.matchQuery("title","电视"));
        Iterable<Goods> goods = goodsDao.search(boolQueryBuilder);
        goods.forEach(System.out::println);
    }
    //范围查询
    //模糊查询
}
