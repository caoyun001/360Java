package com.itheima;

import com.itheima.dao.GoodsDao;
import com.itheima.pojo.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 *原生查询
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo05CustomMathedNameQuery {

    @Autowired
    private GoodsDao goodsDao;

    //匹配查询(match)
    @Test
    public void matchQuery(){
        List<Goods> goods = goodsDao.findAllByTitleAndPrice("小米", 99.0);
        System.out.println(goods);
    }

}
