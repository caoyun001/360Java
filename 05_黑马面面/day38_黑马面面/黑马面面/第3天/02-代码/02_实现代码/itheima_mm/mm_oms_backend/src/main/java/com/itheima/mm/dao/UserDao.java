package com.itheima.mm.dao;

import com.itheima.mm.pojo.User;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/11
 * @description ：用户Dao
 * @version: 1.0
 */
public interface UserDao {
	/**
	 * 根据用户获取用户信息
	 * @param username
	 * @return
	 */
	User findByUsername(String username);
}