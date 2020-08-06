package com.itheima.test;

import com.itheima.mapper.OrdersMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Orders;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before()throws IOException {
        //获取输入流，绑定主配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //构建者对象、
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //方法build，传递输入流，返回SqlSessionFactory工厂对象
        sqlSessionFactory =  sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
    /**
     * 注解开发,一对多查询
     */
    public void testQueryUserOrders(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.queryUserOrders();
        for (int i = 0; i < userList.size(); i++) {
            User user =  userList.get(i);
            System.out.println(user.getUsername()+"::"+user.getOrdersList());
        }
    }

    @Test
    /**
     * 注解开发,一对一查询
     * 订单查询用户
     */
    public void testQueryOrdersUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> ordersList = mapper.queryOrdersUser();
        for (int i = 0; i < ordersList.size(); i++) {
            Orders orders =  ordersList.get(i);
            System.out.println(orders.getNumber()+"::"+orders.getUser());
        }
        sqlSession.close();
    }

    @Test
    /**
     * 注解开发遍历,主键删除
     */
    public void testDeleteUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        mapper.deleteUserById(list);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    /**
     * 注解开发动态SQL
     */
    public void testQueryUserByWhere(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setSex("1");
      //  user.setUsername("%王%");
        List<User> userList = mapper.queryUserByWhere(user);
        for (int i = 0; i < userList.size(); i++) {
            User user1 =  userList.get(i);
            System.out.println(user1);
        }
        sqlSession.close();
    }

    @Test
    /**
     * 测试注解开发查询所有用户数据
     */
    public void testQueryUser(){
        byte b = 0;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.queryUser();
        for (int i = 0; i < userList.size(); i++) {
            User user =  userList.get(i);
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    /**
     * 测试注解开发更新数据
     */
    public void updateUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(8);
        user.setUsername("吕布");
        user.setSex("1");
        user.setAddress("太原");
        int row = mapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    /**
     * 测试注解开发新增数据
     */
    public void testSaveUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setSex("2");
        user.setUsername("貂蝉");
        user.setBirthday(new Date());
        user.setAddress("汉朝");

        int row = mapper.saveUser(user);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
