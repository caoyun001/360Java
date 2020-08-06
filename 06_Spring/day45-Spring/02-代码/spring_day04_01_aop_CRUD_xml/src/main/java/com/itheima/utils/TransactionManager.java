package com.itheima.utils;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 事务的切面通知类
 */
public class TransactionManager {

    //依赖注入
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //初始化方法(作用: 当前线程与 Connection绑定)
    public void init(){
        TransactionSynchronizationManager.initSynchronization();
    }

    //开启事务方法
    public void begin(){
        try {
            DataSourceUtils.getConnection(dataSource).setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交事务方法
    public void commit(){
        try {
            DataSourceUtils.getConnection(dataSource).commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //回滚事务方法
    public void rollback(){
        try {
            DataSourceUtils.getConnection(dataSource).rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //释放连接方法
    public void close(){
        try {
            DataSourceUtils.getConnection(dataSource).close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
