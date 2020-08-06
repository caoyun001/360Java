package com.itheima.mm.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.base.BaseService;
import com.itheima.mm.dao.CatalogDao;
import com.itheima.mm.database.MmDaoException;
import com.itheima.mm.entity.PageResult;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Catalog;
import com.itheima.mm.service.CatalogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/13
 * @description ：学科目录业务实现类
 * @version: 1.0
 */
@HmComponent("catalogService")
@Slf4j
public class CatalogServiceImpl extends BaseService implements CatalogService {
	@Override
	public void addCatalog(Catalog catalog) {
		SqlSession sqlSession = getSession();
		CatalogDao catalogDao = getDao(sqlSession,CatalogDao.class);
		log.info("addCataglog:{}",catalog);
		try{
			Integer result = catalogDao.addCatalog(catalog);
			if (result == 0){
				throw  new MmDaoException("删除学科目录失败");
			}
			commitAndCloseSession(sqlSession);
		}catch(MmDaoException e){
			log.error("addCatalog",e);
			closeSession(sqlSession);
			throw  new MmDaoException(e.getMessage());
		}
	}

	@Override
	public PageResult findListByPage(QueryPageBean queryPageBean) {
		// 获取数据集
		SqlSession sqlSession = getSession();
		CatalogDao catalogDao =  getDao(sqlSession,CatalogDao.class);
		List<Catalog> catalogList = catalogDao.selectListByPage(queryPageBean);
		// 获取总记录数
		Long totalCount = catalogDao.selectTotalCount(queryPageBean);
		closeSession(sqlSession);
		return new PageResult(totalCount,catalogList);
	}

	@Override
	public void deleteCatalog(Integer id) {
		SqlSession sqlSession = getSession();
		CatalogDao catalogDao = getDao(sqlSession,CatalogDao.class);
		log.info("deleteCatalog:id:{}",id);
		try{
			Integer result = catalogDao.deleteCatalog(id);
			if (result == 0){
				throw  new MmDaoException("删除学科目录失败");
			}
			commitAndCloseSession(sqlSession);
		}catch(MmDaoException e){
			closeSession(sqlSession);
			log.error("deleteCatalog",e);
			throw  new MmDaoException(e.getMessage());
		}
	}

}
