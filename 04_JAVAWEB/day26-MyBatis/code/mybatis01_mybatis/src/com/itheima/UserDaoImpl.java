package com.itheima;

import com.itheima.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    /**
     *  重写接口的方法，查询数据库
     *  需要的对象 SqlSession
     *  业务层传递的，不应该自己获取（事务安全性）
     */
    public List<User> queryUser() {
        List<User> userList = sqlSession.selectList("test.queryList");
        return userList;
    }
}
