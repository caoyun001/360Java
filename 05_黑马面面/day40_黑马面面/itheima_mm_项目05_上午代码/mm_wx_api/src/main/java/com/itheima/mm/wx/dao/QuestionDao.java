package com.itheima.mm.wx.dao;

import com.itheima.mm.pojo.Question;

import java.util.List;
import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/10
 * @description ：题目Dao接口
 * @version: 1.0
 */
public interface QuestionDao {
	/**
	 * 获取某一分类下的题目列表
	 * @param mapData
	 * @return
	 */
	List<Question> selectQuestionListByQueryParam(Map<String, Object> mapData);
}
