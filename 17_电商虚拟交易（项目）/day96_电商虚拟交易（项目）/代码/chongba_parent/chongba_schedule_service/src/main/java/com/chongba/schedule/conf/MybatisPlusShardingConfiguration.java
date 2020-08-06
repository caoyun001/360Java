package com.chongba.schedule.conf;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by 传智播客*黑马程序员.
 */
@Configuration
@AutoConfigureAfter(DataSource.class)
public class MybatisPlusShardingConfiguration {


    //获取sharding 数据源
    @Autowired
    private DataSource dataSource;

    @Bean
    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean(){
        MybatisSqlSessionFactoryBean mysqlplus = new MybatisSqlSessionFactoryBean();
        mysqlplus.setDataSource(dataSource);
        mysqlplus.setPlugins(new Interceptor[]{ new OptimisticLockerInterceptor()});
        return mysqlplus;
    }
}
