package com.itheima.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JDBCConfig.class})
public class SpringConfig {

}
