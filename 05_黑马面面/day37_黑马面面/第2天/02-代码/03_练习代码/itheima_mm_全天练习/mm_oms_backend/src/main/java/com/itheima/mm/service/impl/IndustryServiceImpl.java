package com.itheima.mm.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.base.BaseService;
import com.itheima.mm.dao.IndustryDao;
import com.itheima.mm.database.MmDaoException;
import com.itheima.mm.pojo.Industry;
import com.itheima.mm.service.IndustryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/5
 * @description ：行业方向业务实现列
 * @version: 1.0
 */
@HmComponent("industryService")
@Slf4j
public class IndustryServiceImpl extends BaseService implements IndustryService {
	@Override
	public List<Industry> findListAll() {
		try{
			// 创建Dao
			SqlSession sqlSession = getSession();
			IndustryDao industryDao = getDao(sqlSession, IndustryDao.class);
			// 调用Dao
			List<Industry> industryList = industryDao.selectListAll();
			sqlSession.close();
			return industryList;
		}catch(MmDaoException e){
		    e.printStackTrace();
		    log.error(e.getMessage());
		    throw  new MmDaoException(e.getMessage());
		}
	}
}
