package com.itheima.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.dao.UserDao;
import com.itheima.pojo.User;
import com.itheima.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

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
            clearRedis();
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
             clearRedis();
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
            clearRedis();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有用户
     * 查询内存数据库redis
     *
     * 实现思想：
     *   关系数据库MySQL和内存数据库redis配合
     *   1： 先查询内存数据库
     *     内存数据库没有数据
     *     再查询MySQL，获取结果集List
     *     集合转json存储内存数据库
     *     返回集合
     *
     *   2： 先查询内存数据库
     *     有数据，不会找MySQL
     *     取出内存数据库中的数据（json）
     *     转成集合返回
     *
     */
    public List<User> findAll(){
        List<User> userList = null;
        Jedis jedis = JedisPoolUtils.getJedis();
        ObjectMapper mapper = new ObjectMapper();
        try {
            //获取内存数据库中的数据 （String）
            String userData = jedis.get("userData");
            //判断如果字符串是空的。查询MySQL
            if (userData == null) {
                userList = userDao.findAll();
                //集合转Json存储到内存数据库
                String json = mapper.writeValueAsString(userList);
                jedis.set("userData", json);
            } else {
                    //字符串不是空，内存数据库有数据，转成集合
                    userList = mapper.readValue(userData, new TypeReference<List<User>>() {
                });
            }
        }catch (Exception ex){ex.printStackTrace();}
        jedis.close();
        return userList;
    }

    /**
     * 定义方法，同步内存数据库
     * 删除原有的键
     * 只要操作了MySQL的数据改变，调用此方法
     */
    private void clearRedis(){
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.del("userData");
        jedis.close();
    }

    /**
     * 查询所有用户数据
     * 返回结果List

    public List<User> findAll(){
        List<User> userList = null;
        try {
            userList = userDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    } */
}
