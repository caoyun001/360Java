package com.itheima.mm.dao;

import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Course;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/4
 * @description ：学科Dao接口
 * @version: 1.0
 */
public interface CourseDao {
	/**
	 * 插入数据
	 * @param course 学科数据
	 * @return
	 */
	Integer insertCourse(Course course);

	/**
	 * 基于条件分页获取数据
	 * @param queryPageBean
	 * @return
	 */
	List<Course> selectListByPage(QueryPageBean queryPageBean);

	/**
	 * 根据条件，统计记录数
	 * @param queryPageBean
	 * @return
	 */
	Long  selectCount(QueryPageBean queryPageBean);

	/**
	 * 更新学科
	 * @param course
	 */
	void updateCourse(Course course);
}
