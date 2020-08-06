package com.itheima.mm.dao;

import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Question;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/5
 * @description ：题库Dao接口
 * @version: 1.0
 */
public interface QuestionDao {
	/**
	 * 分页获取结果集
	 * @param pageBean
	 * @return
	 */
	List<Question> selectListByPage(QueryPageBean pageBean);

	/**
	 * 根据条件获取记录数
	 * @param pageBean
	 * @return
	 */
	Long selectCount(QueryPageBean pageBean);

	/**
	 * 新增题目
	 * @param question
	 */
	void add(Question question);

	/**
	 * 更新题目
	 * @param question
	 */
	void update(Question question);
}
