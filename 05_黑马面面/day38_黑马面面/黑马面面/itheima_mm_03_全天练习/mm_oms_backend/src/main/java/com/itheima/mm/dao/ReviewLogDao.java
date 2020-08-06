package com.itheima.mm.dao;

import com.itheima.mm.pojo.ReviewLog;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/14
 * @description ：审核日志Dao
 * @version: 1.0
 */
public interface ReviewLogDao {
	/**
	 * 新增日志
	 * @param reviewLog
	 */
	void insertReviewLog(ReviewLog reviewLog);

	/**
	 * 获取题目最后一条审核记录
	 * @param questionId
	 * @return
	 */
	ReviewLog selectLastByQuestionId(Integer questionId);
}
