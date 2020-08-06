package com.itheima.mm.dao;

import com.itheima.mm.pojo.Permission;

import java.util.Set;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/12
 * @description ：权限Dao
 * @version: 1.0
 */
public interface PermissionDao {
	/**
	 * 根据角色ID，获取权限列表
	 * @param roleId
	 * @return
	 */
	Set<Permission> selectPermissionByRoleId(Integer roleId);
}
