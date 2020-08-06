package com.itheima.mybatis;

import com.itheima.dao.UserDao;
import com.itheima.dao.UserDaoImpl;
import com.itheima.pojo.User;
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
 * 框架，实现对数据表user增删改查询
 * 框架使用：
 *   1：SqlSessionFactoryBuilder
 *    读取配置文件，创建出现 SqlSessionFactory
 *    方法build(输入流)  只需要绑定主文件配置文件
 *
 *  2: SqlSessionFactory 工厂对象
 *    创建 SqlSession接口实现类对象
 *
 *  3： SqlSession接口实现类对象
 *    方法，执行SQL语句
 */
public class MyBatisCURD {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
    /**
     * 本类看成业务层
     * 调用dao层，获取查询的结果
     * 获取SqlSession对象，传递到业务层
     */
    public void testDao(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = new UserDaoImpl(sqlSession);
        List<User> userList = userDao.queryUser();
        for (User user : userList){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    /**
     * 实现数据删除
     */
    public void testDeleteUserById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int row = sqlSession.delete("test.deleteUserById", 8);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(row);
    }

    @Test
    /**
     * 实现更新数据
     */
    public void testUpdateUserById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(8);
        user.setUsername("孙小妹");
        user.setSex("男");
        user.setBirthday(new Date(0));
        user.setAddress("益州");

        int row = sqlSession.update("test.updateUserById",user);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(row);
    }

    @Test
    /**
     * 实现数据的新增。SQL语句参数，封装到pojo对象中
     * SQLSession接口方法 insert
     * 注意： 新增，修改，删除，动了数据表的数据 （事务）
     * 并没有提交事务    sqlSession.commit();//提交事务
     */
    public void testSaveUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("孙尚香");
        user.setSex("女");
        user.setAddress("东吴");
        user.setBirthday( new Date());
        int row = sqlSession.insert("test.saveUser",user);

        sqlSession.commit();//提交事务

        System.out.println(row);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    /**
     * 框架:查询数据表user,根据用户名模糊查询
     * 大量的重复性代码： 代码坏味道
     * 共性抽取：
     *   目的： SqlSession接口，执行SQL语句
     *     每个功能不同的，SqlSession接口不能抽取
     *
     *     读取配置文件可以抽取
     *     SqlSessionFactory sqlSessionFactory 创建SqlSession接口对象，可以抽取
     *     工厂对象，提升为成员变量
     *
     */
    public void testQueryUserByUsername() throws IOException {
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        List<User> userList =  sqlSession.selectList("test.queryUserByUsername","%王%");
        for(User user : userList){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    /**
     * 框架:查询数据表user,根据主键查询
     */
    public void testQueryUserById() throws IOException {
        /*//1：SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //MyBatis框架提供类， Resources静态方法 getResourceAsStream() 底层封装的就是类加载器，中的流
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");//自动从src源码目录下读取文件
        SqlSessionFactory sqlSessionFactory =  sqlSessionFactoryBuilder.build(inputStream);
        //2:创建 SqlSession接口实现类对象*/

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3:方法，执行SQL语句
        //selectOne(namespace+"."+id 锁定唯一SQL,  SQL语句的实际参数)方法，查询结果一个对象
        User user =  sqlSession.selectOne("test.queryUserById",3);
        System.out.println(user);
        sqlSession.close();
    }
}
