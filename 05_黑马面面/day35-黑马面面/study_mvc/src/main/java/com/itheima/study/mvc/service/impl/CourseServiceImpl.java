package com.itheima.study.mvc.service.impl;

import com.itheima.study.mvc.dao.CourseDao;
import com.itheima.study.mvc.dao.UserDao;
import com.itheima.study.mvc.pojo.Course;
import com.itheima.study.mvc.service.CourseService;
import com.itheima.study.mvc.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/24
 * @description ：学科业务实现类
 * @version: 1.0
 */
public class CourseServiceImpl implements CourseService {
	@Override
	public List<Course> findAll() {

		SqlSession sqlSession = SqlSessionUtils.openSession();
		CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
		List<Course> courseList = courseDao.selectCourseList();
		sqlSession.close();
		System.out.println("findAll...."+courseList.size());
		return courseList;
		// 模拟实现
		//List<Course> courseList = new ArrayList<>();
		//Course c1 = new Course(1,"Java");
		//Course c2 = new Course(2,"Python");
		//Course c3 = new Course(3,"PHP");
		//Course c4 = new Course(4,"C#");
		//courseList.add(c1);
		//courseList.add(c2);
		//courseList.add(c3);
		//courseList.add(c4);
		//System.out.println("CourseServiceImpl 从数据库获取所有学科...");
		//return courseList;
	}
}
