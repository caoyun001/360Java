package com.itheima.test;

import com.itheima.com.itheima.utils.BeanFactory;
import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import org.junit.Test;

/**
 * UserDao的测试用例
 */
public class TestUserDao {

    @Test
    public void test1(){
        //调用UserDao接口中的方法
        // 耦合性高
        // UserDao userDao = new UserDaoImpl();
        // userDao.register("tom","123");

        // 耦合性低 通过配置文件使用反射技术来实现
        UserDao userDao = BeanFactory.newInstance("UserDao");
        userDao.register("tom","123");

//        ProductDao dao = BeanFactory.newInstance("ProductDao");
//        dao.register("tom","123");
    }
}
