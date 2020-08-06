package com.itheima.mm.service;

import com.itheima.mm.pojo.ReviewLog;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/7
 * @description ：审核日志业务接口
 * @version: 1.0
 */
public interface ReviewLogService {

	/**
	 * 添加审核日志
	 * @param reviewLog
	 */
	void addReviewLog(ReviewLog reviewLog);
}
