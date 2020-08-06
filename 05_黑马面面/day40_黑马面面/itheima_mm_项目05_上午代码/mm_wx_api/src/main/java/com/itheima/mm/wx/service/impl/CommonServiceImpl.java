package com.itheima.mm.wx.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.database.SqlSessionUtils;
import com.itheima.mm.pojo.Course;
import com.itheima.mm.pojo.Dict;
import com.itheima.mm.wx.dao.CourseDao;
import com.itheima.mm.wx.dao.DictDao;
import com.itheima.mm.wx.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/17
 * @description ：公共业务接口
 * @version: 1.0
 */
@HmComponent("commonService")
@Slf4j
public class CommonServiceImpl implements CommonService {

	public List<Dict> getCityList(Integer tag){
		log.info("getCityList,tag:{}",tag);
		SqlSession sqlSession = SqlSessionUtils.openSession();
		DictDao dictDao = sqlSession.getMapper(DictDao.class);
		List<Dict> dictList = dictDao.selectCityListByTag(tag);
		sqlSession.close();
		return dictList;
	}

	@Override
	public Dict getCityInfoByName(String cityName) {
		log.info("getCityInfoByName,cityName:{}",cityName);
		SqlSession sqlSession = SqlSessionUtils.openSession();
		DictDao dictDao = sqlSession.getMapper(DictDao.class);
		Dict city = dictDao.selectByCityName(cityName);
		sqlSession.close();
		return city;
	}
	@Override
	public List<Course> getCourseList() {
		log.info("getCourseList");
		SqlSession sqlSession = SqlSessionUtils.openSession();
		CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
		List<Course> courseList = courseDao.getCourseList();
		sqlSession.close();
		return courseList;
	}
}
