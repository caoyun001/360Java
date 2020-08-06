package com.itheima.mm.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.base.BaseService;
import com.itheima.mm.dao.DictDao;
import com.itheima.mm.pojo.Dict;
import com.itheima.mm.service.DictService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/15
 * @description ：数据字段业务实现类
 * @version: 1.0
 */
@HmComponent("dictService")
public class DictServiceImpl extends BaseService implements DictService {
	@Override
	public List<Dict> selectListByType(Integer typeId) {
		SqlSession sqlSession = getSession();
		DictDao dictDao = getDao(sqlSession, DictDao.class);
		List<Dict> list = dictDao.selectListByType(typeId);
		closeSession(sqlSession);
		return list;
	}
}
