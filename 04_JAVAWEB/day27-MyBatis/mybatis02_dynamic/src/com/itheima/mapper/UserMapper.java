package com.itheima.mapper;

import com.itheima.pojo.User;
import com.itheima.pojo.UserVO;

import java.util.List;

public interface UserMapper {
    /**
     * 以用户为基准,查询订单
     一对多查询
     */
    List<User> queryUserOrders();


    //查询user表全部数据
    List<User> queryUser();

    //多个条件查询
    List<User> queryUserByWhere(User user);

    //多个条件进行批量删除
    int deleteUserByList(List<Integer> idsList);

    ////多个条件进行批量删除
    int deleteUserByArray(int[] array);

    //多个条件批量删除,参数传递是VO对象
    int deleteUserByUserVO(UserVO userVO);
}
