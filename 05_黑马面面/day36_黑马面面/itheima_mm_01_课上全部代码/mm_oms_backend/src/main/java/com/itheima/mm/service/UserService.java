package com.itheima.mm.service;

import com.itheima.mm.pojo.User;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/4
 * @description ：用户业务接口
 * @version: 1.0
 */
public interface UserService {
	/**
	 * 根据用户名获取用户对象
	 * @param username 用户名
	 * @return 用户对象
	 */
	User findUserByUsername(String username);
}
