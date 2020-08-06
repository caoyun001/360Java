package com.itheima.mm.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.base.BaseService;
import com.itheima.mm.common.QuestionConst;
import com.itheima.mm.dao.QuestionDao;
import com.itheima.mm.dao.ReviewLogDao;
import com.itheima.mm.database.MmDaoException;
import com.itheima.mm.pojo.ReviewLog;
import com.itheima.mm.service.ReviewLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/7
 * @description ：审核日志业务实现类
 * @version: 1.0
 */
@HmComponent("reviewLogService")
@Slf4j
public class ReviewLogServiceImpl extends BaseService implements ReviewLogService {
	@Override
	public void addReviewLog(ReviewLog reviewLog) {
		// 进行Dao操作
		SqlSession sqlSession = getSession();
		try{
			// 构建Dao
			ReviewLogDao reviewLogDao = getDao(sqlSession,ReviewLogDao.class);
			reviewLogDao.insertReviewLog(reviewLog);
			// 更新主表审核状态
			QuestionDao questionDao = getDao(sqlSession,QuestionDao.class);
			Map map = new HashMap<>();
			map.put("questionId",reviewLog.getQuestionId());
			if(reviewLog.getStatus() == QuestionConst.ReviewStatus.REVIEWED.ordinal()) {
				map.put("status",QuestionConst.Status.PUBLISHED.ordinal());
			}else if(reviewLog.getStatus() == QuestionConst.ReviewStatus.REJECT_REVIEW.ordinal()){
				map.put("status",QuestionConst.Status.PRE_PUBLISH.ordinal());
			}
			map.put("reviewStatus",reviewLog.getStatus());
			questionDao.updateStatusAndReviewStatus(map);
			commitAndCloseSession(sqlSession);
		}catch(MmDaoException e){
		    e.printStackTrace();
		    rollbackAndCloseSession(sqlSession);
		    log.error(e.getMessage());
		    throw  new MmDaoException(e.getMessage());
		}
	}
}
