package com.itheima.mm.wx.dao;

import java.util.List;
import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/18
 * @description ：学科目录Dao
 * @version: 1.0
 */
public interface CatalogDao {
	/**
	 * 根据条件获取列表
	 * @param queryParams
	 * @return
	 */
	List<Map> selectCatalogListByQueryParam(Map<String, Object> queryParams);
}
