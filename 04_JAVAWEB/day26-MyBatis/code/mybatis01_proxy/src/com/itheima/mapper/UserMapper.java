package com.itheima.mapper;

import com.itheima.pojo.User;
import com.itheima.pojo.UserVO;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * 操作数据表user的接口
 */
public interface UserMapper {
    /**
     * 用户名模糊查询
     * 方法的参数是UserVO对象
     * UserVO对象中包装User对象
     * User对象中，包含用户名
     */
    List<User> queryUserByName(UserVO userVO);


    /**
     * 新增数据
     */
    //@Insert(" insert into user values (null,#{username},#{sex},#{birthday},#{address})")
    int saveUser(User user);

    /**
     * 根据主键查询一个用户
     */
    User queryUserById(Integer id);

    /**
     * 查询所有数据
     */
    List<User> queryUser();


}
