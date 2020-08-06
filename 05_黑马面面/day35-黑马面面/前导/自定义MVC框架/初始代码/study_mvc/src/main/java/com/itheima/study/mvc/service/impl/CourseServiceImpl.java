package com.itheima.study.mvc.service.impl;

import com.itheima.study.mvc.pojo.Course;
import com.itheima.study.mvc.service.CourseService;

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
		List<Course> courseList = new ArrayList<>();
		Course c1 = new Course(1,"Java");
		Course c2 = new Course(1,"Python");
		Course c3 = new Course(1,"PHP");
		Course c4 = new Course(1,"C#");
		courseList.add(c1);
		courseList.add(c2);
		courseList.add(c3);
		courseList.add(c4);
		System.out.println("CourseServiceImpl 从数据库获取所有学科...");
		return courseList;
	}
}
