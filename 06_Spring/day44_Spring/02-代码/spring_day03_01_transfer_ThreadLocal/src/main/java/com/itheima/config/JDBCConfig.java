package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
@PropertySource({"classpath:jdbc.properties"})
public class JDBCConfig {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    //配置数据源
    @Bean("druidDataSource")
    public DataSource createDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        //配置相关信息(驱动, url, 用户名, 密码)
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);

        return druidDataSource;
    }

    //配置Connection对象
    @Bean
    public Connection createConnection(DataSource dataSource){
       /*
       当前的事务代码Connection对象 与 Mybatis中的SQLSession对象中的Connection对象 不是同一个连接对象
       使用ThreadLocal技术, 实现 SQLSession对象 与 事务代码Connection对象  是 同一个
       通过Spring框架来实现这个操作 Connection对象  是 同一个
        */
        //1. 通过Spring框架提供的事务同步管理器, 实现事务代码Connection对象 与 Mybatis中的SQLSession对象中的Connection对象 同一个
        //initSynchronization()方法中, 代码底层源码中, 通过 ThreadLocal实现了 当前线程与 Connection对象进行绑定
        TransactionSynchronizationManager.initSynchronization();
        // Spring框架提供了一个 DataSourceUtils工具类, getConnection()方法,实现了从ThreadLocal 中 绑定的Connection对象
        Connection connection = DataSourceUtils.getConnection(dataSource);
        return connection;
    }
}
