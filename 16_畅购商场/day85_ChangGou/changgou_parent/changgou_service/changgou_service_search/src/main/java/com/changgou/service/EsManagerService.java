package com.changgou.service;

public interface EsManagerService {


    /**
     * 删除索引及映射关系
     */
    void deleteIndexAndMapping();


    /**
     * 创建索引库及映射关系
     */
    void createIndexAndMapping();


    /**
     * 根据spuId查询sku数据导入ES
     * @param spuId
     */
    void importBySpuId(String spuId);


    /**
     * 导入全部sku数据到ES
     */
    void importAll();


    /**
     * 根据spuId查询sku数据从ES中删除掉
     * @param spuId
     */
    void delBySpuId(String spuId);
}
