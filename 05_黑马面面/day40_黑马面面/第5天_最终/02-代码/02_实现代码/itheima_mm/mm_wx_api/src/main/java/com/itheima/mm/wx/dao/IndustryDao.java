package com.itheima.mm.wx.dao;

import java.util.List;
import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/18
 * @description ：企业方向Dao
 * @version: 1.0
 */
public interface IndustryDao {
	/**
	 * 根据条件获取列表
	 * @param queryParams
	 * @return
	 */
	List<Map> selectIndustryListByQueryParam(Map<String, Object> queryParams);
}
