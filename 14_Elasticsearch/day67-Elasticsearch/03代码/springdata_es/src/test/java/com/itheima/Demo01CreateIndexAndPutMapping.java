package com.itheima;

import com.itheima.pojo.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 索引库的操作
 * 映射的配置
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo01CreateIndexAndPutMapping {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void createIndex() {
        elasticsearchTemplate.createIndex(Goods.class);//创建索引库
        elasticsearchTemplate.putMapping(Goods.class);//配置映射
    }
    @Test
    public void deleteIndex(){
        elasticsearchTemplate.deleteIndex(Goods.class);//删除索引
    }

}
