package com.itheima.mm.dao;

import com.itheima.mm.pojo.Permission;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/7
 * @description ：权限Dao接口
 * @version: 1.0
 */
public interface PermissionDao {
	/**
	 * 根据角色ID，获取该角色权限列表
	 * @param roleId
	 * @return
	 */
	List<Permission> selectListByRoleId(Integer roleId);
}
