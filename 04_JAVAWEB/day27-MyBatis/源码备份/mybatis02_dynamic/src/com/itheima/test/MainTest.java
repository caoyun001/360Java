package com.itheima.test;

import com.itheima.mapper.OrdersMapper;
import com.itheima.mapper.RoleMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Orders;
import com.itheima.pojo.Role;
import com.itheima.pojo.User;
import com.itheima.pojo.UserVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before()throws IOException{
        //获取输入流，绑定主配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //构建者对象、
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //方法build，传递输入流，返回SqlSessionFactory工厂对象
        sqlSessionFactory =  sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
    /**
     * 多表查询,用户和角色多对多
     */
    public void testQueryRoleUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roleList = mapper.queryRoleUser();
        for (int i = 0; i < roleList.size(); i++) {
            Role role =  roleList.get(i);
            System.out.println(role);
        }
        sqlSession.close();
    }

    @Test
    /**
     * 多表查询
     * 用户对订单的一对多查询
     */
    public void testQueryUserOrders(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.queryUserOrders();
        for (int i = 0; i < userList.size(); i++) {
            User user =  userList.get(i);
            System.out.println(user);
        }
    }

    @Test
    /*
     * 多表查询
     * 订单和用户的一对一查询
     */
    public void testQueryOrdersUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> ordersList = mapper.queryOrdersUser();
        for (int i = 0; i < ordersList.size(); i++) {
            Orders orders =  ordersList.get(i);
            System.out.println(orders);
        }
        sqlSession.close();
    }

    @Test
    /**
     * 多条件批量删除
     * 要删除的主键，pojo对象,封装集合
     */
    public void testDeleteUserByUserVo(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> idsList = new ArrayList<Integer>();
        idsList.add(1);
        idsList.add(2);

        UserVO userVO = new UserVO();
        userVO.setIdsList(idsList);

        mapper.deleteUserByUserVO(userVO);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    /**
     * 多条件批量删除
     * 要删除的主键，传递数组
     */
    public void testDeleteUserByArray(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int[] array = {3,4,6};
        mapper.deleteUserByArray(array);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    /**
     * 多条件批量删除
     * 要删除的主键，存储集合
     */
    public void testDeleteUserByList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> idsList = new ArrayList<Integer>();
        idsList.add(7);
        idsList.add(9);
        idsList.add(10);

        mapper.deleteUserByList(idsList);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    /**
     * 多条件的数据查询，条件是用户名或者是性别
     */
    public void testQueryUserByWhere(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //创建对象，封装查询的条件
        User user = new User();
        user.setUsername("%王%");
        user.setSex("1");
        List<User> userList = mapper.queryUserByWhere(user);
        for (int i = 0; i < userList.size(); i++) {
            User user1 =  userList.get(i);
            System.out.println(user1);
        }
        sqlSession.close();
    }

    @Test
    /**
     * 查询所有的数据user表
     */
    public void testQueryUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.queryUser();
        for (int i = 0; i < userList.size(); i++) {
            User user =  userList.get(i);
            System.out.println(user);
        }
        sqlSession.close();
    }
}
