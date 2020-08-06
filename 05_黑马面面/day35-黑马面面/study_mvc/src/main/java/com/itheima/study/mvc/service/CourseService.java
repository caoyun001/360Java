package com.itheima.study.mvc.service;

import com.itheima.study.mvc.pojo.Course;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/24
 * @description ：学科业务接口
 * @version: 1.0
 */
public interface CourseService {
	/**
	 * 获取所有学科
	 * @return
	 */
	List<Course> findAll();
}
