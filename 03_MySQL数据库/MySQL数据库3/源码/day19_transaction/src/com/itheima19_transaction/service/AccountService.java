package com.itheima.service;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.utils.DruidUtils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 转账的业务层
 * 接收用户输入数据 (表现层接收,传递过来)
 * 调用dao层,获取余额,更新余额
 */
public class AccountService {
    /**
     * 创建方法,实现转账
     * 参数,付款人,收款人,金额
     */
    public void transfer(String fukuan, String shoukuan,double money){
        //调用dao层,先查询账户的余额
        AccountDao accountDao  = new AccountDao();
        Connection con = null;
        try {
            //业务层获取数据库连接对象
            con = DruidUtils.getConnection();
            //修改隔离级别con.setTransactionIsolation(Connection接口静态成员变量);
            //开启事务,阻止自动提交
            con.setAutoCommit(false);

            //dao层方法,查询账户,付款人
            Account accountFukuan = accountDao.queryAccount(fukuan, con);
            //dao层方法,查询账户,收款人
            Account accountShoukuan = accountDao.queryAccount(shoukuan, con);

            System.out.println(accountFukuan);//Account(id=1, name=tom, money=10000.0)
            System.out.println(accountShoukuan);//Account(id=2, name=jerry, money=10000.0)

            //accountFukuan的余额 - 1000
            accountFukuan.setMoney(  accountFukuan.getMoney() - money);
            //accountShoukuan的余额 + 1000
            accountShoukuan.setMoney( accountShoukuan.getMoney() + money );
            //调用dao层方法update转账
            accountDao.updateAccount(fukuan, accountFukuan.getMoney(),con );
            //int a = 1/0;
            accountDao.updateAccount(shoukuan,accountShoukuan.getMoney(),con);

            //SQL语句执行成功,提交事务
            //DBUtils工具类,提交事务并释放资源
            DbUtils.commitAndCloseQuietly(con);
        }catch (SQLException ex){
            ex.printStackTrace();
            //SQL执行失败,回滚
            // DBUtils工具类,回滚事务并释放资源
            DbUtils.rollbackAndCloseQuietly(con);

        }finally {
            // DBUtils工具类,释放资源
            DbUtils.closeQuietly(con);
        }

    }
}
