package com.itheima.mapper;


import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Mapper == @Component == @Service == @Repository == @ @Controller
 */
//当前接口的动态代理的实现类，注入Spring的容器
@Mapper
public interface UserMapper {

    /**
     * 查询所有
     */
    @Select("select * from user;")
    List<User> findAll();
}
