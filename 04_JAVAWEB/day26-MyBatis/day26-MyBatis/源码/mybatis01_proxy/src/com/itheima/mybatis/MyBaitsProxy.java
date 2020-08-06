package com.itheima.mybatis;

import com.itheima.mapper.OrdersMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Orders;
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
import java.util.Date;
import java.util.List;

/**
 * MyBatis动态代理开发 （以后都使用方式） 简化开发
 * 限制：
 *   dao层包名，修改为mapper
 *   定义接口 UserMapper,查询所有数据的方法（抽象）
 *   MyBatis框架，自动为我们生成接口的实现类对象
 *
 *   UserMapper.xml配置文件，配置的是user表的SQL语句
 *   配置文件，必须和接口在同一目录下
 *
 *   配置文件中的属性 namespace，的属性值必须和接口的全类名一致
 *
 *   接口中的方法名,必须和SQL语句标签的id值相同
 *   参数和返回值都必须相同
 *
 *   XXXMapper.xml配置文件的路径不要写错
 *
 */
public class MyBaitsProxy {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        sqlSessionFactory =  sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
    /**
     * 动态代理，代理的接口是OrdersMapper接口
     */
    public void testQueryOrders(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> ordersList = ordersMapper.queryOrders();
        for (int i = 0; i < ordersList.size(); i++) {
            Orders orders =  ordersList.get(i);
            System.out.println(orders);
        }
    }


    @Test
    /**
     * 动态代理方式，代理mapper包下的接口
     * 用户名模糊查询
     */
    public void testQueryUserByName(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper( UserMapper.class );
        User user = new User();
        user.setUsername("%王%");

        UserVO userVO = new UserVO();
        userVO.setUser(user);

        List<User> userList = userMapper.queryUserByName(userVO);
        for (int i = 0; i < userList.size(); i++) {
            User user1 =  userList.get(i);
            System.out.println(user1);
        }
        sqlSession.close();
    }

    /**
     * 动态代理方式，代理mapper包下的接口
     * 数据新增
     */
    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("赵云");
        user.setSex("男");
        user.setAddress("河北正定");
        user.setBirthday(new Date());

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper( UserMapper.class );
        int row = userMapper.saveUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 动态代理方式，代理mapper包下的接口
     * 主键查询
     */
    @Test
    public void testQueryUserById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserById(6);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    /**
     * 动态代理方式，代理的是mapper包下的接口
     */
    public void testQueryUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession接口方法 getMapper()
        /*
             参数是被代理的接口的class文件对象
             返回值就是被代理接口的实现类对象

             UserMapper接口的实现类
         */
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.queryUser();
        for(User user : userList){
            System.out.println(user);
        }
        sqlSession.close();
    }
}







