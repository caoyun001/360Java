package com.itheima.mm.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.base.BaseService;
import com.itheima.mm.dao.CompanyDao;
import com.itheima.mm.pojo.Company;
import com.itheima.mm.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/15
 * @description ：公司业务实现类
 * @version: 1.0
 */
@HmComponent("companyService")
@Slf4j
public class CompanyServiceImpl extends BaseService implements CompanyService {
	@Override
	public List<Company> findListAll() {
		SqlSession sqlSession = getSession();
		CompanyDao companyDao = getDao(sqlSession,CompanyDao.class);
		List<Company> companyList = companyDao.selectListAll();
		closeSession(sqlSession);
		return companyList;
	}
}
