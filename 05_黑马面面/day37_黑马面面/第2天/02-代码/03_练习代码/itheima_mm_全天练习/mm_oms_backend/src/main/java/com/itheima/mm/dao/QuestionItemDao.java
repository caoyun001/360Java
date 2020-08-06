package com.itheima.mm.dao;

import com.itheima.mm.pojo.QuestionItem;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/5
 * @description ：题目选项Dao接口
 * @version: 1.0
 */
public interface QuestionItemDao {
	/**
	 * 新增题目选项
	 * @param questionItem
	 */
	void addQuestionItem(QuestionItem questionItem);

	/**
	 * 更新题目选项
	 * @param questionItem
	 */
	void updateQuestionItem(QuestionItem questionItem);
}
