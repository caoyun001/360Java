package com.itheima.mm.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.base.BaseService;
import com.itheima.mm.dao.IndustryDao;
import com.itheima.mm.pojo.Industry;
import com.itheima.mm.service.IndustryService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/15
 * @description ：企业行业方向业务实现类
 * @version: 1.0
 */
@HmComponent("industryService")
public class IndustryServiceImpl extends BaseService implements IndustryService {
	@Override
	public List<Industry> findListAll() {
		SqlSession sqlSession = getSession();
		IndustryDao industryDao = getDao(sqlSession, IndustryDao.class);
		List<Industry> industryList =  industryDao.selectListAll();
		closeSession(sqlSession);
		return industryList;
	}
}
