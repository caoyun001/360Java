package com.itheima.old_configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author: hero brother
 * @date: Created in 2019/10/1
 * @description:
 * @version: 1.0
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcConfiguration {

    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    /**
     * 配置数据源对象
     */
    @Bean("dataSource")
    public DataSource createDataSource(){
        return null;
    }

}
