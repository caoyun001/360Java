package com.changgou.service;

import java.util.Map;

public interface PageService {

    /**
     * 准备模板页面所需要的的数据
     * @param spuId
     * @return
     */
    Map buildPageData(String spuId);

    /**
     * 基于模板页面生成静态页面
     * @param spuId
     */
    void createPageHtml(String spuId);
}
