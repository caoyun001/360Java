package com.changgou.service;

import java.util.Map;

public interface EsSearchService {

    /**
     * ES的综合搜索
     * @param searchMap
     * @return
     */
    Map search(Map<String,String> searchMap);
}
