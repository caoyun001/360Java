package com.itheima;

import com.itheima.dao.GoodsDao;
import com.itheima.pojo.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 文档的基本操作
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo02DocCRUD {

    @Autowired
    private GoodsDao goodsDao;

    //新增文档
    @Test
    public void saveDoc(){
        Goods goods = new Goods();
        goods.setId(1l);
        goods.setTitle("小米手机");
        goods.setCategory("手机");
        goods.setBrand("小米");
        goods.setPrice(19999.0);
        goods.setImages("http://image.leyou.com/12479122.jpg");
        goodsDao.save(goods);
    }
    //批量新增
    @Test
    public void saveAll(){
        List<Goods> goodsList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Goods goods = new Goods();
            goods.setId((long) i);
            goods.setTitle("["+i+"]小米手机");
            goods.setCategory("手机");
            goods.setBrand("小米");
            goods.setPrice((double) i);
            goods.setImages("http://image.leyou.com/12479122.jpg");
            goodsList.add(goods);
        }
        goodsDao.saveAll(goodsList);
    }
    //修改
    @Test
    public void updateDoc(){
        Goods goods = new Goods();
        goods.setId(1l);
        goods.setTitle("大米手机");
        goods.setCategory("手机");
        goods.setBrand("小米");
        goods.setPrice(999.0);
        goods.setImages("http://image.leyou.com/12479122.jpg");
        goodsDao.save(goods);
    }
    //查询
    //根据id查询
    @Test
    public void findById(){
        Optional<Goods> goods = goodsDao.findById(1L);
        Goods g = goods.get();
        System.out.println(g);
    }
    //删除文档
    @Test
    public void deleteById(){
        goodsDao.deleteById(1L);
    }
    //批量删除
    @Test
    public void deleteAll(){
        goodsDao.deleteAll();;
    }
    //查询所有
    @Test
    public void findAll(){
        goodsDao.findAll().forEach(goods -> System.out.println(goods));
    }
    //分页查询
    @Test
    public void findByPage(){
        goodsDao.findAll(PageRequest.of(1,10)).forEach(goods -> System.out.println(goods));
    }
    //排序
    @Test
    public void findBySort(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        goodsDao.findAll(sort).forEach(goods -> System.out.println(goods));
    }
    //匹配查询(match)
    //关键词精确查询(term)
    //布尔查询
    //范围查询
    //模糊查询

    //高亮查询


}
