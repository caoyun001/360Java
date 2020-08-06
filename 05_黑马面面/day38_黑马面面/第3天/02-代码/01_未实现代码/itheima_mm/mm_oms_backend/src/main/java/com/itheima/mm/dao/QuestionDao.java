package com.itheima.mm.dao;

import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/12
 * @description ：题目Dao接口
 * @version: 1.0
 */
public interface QuestionDao {

	/**
	 * 分页获取题目列表,根据否是精选题目及条件
	 * @param pageBean
	 * @return
	 */
	List<Question> selectIsClassicByPage(QueryPageBean pageBean);

	/**
	 * 根据是否是精选及条件查询条件，统计记录总数
	 * @param pageBean
	 * @return
	 */
	Long selectCountIsClassicByPage(QueryPageBean pageBean);

	/**
	 * 添加题目信息
	 * @param question
	 * @return
	 */
	Integer add(Question question);

	/**
	 * 更新题目信息
	 * @param question
	 * @return
	 */
	Integer update(Question question);

	/**
	 * 更新题目为精选题目
	 * @param id 题目ID
	 * @param isClassic 精选状态
	 * @return
	 */
	Integer updateIsClassic(@Param("id") Integer id, @Param("isClassic") Integer isClassic);
}
