package com.itheima.mm.wx.service;

import java.util.List;
import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/10
 * @description ：
 * @version: 1.0
 */
public interface CategoryService {
	/**
	 * 获取题目分类列表
	 * @param mapData
	 * @return
	 */
	List<Map> findCategoryList(Map<String, Object> mapData);

	/**
	 * 获取某一分类下的分类信息及题目列表
	 * @param mapData
	 * @return
	 */
	Map<String, Object> findCategoryQuestionList(Map<String, Object> mapData);
}
