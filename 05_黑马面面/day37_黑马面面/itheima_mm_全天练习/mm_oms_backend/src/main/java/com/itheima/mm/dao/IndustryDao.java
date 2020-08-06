package com.itheima.mm.dao;

import com.itheima.mm.pojo.Industry;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/5
 * @description ：行业方向Dao
 * @version: 1.0
 */
public interface IndustryDao {
	/**
	 * 获取所有行业方向
	 * @return
	 */
	List<Industry> selectListAll();

}
