package com.itheima.mm.service;

import com.itheima.mm.pojo.ReviewLog;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/16
 * @description ：审核业务类接口
 * @version: 1.0
 */
public interface ReviewLogService {
	/**
	 * 添加审核记录
	 * @param reviewLog
	 */
	void addReviewLog(ReviewLog reviewLog);
}
