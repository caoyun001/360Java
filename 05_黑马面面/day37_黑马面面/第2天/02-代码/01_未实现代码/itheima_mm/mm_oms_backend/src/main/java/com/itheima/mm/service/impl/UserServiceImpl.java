package com.itheima.mm.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.base.BaseService;
import com.itheima.mm.dao.UserDao;
import com.itheima.mm.pojo.User;
import com.itheima.mm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/11
 * @description ：用户业务实现类
 * @version: 1.0
 */
@HmComponent("userService")
@Slf4j
public class UserServiceImpl extends BaseService implements UserService {
	@Override
	public User findByUsername(String username) {
		log.info("UserServiceImpl findByUsername:{}",username);
		SqlSession sqlSession = getSession();
		UserDao userDao = getDao(sqlSession,UserDao.class);
		User user = userDao.findByUsername(username);
		closeSession(sqlSession);
		return user;
	}
}
