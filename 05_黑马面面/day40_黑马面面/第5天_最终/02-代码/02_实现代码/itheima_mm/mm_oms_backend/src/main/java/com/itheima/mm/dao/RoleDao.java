package com.itheima.mm.dao;

import com.itheima.mm.pojo.Role;

import java.util.Set;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/12
 * @description ：角色Dao
 * @version: 1.0
 */
public interface RoleDao {
	/**
	 * 根据用户ID，获取角色列表
	 * @param userId
	 * @return
	 */
	Set<Role> selectRoleByUserId(Integer userId);
}
