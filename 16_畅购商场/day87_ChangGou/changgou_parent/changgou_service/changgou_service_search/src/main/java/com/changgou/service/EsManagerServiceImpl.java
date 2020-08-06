package com.changgou.service;

import com.alibaba.fastjson.JSON;
import com.changgou.dao.SearchMapper;
import com.changgou.entity.Result;
import com.changgou.goods.feign.SkuFeign;
import com.changgou.goods.pojo.Sku;
import com.changgou.pojo.SkuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EsManagerServiceImpl implements  EsManagerService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private SearchMapper searchMapper;
    
    @Autowired
    private SkuFeign skuFeign;


    @Override
    public void deleteIndexAndMapping() {
        //elasticsearchTemplate.deleteIndex("skuinfo");
        elasticsearchTemplate.deleteIndex(SkuInfo.class);
    }


    @Override
    public void createIndexAndMapping() {
        elasticsearchTemplate.createIndex(SkuInfo.class);//创建索引库
        elasticsearchTemplate.putMapping(SkuInfo.class); //创建ES映射
    }


    @Override
    public void importBySpuId(String spuId) {
        //根据spuId查询sku列表数据
        List<Sku> skuList = skuFeign.findBySpuId(spuId);
        //将skuList转成json字符串
        String skuListJson = JSON.toJSONString(skuList);
        //将skuList的json字符串转成List<SkuInfo>
        List<SkuInfo> skuInfoList = JSON.parseArray(skuListJson, SkuInfo.class);
        if(skuInfoList!=null && skuInfoList.size()>0){
            for (SkuInfo skuInfo : skuInfoList) {
                skuInfo.setSpecMap(JSON.parseObject(skuInfo.getSpec(), Map.class));
            }
        }

        //将sku数据导入到ES中
        searchMapper.saveAll(skuInfoList);
    }


    @Override
    public void importAll() {
        //1.查询所有的sku数据
        Result all = skuFeign.findAll();
        String allJson = JSON.toJSONString(all.getData());
        List<SkuInfo> skuInfoList = JSON.parseArray(allJson, SkuInfo.class);

        if(skuInfoList!=null && skuInfoList.size()>0){
            for (SkuInfo skuInfo : skuInfoList) {
                skuInfo.setSpecMap(JSON.parseObject(skuInfo.getSpec(), Map.class));
            }
        }

        //2.将所有sku数据导入ES中
        searchMapper.saveAll(skuInfoList);
    }


    @Override
    public void delBySpuId(String spuId) {
        //1.根据spuId查询到sku数据
        List<Sku> skuList = skuFeign.findBySpuId(spuId);
        if(skuList!=null && skuList.size()>0){
            for (Sku sku : skuList) {
                //2.删除
                searchMapper.deleteById(Long.valueOf(sku.getId()));
            }
        }

    }
}
