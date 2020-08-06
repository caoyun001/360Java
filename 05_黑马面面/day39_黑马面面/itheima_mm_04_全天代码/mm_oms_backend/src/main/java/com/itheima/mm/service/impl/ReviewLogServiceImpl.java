package com.itheima.mm.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.base.BaseService;
import com.itheima.mm.common.QuestionConst;
import com.itheima.mm.dao.QuestionDao;
import com.itheima.mm.dao.ReviewLogDao;
import com.itheima.mm.pojo.ReviewLog;
import com.itheima.mm.service.ReviewLogService;
import com.itheima.mm.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/16
 * @description ：
 * @version: 1.0
 */
@HmComponent("reviewLogService")
@Slf4j
public class ReviewLogServiceImpl extends BaseService implements ReviewLogService {
	@Override
	public void addReviewLog(ReviewLog reviewLog) {
		SqlSession sqlSession = getSession();
		log.info("reviewLog:{}",reviewLog);
		ReviewLogDao reviewLogDao = getDao(sqlSession,ReviewLogDao.class);
		QuestionDao questionDao = getDao(sqlSession,QuestionDao.class);
		// 添加 审核记录
		reviewLog.setCreateDate(DateUtils.parseDate2String(new Date()));
		reviewLogDao.add(reviewLog);
		// 更新 题目状态
		if(reviewLog.getStatus() == QuestionConst.ReviewStatus.REVIEWED.ordinal()){
			// 审核通过
			questionDao.updateStatus(reviewLog.getQuestionId(),  QuestionConst.Status.PUBLISHED.ordinal());
		}else if (reviewLog.getStatus() == QuestionConst.ReviewStatus.REJECT_REVIEW.ordinal()
			|| reviewLog.getStatus() == QuestionConst.ReviewStatus.PRE_REVIEW.ordinal() ){
			// 审核拒绝,改为待审核状态
			questionDao.updateStatus(reviewLog.getQuestionId(),  QuestionConst.Status.PRE_PUBLISH.ordinal());
		}
		questionDao.updateReviewStatus(reviewLog.getQuestionId(),reviewLog.getStatus());
		commitAndCloseSession(sqlSession);
	}
}
