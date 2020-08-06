package com.itheima.mm.service;

import com.itheima.mm.entity.PageResult;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Question;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/5
 * @description ：题库业务接口
 * @version: 1.0
 */
public interface QuestionService {

	/**
	 * 保存题目信息
	 * @param question
	 */
	void addOrUpdate(Question question);

	/**
	 * 分页获取题目列表
	 * @param queryPageBean 查询参数
	 * @return
	 */
	PageResult findListByPage(QueryPageBean queryPageBean);
}
