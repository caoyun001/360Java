package com.itheima.mm.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.base.BaseService;
import com.itheima.mm.dao.TagDao;
import com.itheima.mm.database.MmDaoException;
import com.itheima.mm.entity.PageResult;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Tag;
import com.itheima.mm.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/13
 * @description ：学科标签业务实现类
 * @version: 1.0
 */
@HmComponent("tagService")
@Slf4j
public class TagServiceImpl extends BaseService implements TagService {
	@Override
	public void addTag(Tag tag) {
		log.info("addTag:{}",tag);
		SqlSession sqlSession = getSession();
		TagDao tagDao = getDao(sqlSession, TagDao.class);
		try{
			Integer result = tagDao.addTag(tag);
			if (result == 0){
			    throw  new MmDaoException("添加标签失败");
			}
			commitAndCloseSession(sqlSession);
		}catch(MmDaoException e){
		    log.error("addTag",e);
			closeSession(sqlSession);
		    throw  new MmDaoException(e.getMessage());
		}
	}
	@Override
	public PageResult findListByPage(QueryPageBean queryPage) {
		SqlSession sqlSession = getSession();
		// 获取分页数据集
		TagDao tagDao =  getDao(sqlSession, TagDao.class);
		List<Tag> tagList = tagDao.selectListByPage(queryPage);
		// 获取基于条件的总记录数
		Long totalCount = tagDao.selectTotalCount(queryPage);
		closeSession(sqlSession);
		return new PageResult(totalCount,tagList);
	}
	@Override
	public void deleteTag(Integer id) {
		log.info("addTag,id:{}",id);
		SqlSession sqlSession = getSession();
		TagDao tagDao = getDao(sqlSession, TagDao.class);
		try{
			Integer result = tagDao.deleteTag(id);
			if (result == 0){
				throw  new MmDaoException("删除标签失败");
			}
			commitAndCloseSession(sqlSession);
		}catch(MmDaoException e){
			log.error("deleteTag",e);
			closeSession(sqlSession);
			throw  new MmDaoException(e.getMessage());
		}
	}
}
