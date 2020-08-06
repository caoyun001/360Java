package com.itheima.mm.wx.dao;

import java.util.List;
import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/18
 * @description ：公司Dao
 * @version: 1.0
 */
public interface CompanyDao {
	/**
	 * 根据条件获取列表
	 * @param queryParams
	 * @return
	 */
	List<Map> selectCompanyListByQueryParam(Map<String, Object> queryParams);
}
