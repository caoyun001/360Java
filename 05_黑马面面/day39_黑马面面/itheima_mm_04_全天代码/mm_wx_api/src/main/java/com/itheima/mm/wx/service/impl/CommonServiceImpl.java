package com.itheima.mm.wx.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.database.SqlSessionUtils;
import com.itheima.mm.pojo.Course;
import com.itheima.mm.pojo.Dict;
import com.itheima.mm.wx.dao.CourseDao;
import com.itheima.mm.wx.dao.DictDao;
import com.itheima.mm.wx.service.CommonService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/8
 * @description ：公共业务实现类
 * @version: 1.0
 */
@HmComponent("commonService")
public class CommonServiceImpl implements CommonService {
	@Override
	public List<Course> findCourseList() {
		// 调用Dao，获取学科列表
		SqlSession sqlSession = SqlSessionUtils.openSession();
		CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
		List<Course> courseList = courseDao.selectCourseList();
		return courseList;
	}

	@Override
	public Dict findDictByCityName(String cityName) {
		// 构建Dao
		SqlSession sqlSession = SqlSessionUtils.openSession();
		DictDao dictDao = sqlSession.getMapper(DictDao.class);
		Dict dict = dictDao.selectByCityName(cityName);
		sqlSession.close();
		return dict;
	}

	@Override
	public List<Dict> findDictListByFs(Integer fs) {
		SqlSession sqlSession = SqlSessionUtils.openSession();
		DictDao dictDao = sqlSession.getMapper(DictDao.class);
		List<Dict> cityList = dictDao.selectCityListByFs(fs);
		sqlSession.close();
		return cityList;
	}
}
