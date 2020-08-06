package com.itheima.mm.service;

import com.itheima.mm.entity.PageResult;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Question;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/12
 * @description ：题目业务类
 * @version: 1.0
 */
public interface QuestionService {
	/**
	 * 分页获取题目列表
	 * @param queryPageBean
	 * @return
	 */
	PageResult findByPage(QueryPageBean queryPageBean);

	/**
	 * 新增题目
	 * @param question
	 */
	void addOrUpdate(Question question);

}
