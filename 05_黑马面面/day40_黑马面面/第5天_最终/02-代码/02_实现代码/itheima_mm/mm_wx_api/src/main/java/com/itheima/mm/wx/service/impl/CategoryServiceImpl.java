package com.itheima.mm.wx.service.impl;

import com.alibaba.fastjson.JSON;
import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.base.BaseService;
import com.itheima.mm.common.QuestionConst;
import com.itheima.mm.database.SqlSessionUtils;
import com.itheima.mm.wx.dao.*;
import com.itheima.mm.wx.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/18
 * @description ：首页业务实现类
 * @version: 1.0
 */
@HmComponent("categoryService")
@Slf4j
public class CategoryServiceImpl extends BaseService implements CategoryService {
	@Override
	public List<Map>findCategory(Map<String, Object> queryMap) {
		log.info("findCategory query:{}",queryMap);
		Integer categoryKind = 0;
		try{
			categoryKind = (Integer) queryMap.get("categoryKind");
		}catch(RuntimeException e){
			categoryKind = Integer.parseInt((String)queryMap.get("categoryKind"));
		}
		log.info("categoryKind:{}",categoryKind);
		List<Map> categoryList = null;
		if(categoryKind == QuestionConst.CategoryKind.CATALOG.getId()){
			// 查询以学科目录为主题的题目列表
			log.info("查询以学科目录为主题的题目列表");
			queryMap.put("status", QuestionConst.CatalogStatus.ENABLE.ordinal());
			SqlSession sqlSession = SqlSessionUtils.openSession();
			CatalogDao catalogDao = sqlSession.getMapper(CatalogDao.class);
			categoryList = catalogDao.selectCatalogListByQueryParam(queryMap);
			sqlSession.close();
			return categoryList;
		}else if(categoryKind == QuestionConst.CategoryKind.COMPANY.getId()){
			// 查询以企业为主题分类的题目列表
			log.info("查询以企业为主题分类的题目列表");
			// 查询以企业为主题分类的题目列表
			SqlSession sqlSession = SqlSessionUtils.openSession();
			CompanyDao companyDao = sqlSession.getMapper(CompanyDao.class);
			// 根据企业的ID，获取某一企业信息
			categoryList = companyDao.selectCompanyListByQueryParam(queryMap);
			sqlSession.close();
			return categoryList;
		}else if(categoryKind == QuestionConst.CategoryKind.INDUSTRY.getId()){
			// 查询以分类为主题分类的题目列表
			log.info("查询以分类为主题分类的题目列表");
			SqlSession sqlSession = SqlSessionUtils.openSession();
			IndustryDao industryDao = sqlSession.getMapper(IndustryDao.class);
			// 根据行业方向ID，获取某一行业信息
			categoryList = industryDao.selectIndustryListByQueryParam(queryMap);
			sqlSession.close();
			return categoryList;
		}else{
			return new ArrayList<>();
		}
	}

	@Override
	public Map findCategoryQuestion(Map<String, Object> queryMap) {
		log.info("findCategoryQuestion query:{}",queryMap);
		Integer categoryKind = (Integer) queryMap.get("categoryKind");
		Map resultMap = null ;
		if(categoryKind == QuestionConst.CategoryKind.CATALOG.getId()){
			log.info("查询以学科目录为主题的题目列表");
			SqlSession sqlSession = SqlSessionUtils.openSession();
			QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
			// 查询以学科目录为主题的题目列表
			queryMap.put("status",QuestionConst.CatalogStatus.ENABLE.ordinal());
			CatalogDao catalogDao = sqlSession.getMapper(CatalogDao.class);
			// 根据学科的ID，获取某一学科信息
			List<Map> categoryList = catalogDao.selectCatalogListByQueryParam(queryMap);
			if(categoryList != null && categoryList.size()>0 ){
				resultMap = categoryList.get(0);
				List<Map> questionList = questionDao.selectQuestionListByQueryParam(queryMap);
				resultMap.put("items",questionList);
			}
			sqlSession.close();
			return resultMap;
		}else if(categoryKind == QuestionConst.CategoryKind.COMPANY.getId()){
			// 查询以企业为主题分类的题目列表
			log.info(" 查询以企业为主题分类的题目列表");
			// 查询以企业为主题分类的题目列表
			SqlSession sqlSession = SqlSessionUtils.openSession();
			QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
			CompanyDao companyDao = sqlSession.getMapper(CompanyDao.class);
			// 根据企业的ID，获取某一企业信息
			List<Map> categoryList = companyDao.selectCompanyListByQueryParam(queryMap);
			if(categoryList != null && categoryList.size()>0 ){
				resultMap = categoryList.get(0);
				List<Map> questionList = questionDao.selectQuestionListByQueryParam(queryMap);
				resultMap.put("items",questionList);
			}
			sqlSession.close();
			return resultMap;
		}else if(categoryKind == QuestionConst.CategoryKind.INDUSTRY.getId()){
			// 查询以分类为主题分类的题目列表
			log.info(" 查询以分类为主题分类的题目列表");
			// 查询以分类为主题分类的题目列表
			SqlSession sqlSession = SqlSessionUtils.openSession();
			QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
			IndustryDao industryDao = sqlSession.getMapper(IndustryDao.class);
			// 根据行业方向ID，获取某一行业信息
			List<Map> categoryList = industryDao.selectIndustryListByQueryParam(queryMap);
			if(categoryList != null && categoryList.size()>0){
				resultMap = categoryList.get(0);
				List<Map> questionList = questionDao.selectQuestionListByQueryParam(queryMap);
				resultMap.put("items",questionList);
			}
			sqlSession.close();
			return resultMap;
		}else{
			return new HashMap();
		}
	}

	@Override
	public void commitQuestion(Map<String, Object> mapParams) {
		Integer type = (Integer) mapParams.get("type");
		Integer answerTag = null;
		if( type == QuestionConst.Type.SINGLE.getId() || type == QuestionConst.Type.MULTIPLE.getId()){
			//  单选题及选择题
			Boolean answerIsRight = (Boolean) mapParams.get("answerIsRight");
			answerTag = answerIsRight?QuestionConst.AnswerTag.PERFECT.ordinal():QuestionConst.AnswerTag.WRONG.ordinal();
			String jsonStr = JSON.toJSONString(mapParams.get("answerResult"));
			mapParams.put("answerResult",jsonStr);
			mapParams.put("answerTag",answerTag);
		}else if(type == QuestionConst.Type.SIMPLE.getId()){
			//  简单题	判断理想、不理想
			Boolean answerIsRight = (Boolean) mapParams.get("answerIsRight");
			answerTag = answerIsRight?QuestionConst.AnswerTag.GOOD.ordinal():QuestionConst.AnswerTag.BAD.ordinal();
			mapParams.put("answerTag",answerTag);
		}
		// 收藏处理
		if( mapParams.get("isFavorite") != null){
			Boolean bl = (Boolean) mapParams.get("isFavorite");
			mapParams.put("isFavorite",bl?1:0);
		}else{
			mapParams.put("isFavorite",null);
		}
		log.info("add commitQuestion:{}",mapParams);
		SqlSession sqlSession = SqlSessionUtils.openSession();
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		// 提交答题
		Integer result =questionDao.upateMemberQuestion(mapParams);
		if (result == 0){
			questionDao.addMemberQuestion(mapParams);
		}
		// 更新会员，更新最后一题信息
		WxMemberDao memberDao  = sqlSession.getMapper(WxMemberDao.class);
		memberDao.updateMemberLastAnswer(mapParams);
		sqlSession.commit();
		sqlSession.close();
	}

	public void favoriteQuestion(Map<String, Object> mapParams) {
		//  收藏操作
		if( mapParams.get("isFavorite") == null){
			return;
		}
		Boolean bl = (Boolean) mapParams.get("isFavorite");
		mapParams.put("isFavorite",bl?1:0);
		log.info(" favoriteQuestion:{}",mapParams);
		SqlSession sqlSession = SqlSessionUtils.openSession();
		QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
		// 收藏
		Integer result =questionDao.upateMemberQuestion(mapParams);
		if (result == 0){
			questionDao.addMemberQuestion(mapParams);
		}
		sqlSession.commit();
		sqlSession.close();
	}
}
