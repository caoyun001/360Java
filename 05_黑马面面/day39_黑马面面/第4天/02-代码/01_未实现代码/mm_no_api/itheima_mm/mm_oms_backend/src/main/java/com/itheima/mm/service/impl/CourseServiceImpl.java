package com.itheima.mm.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.base.BaseService;
import com.itheima.mm.dao.CourseDao;
import com.itheima.mm.database.MmDaoException;
import com.itheima.mm.entity.PageResult;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Course;
import com.itheima.mm.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/11
 * @description ：学科业务实现类
 * @version: 1.0
 */
@HmComponent("courseService")
@Slf4j
public class CourseServiceImpl extends BaseService implements CourseService {
	@Override
	public void addCourse(Course course) {
		log.info("addCourse... course:{}",course);
		SqlSession sqlSession = getSession();
		try{
			CourseDao courseDao = getDao(sqlSession,CourseDao.class);
			Integer result = courseDao.addCourse(course);
			log.info("result:{}",result);
			if (result == 0){
				throw  new MmDaoException("添加学科失败");
			}
			commitAndCloseSession(sqlSession);
		}catch(MmDaoException e){
			closeSession(sqlSession);
			log.error("addCourse",e);
			throw  new MmDaoException(e.getMessage());
		}
	}

	@Override
	public PageResult findListByPage(QueryPageBean queryPageBean) {
		log.info("findListByPage:{}",queryPageBean);
		SqlSession sqlSession = getSession();
		CourseDao courseDao = getDao(sqlSession,CourseDao.class);
		// 获取分页数据集
		List<Course> courseList = courseDao.selectListByPage(queryPageBean);
		log.info("findListByPage courseList:{}",courseList);
		// 获取记录总数
		Long totalCount = courseDao.selectTotalCount(queryPageBean);
		closeSession(sqlSession);
		return new PageResult(totalCount,courseList);
	}

	@Override
	public void updateCourse(Course course) {
		log.info("updateCourse... course:{}",course);
		SqlSession sqlSession = getSession();
		try{
			CourseDao courseDao = getDao(sqlSession,CourseDao.class);
			Integer result = courseDao.updateCourse(course);
			if (result == 0){
				throw  new MmDaoException("更新学科失败，Id不存在");
			}
			commitAndCloseSession(sqlSession);
		}catch(MmDaoException e){
			closeSession(sqlSession);
			log.error("updateCourse",e);
			throw  new MmDaoException(e.getMessage());
		}
	}

	@Override
	public void deleteCourse(Integer id) {
		SqlSession sqlSession = getSession();
		log.info("deleteCourse,id:{}",id);
		try{
			CourseDao courseDao = getDao(sqlSession,CourseDao.class);
			Long cataLogQty = courseDao.selectCountCatalogById(id);
			Long tagQty = courseDao.selectCountTagById(id);
			if( cataLogQty > 0 || tagQty > 0  ){
				throw new MmDaoException("学科下有数据，不能删除学科数据");
			}
			Integer result = courseDao.deleteCourse(id);
			if (result == 0){
				throw  new MmDaoException("删除学科失败");
			}
			commitAndCloseSession(sqlSession);
		}catch(MmDaoException e){
			closeSession(sqlSession);
			log.error("deleteCourse",e);
			throw  new MmDaoException(e.getMessage());
		}
	}

	@Override
	public List<Course> findListAll() {
		SqlSession sqlSession = getSession();
		CourseDao courseDao = getDao(sqlSession, CourseDao.class);
		List<Course> courseList = courseDao.selectListAll();
		closeSession(sqlSession);
		return courseList;
	}
}
