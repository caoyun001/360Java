package com.itheima.study.mvc.dao;

import com.itheima.study.mvc.pojo.Course;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/2
 * @description ：
 * @version: 1.0
 */
public interface CourseDao {

	/**
	 * 查询所有学科列表
	 * @return
	 */
	List<Course> selectCourseList();
}
