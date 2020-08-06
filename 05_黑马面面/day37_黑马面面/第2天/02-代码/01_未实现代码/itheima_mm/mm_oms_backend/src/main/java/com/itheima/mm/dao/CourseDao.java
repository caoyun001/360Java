package com.itheima.mm.dao;

import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Course;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/11
 * @description ：学科Dao接口
 * @version: 1.0
 */
public interface CourseDao {
	/**
	 * 添加学科
	 * @param course
	 */
	Integer addCourse(Course course);

	/**
	 * 分页获取学科列表
	 * @param queryPageBean
	 * @return
	 */
	List<Course> selectListByPage(QueryPageBean queryPageBean);

	/**
	 * 基于条件获取学科记录总数
	 * @param queryPageBean
	 * @return
	 */
	Long selectTotalCount(QueryPageBean queryPageBean);

	/**
	 * 更新学科信息
	 * @param course
	 */
	Integer updateCourse(Course course);

	/**
	 * 删除学科信息
	 * @param id
	 */
	Integer deleteCourse(Integer id);
	/**
	 * 统计学科下标签数量
	 * @param id
	 * @return
	 */
	Long selectCountTagById(Integer id);

	/**
	 * 统计学科下目录数量
	 * @param id
	 * @return
	 */
	Long selectCountCatalogById(Integer id);

}
