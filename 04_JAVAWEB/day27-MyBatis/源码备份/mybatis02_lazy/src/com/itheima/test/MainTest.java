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
import java.util.List;

public class MainTest {

    /**
     *  延迟加载: 一个SQL语句,被拆分为了多个
     *  需要数据,就查询,不需要就不查询
     *
     *  现在社会: 高并发,海量数据时代
     *  让用户去等待第二次查询吗
     */

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
     * 多表查询
     * 用户对订单的一对多查询
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
     * 查询语句,SQL查询了订单和用户
     * 运行时期,输出订单数据,没有用户数据
     * 查询用户数据是浪费资源
     * 延迟查询,需要的就查,不需要不查,不用该代码
     */
    public void testQueryOrdersUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> ordersList = mapper.queryOrdersUser();
        for (int i = 0; i < ordersList.size(); i++) {
            Orders orders =  ordersList.get(i);
            //输出对象,打印toString()
            System.out.println(orders.getId()+"::"+orders.getUserId()+"::"+orders.getNumber()+"::"+orders.getUser());
         //   System.out.println(orders);
        }
    }
}
