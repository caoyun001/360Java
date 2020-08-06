package com.itheima.mm.service;

import com.itheima.mm.entity.PageResult;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Course;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/4
 * @description ：学科业务接口
 * @version: 1.0
 */
public interface CourseService {
	/**
	 * 添加学科
	 * @param course 表单数据
	 */
	void addCourse(Course course);

	/**
	 * 根据条件分页获取数据
	 * @param queryPageBean
	 * @return
	 */
	PageResult findListByPage(QueryPageBean queryPageBean);

	/**
	 * 更新学科
	 * @param course
	 */
	void updateCourse(Course course);
}
