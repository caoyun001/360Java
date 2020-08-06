package com.itheima;

import com.itheima.dao.GoodsDao;
import com.itheima.pojo.Goods;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *原生查询
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo04NativeQuery {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    //匹配查询(match)
    @Test
    public void matchQuery(){
        //创建原生查询对象
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //设置分页
        queryBuilder.withPageable(PageRequest.of(1,10));
        //设置高亮
        //queryBuilder.withHighlightBuilder();
        //设置排序
        //queryBuilder.withSort();
        AggregatedPage<Goods> aggregatedPage = elasticsearchTemplate.queryForPage(queryBuilder.build(), Goods.class);
        for (Goods goods : aggregatedPage) {
            System.out.println(goods);
        }
    }

}
