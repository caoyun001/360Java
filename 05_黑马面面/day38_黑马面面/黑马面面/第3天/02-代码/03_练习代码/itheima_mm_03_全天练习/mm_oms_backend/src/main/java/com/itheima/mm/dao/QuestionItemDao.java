package com.itheima.mm.dao;

import com.itheima.mm.pojo.QuestionItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/15
 * @description ：选项Dao接口
 * @version: 1.0
 */
public interface QuestionItemDao {

	/**
	 * 添加选项
	 * @param questionItem
	 */
	Integer addQuestionItem(QuestionItem questionItem);

	/**
	 * 更新选项
	 * @param questionItem
	 */
	Integer updateQuestionItem(QuestionItem questionItem);


}
