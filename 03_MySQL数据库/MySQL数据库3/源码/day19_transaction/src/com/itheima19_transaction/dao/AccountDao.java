package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Comparator;

/**
 *  对数据表account的操作
 */
public class AccountDao {

    /**
     * 定义方法,实现转账,更新账户的数据
     * 传递参数,用户名,余额
     */
    public void updateAccount(String name, double money , Connection con) throws SQLException {
        //事务,不能传递连接池
        QueryRunner qr = new QueryRunner();
        //拼写更新的SQL
        String sql = "update account set money = ? where name = ?";
        qr.update(con,sql,money,name);
    }

    /**
     * 定义方法: 查账户信息
     * 传递参数,账户名,用户输入的
     * 查询后结果
     * BeanHandler封装, 结果集就是Account对象
     */
    public Account queryAccount(String name, Connection con)throws SQLException{
        //事务,不能传递连接池
        QueryRunner qr = new QueryRunner();
        //拼写查询账户的SQL
        String sql =  "select * from account where name = ?";
        //执行SQL语句,封装为Account对象
        Account account = qr.query(con,sql,new BeanHandler<Account>(Account.class),name);
        return account;
    }
}
