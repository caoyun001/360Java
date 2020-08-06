package com.itheima.mm.wx.dao;

import com.itheima.mm.pojo.Course;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/8
 * @description ：学科Dao接口
 * @version: 1.0
 */
public interface CourseDao {
	/**
	 * 获取学科列表
	 * @return
	 */
	List<Course> selectCourseList();

}
