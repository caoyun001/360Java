package com.itheima.mm.wx.service;

import java.util.List;
import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/18
 * @description ：首页业务接口
 * @version: 1.0
 */
public interface CategoryService {
	/**
	 * 根据条件，获取首页题库分类列表
	 * @param queryMap
	 * @return
	 */
	List<Map> findCategory(Map<String, Object> queryMap);

	/**
	 * 根据条件，获取题库某一分类下的题目列表
	 * @param queryMap
	 * @return
	 */
	Map findCategoryQuestion(Map<String,Object> queryMap);

	/**
	 * 提交答案
	 * @param mapMap
	 */
	void commitQuestion(Map<String,Object> mapMap);

	/**
	 * 收藏
	 * @param mapMap
	 */
	void favoriteQuestion(Map<String,Object> mapMap);
}
