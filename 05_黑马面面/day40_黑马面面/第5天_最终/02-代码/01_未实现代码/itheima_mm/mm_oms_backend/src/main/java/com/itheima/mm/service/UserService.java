package com.itheima.mm.service;

import com.itheima.mm.pojo.User;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/11
 * @description ：用户业务接口
 * @version: 1.0
 */
public interface UserService {
	/**
	 * 根据用户名，获取用户信息
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

	/**
	 * 根据用户Id,获取用户授权列表
	 * @param userId
	 * @return
	 */
	List<String> findAuthorityByUserId(Integer userId);
}
