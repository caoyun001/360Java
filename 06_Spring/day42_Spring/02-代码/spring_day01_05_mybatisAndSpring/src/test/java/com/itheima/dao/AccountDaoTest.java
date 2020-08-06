package com.itheima.dao;

import com.itheima.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class AccountDaoTest {
    private SqlSession sqlSession = null;

    @Before
    public void before() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void update() throws IOException {
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        Account account = new Account();
        account.setId(3);
        account.setName("隔壁老王666");
        account.setMoney(100d);

        accountDao.update(account);
        sqlSession.commit();
    }

    @Test
    public void findByName() {
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        Account account = accountDao.findByName("隔壁老王666");
        System.out.println("account = " + account);
    }
}