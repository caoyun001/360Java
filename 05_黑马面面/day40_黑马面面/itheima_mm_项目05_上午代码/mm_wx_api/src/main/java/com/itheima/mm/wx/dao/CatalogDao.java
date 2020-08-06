package com.itheima.mm.wx.dao;

import java.util.List;
import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/10
 * @description ：
 * @version: 1.0
 */
public interface CatalogDao {
	/**
	 * 根据条件，获取学科目录列表
	 * @param mapData
	 * @return
	 */
	List<Map> selectCatalogList(Map<String, Object> mapData);
}
