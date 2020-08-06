package com.itheima.mm.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.base.BaseService;
import com.itheima.mm.dao.PermissionDao;
import com.itheima.mm.dao.RoleDao;
import com.itheima.mm.dao.UserDao;
import com.itheima.mm.pojo.Permission;
import com.itheima.mm.pojo.Role;
import com.itheima.mm.pojo.User;
import com.itheima.mm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

	@Override
	public List<String> findAuthorityByUserId(Integer userId) {
		List<String> authorityList = new ArrayList<>();
		// 获取角色列表
		SqlSession sqlSession = getSession();
		RoleDao roleDao = getDao(sqlSession,RoleDao.class);
		Set<Role> roles = roleDao.selectRoleByUserId(userId);
		// 获取权限列表
		PermissionDao permissionDao = getDao(sqlSession,PermissionDao.class);
		for (Role role:roles){
			authorityList.add(role.getKeyword());
			Set<Permission> permissions = permissionDao.selectPermissionByRoleId(role.getId());
			for (Permission permission:permissions){
				authorityList.add(permission.getKeyword());
			}
		}
		sqlSession.close();
		return authorityList;
	}
}
