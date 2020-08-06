package com.itheima.mm.dao;

import com.itheima.mm.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：seanyang
 * @date ：Created in 2019/11/4
 * @description ：用户Dao接口
 * @version: 1.0
 */
public interface UserDao {
	/**
	 * 根据用户名获取用户对象
	 * @param username 用户名
	 * @return
	 */
	User selectUserByUsername(@Param("username") String username);
}
