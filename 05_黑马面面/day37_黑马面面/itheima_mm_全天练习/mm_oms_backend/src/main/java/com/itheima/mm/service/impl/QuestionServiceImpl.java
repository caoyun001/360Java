package com.itheima.mm.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.base.BaseService;
import com.itheima.mm.common.QuestionConst;
import com.itheima.mm.dao.CompanyDao;
import com.itheima.mm.dao.QuestionDao;
import com.itheima.mm.dao.QuestionItemDao;
import com.itheima.mm.dao.TagDao;
import com.itheima.mm.database.MmDaoException;
import com.itheima.mm.entity.PageResult;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.*;
import com.itheima.mm.service.QuestionService;
import com.itheima.mm.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/5
 * @description ：题库业务实现类
 * @version: 1.0
 */
@HmComponent("questionService")
@Slf4j
public class QuestionServiceImpl extends BaseService implements QuestionService {
	@Override
	public PageResult findListByPage(QueryPageBean queryPageBean) {
		log.debug("QuestionServiceImpl-queryPageBean:{}",queryPageBean);
		if(queryPageBean.getQueryParams() == null){
			Map map = new HashMap<>();
			// 查询基础题库
			map.put("isClassic",0);
			queryPageBean.setQueryParams(map);
		}
		// 调用Dao
		try{
			SqlSession sqlSession = getSession();
			QuestionDao questionDao = getDao(sqlSession, QuestionDao.class);
			// 获取结果集
			List<Question> questionList = questionDao.selectListByPage(queryPageBean);
			// 获取记录数
			Long total = questionDao.selectCount(queryPageBean);
			sqlSession.close();
			return new PageResult(total,questionList);
		}catch(MmDaoException e){
		    e.printStackTrace();
		    log.error(e.getMessage());
		    throw  new MmDaoException(e.getMessage());
		}
	}

	@Override
	public void addOrUpdate(Question question) {
		SqlSession sqlSession = getSession();
		try{
			log.debug("Service addOrUpdate:{}",question);
			// 保存题目信息
			 updateQuestion(sqlSession,question);
			 // 保存题目选项信息
			 updateQuestionItem(sqlSession,question);
			 // 保存标签信息（题目与标签关系）
			 updateQuestionTag(sqlSession,question);
			 // 更新企业及行业信息
			 updateCompany(sqlSession,question);
			// 保存提交
			commitAndCloseSession(sqlSession);
		}catch(MmDaoException e){
			//  回滚
			rollbackAndCloseSession(sqlSession);
		    e.printStackTrace();
		    log.error(e.getMessage());
		    throw  new MmDaoException(e.getMessage());
		}
	}
	// 更新题目基本信息
	private void updateQuestion(SqlSession sqlSession,Question question){
		// 题目初始化（isClass=0,status=0,reviewStatus=0,createDate）
		question.setIsClassic(QuestionConst.ClassicStatus.CLASSIC_STATUS_NO.ordinal());
		question.setStatus(QuestionConst.Status.PRE_PUBLISH.ordinal());
		question.setReviewStatus(QuestionConst.ReviewStatus.PRE_REVIEW.ordinal());
		question.setCreateDate(DateUtils.parseDate2String(new Date()));
		QuestionDao questionDao = getDao(sqlSession,QuestionDao.class);
		if(question.getId() == 0){
			// 新增
			questionDao.add(question);
			log.debug("新增成功: question:id:{}",question.getId());
		}else{
			questionDao.update(question);
			log.debug("更新成功");
		}
	}

	/**
	 * 更新题目选项
	 * @param sqlSession
	 * @param question
	 */
	private void updateQuestionItem(SqlSession sqlSession,Question question){
		// 构建QuestionItemDao对象
		QuestionItemDao questionItemDao = getDao(sqlSession,QuestionItemDao.class);
		// 遍历选项列表，逐一保存
		for (QuestionItem questionItem:question.getQuestionItemList()){
			// 其中某一题目选项
			// 设置选项的QuestionId
			questionItem.setQuestionId(question.getId());
			if(questionItem.getContent() == null || questionItem.getContent().length()==0){
				if(questionItem.getImgUrl()==null || questionItem.getImgUrl().length() == 0){
					continue;
				}
			}
			// 判断是添加还是更新
			if(questionItem.getId() == 0){
				// 保存
				questionItemDao.addQuestionItem(questionItem);
			}else{
				// 更新
				questionItemDao.updateQuestionItem(questionItem);
			}
		}
	}

	/**
	 * 更新题目标签关系
	 * @param sqlSession
	 * @param question
	 */
	private void updateQuestionTag(SqlSession sqlSession,Question question){
		// 构建Dao
		TagDao tagDao = getDao(sqlSession,TagDao.class);
		// 删除旧关系
		tagDao.deleteTagListByQuestionId(question.getId());
		// 新增新关系
		// 遍历标签
		for (Tag tag:question.getTagList()){
			// 构建关系 （questionId,tagId）
			Map map = new HashMap();
			map.put("questionId",question.getId());
			map.put("tagId",tag.getId());
			tagDao.addQuestionTag(map);
		}
	}

	/**
	 * 更新公司及行业信息
	 * @param sqlSession
	 * @param question
	 */
	private void updateCompany(SqlSession sqlSession,Question question){
		// 更新公司信息
		CompanyDao companyDao = getDao(sqlSession,CompanyDao.class);
		Company company = question.getCompany();
		company.setUserId(question.getUserId());
		companyDao.updateCompanyCity(company);
		// 更新公司及行业关系
		// 删除旧公司行业关系
		companyDao.deleteCompanyIndustryByCompanyId(company.getId());
		// 新增企业及行业关系
		for (Industry industry : company.getIndustryList()){
			// 构建关系
			Map map = new HashMap();
			map.put("companyId",company.getId());
			map.put("industryId",industry.getId());
			companyDao.addCompanyIndustry(map);
		}
	}
}
