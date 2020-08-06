package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserDao userDao = new UserDao();

    /**
     * 删除数据
     * web层传递主键
     */
    public void delete(String id){
        try {
            userDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *  修改功能
     *  web层传递User对象
     */
     public void update(User user){
         try {
             userDao.update(user);
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
    /**
     * 修改的数据回显
     * web层传递主键
     * 返回User对象
     */
    public User findById(String id){
        User user = null;
        try {
            user = userDao.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  user;
    }

    /**
     * 新增用户数据
     * web层传递pojo对象
     */
    public void register(User user){
        try {
            userDao.register(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有用户数据
     * 返回结果List
     */
    public List<User> findAll(){
        List<User> userList = null;
        try {
            userList = userDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
