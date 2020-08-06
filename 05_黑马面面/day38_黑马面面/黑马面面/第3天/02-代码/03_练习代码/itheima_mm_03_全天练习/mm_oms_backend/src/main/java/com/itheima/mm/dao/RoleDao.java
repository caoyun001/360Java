package com.itheima.mm.dao;

import com.itheima.mm.pojo.Role;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/7
 * @description ：角色Dao接口
 * @version: 1.0
 */
public interface RoleDao {
	/**
	 * 根据用户ID，获取角色列表
	 * @param userId
	 * @return
	 */
	List<Role> selectListByUserId(Integer userId);
}
