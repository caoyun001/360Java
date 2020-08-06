package com.itheima.mm.dao;

import com.itheima.mm.pojo.Industry;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/14
 * @description ：企业方向Dao接口
 * @version: 1.0
 */
public interface IndustryDao {

	/**
	 * 获取全部行业列表
	 * @return
	 */
	List<Industry> selectListAll();

	/**
	 * 根据公司ID，获取行业列表
	 * @param id
	 * @return
	 */
	List<Industry> selectIndustryListByCompany(Integer id);

	/**
	 * 新增行业方向
	 * @param industry
	 * @return
	 */
	Integer add(Industry industry);

}
