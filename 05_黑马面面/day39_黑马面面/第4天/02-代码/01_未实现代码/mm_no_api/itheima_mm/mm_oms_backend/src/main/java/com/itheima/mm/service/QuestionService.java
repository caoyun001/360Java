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

	/**
	 * 分页获取经典题目列表
	 * @param queryPageBean
	 * @return
	 */
	PageResult findClassicByPage(QueryPageBean queryPageBean);

	/**
	 * 更新是否为经典题目
	 * @param questionId
	 * @param isClassic
	 */
	void updateIsClassic(Integer questionId,Integer isClassic);

	/**
	 * 根据题目Id ,获取题目详情信息
	 * @param id
	 * @return
	 */
	Question findQuestionById(Integer id);

}
