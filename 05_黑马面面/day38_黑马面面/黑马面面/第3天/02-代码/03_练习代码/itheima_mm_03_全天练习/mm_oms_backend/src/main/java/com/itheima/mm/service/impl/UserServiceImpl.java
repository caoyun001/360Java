package com.itheima.mm.service.impl;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.mm.base.BaseService;
import com.itheima.mm.dao.PermissionDao;
import com.itheima.mm.dao.RoleDao;
import com.itheima.mm.dao.UserDao;
import com.itheima.mm.database.MmDaoException;
import com.itheima.mm.pojo.Permission;
import com.itheima.mm.pojo.Role;
import com.itheima.mm.pojo.User;
import com.itheima.mm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

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
	public List<String> getAuthList(Integer id) {
		// 通过Dao,获取角色及权限列表
		// 通过ID，获取角色列表
		// 通过角色列表，获取每个角色权限列表
		try{
			List<String> authList = new ArrayList<>();
			SqlSession sqlSession = getSession();
			RoleDao roleDao = getDao(sqlSession,RoleDao.class);
			PermissionDao permissionDao = getDao(sqlSession,PermissionDao.class);
			List<Role> roles = roleDao.selectListByUserId(id);
			// 提取角色的keyword，放入权限列表
			for (Role role:roles){
				// ROLE_QUESTION_RECORDER
				authList.add(role.getKeyword());
				// 根据当前角色ID，获取权限列表
				List<Permission> permissions = permissionDao.selectListByRoleId(role.getId());
				// 遍历权限列表，把每个权限keyword放入authList
				for (Permission permission:permissions){
					authList.add(permission.getKeyword());
				}
			}
			log.debug("获取用户ID:{},authList:{}",id,authList);
			return authList;
		}catch(MmDaoException e){
		    e.printStackTrace();
		    log.error(e.getMessage());
		    throw  new MmDaoException(e.getMessage());
		}
	}
}
