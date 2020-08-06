package com.itheima.mm.wx.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.common.QuestionConst;
import com.itheima.mm.database.SqlSessionUtils;
import com.itheima.mm.pojo.Question;
import com.itheima.mm.wx.dao.CatalogDao;
import com.itheima.mm.wx.dao.QuestionDao;
import com.itheima.mm.wx.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/10
 * @description ：
 * @version: 1.0
 */
@HmComponent("categoryService")
@Slf4j
public class CategoryServiceImpl implements CategoryService {
	@Override
	public List<Map> findCategoryList(Map<String, Object> mapData) {
		// mapData(categoryKind(1-学科目录，2-企业，3-行业方向),categoryType-101)
		// 判断当前的categoryKind
		Integer categoryKind = (Integer) mapData.get("categoryKind");
		List<Map> mapList = new ArrayList<>();

		if(categoryKind == QuestionConst.CategoryKind.CATALOG.getId()){
			log.debug("按学科目录，获取数据");
			// 调用获取学科目录的Dao
			SqlSession sqlSession = SqlSessionUtils.openSession();
			CatalogDao catalogDao = sqlSession.getMapper(CatalogDao.class);
			// 根据条件获取数据
			mapList = catalogDao.selectCatalogList(mapData);
			sqlSession.close();
		}else if(categoryKind == 2){
			log.debug("按企业，获取数据");
		}else if(categoryKind == 3){
			log.debug("按行业方向，获取数据");
		}
		return  mapList ;
	}

	@Override
	public Map<String, Object> findCategoryQuestionList(Map<String, Object> mapData) {
		log.debug("mapData:{}",mapData);
		Map resultMap = new HashMap();
		// 获取分类种类
		Integer categoryKind = (Integer)mapData.get("categoryKind");
		if(categoryKind ==  QuestionConst.CategoryKind.CATALOG.getId()){
			log.debug("按某一学科目录获取基本信息");
			// 复用分类列表的获取，加入基于分类ID获取某一分类信息
			SqlSession sqlSession = SqlSessionUtils.openSession();
			CatalogDao catalogDao = sqlSession.getMapper(CatalogDao.class);
			QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
			// 获取的是分类列表，如果有数据，肯定只要一条数据，基于分类ID（学科目录ID）
			List<Map> mapList = catalogDao.selectCatalogList(mapData);
			if(mapList != null && mapList.size() > 0){
				resultMap = mapList.get(0);
			}
			// 获取某一分类（学科目录）下的题目列表
			List<Question> questionList = questionDao.selectQuestionListByQueryParam(mapData);
			resultMap.put("items",questionList);
			sqlSession.close();
			log.debug("按某一学科目录下的题目列表");
		}else if(categoryKind == 2){
			log.debug("按某一企业获取基本信息");
		}else if(categoryKind == 3){
			log.debug("按某一行业方向获取基本信息");
		}
		return resultMap;
	}
}
