package com.itheima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 事务管理器 配置文件
 */
public class TransactionConfig {

    //配置Spring提供的事务管理器对象
    @Bean
    public DataSourceTransactionManager createDataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        //配置(数据源)
        transactionManager.setDataSource(dataSource);

        return transactionManager;
    }

}
