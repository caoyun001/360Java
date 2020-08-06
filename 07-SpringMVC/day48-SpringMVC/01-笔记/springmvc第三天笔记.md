# springMVC的第三天


## 一. SpringMVC拦截器

### 1.1 认识拦截器

- Servlet：处理Request请求和Response响应
- 过滤器（Filter）：对Request请求起到过滤的作用，作用在Servlet之前，如果配置为/*可以对所有的资源访问（servlet、js/css静态资源等）进行过滤处理
- 监听器（Listener）：实现了javax.servlet.ServletContextListener 接口的服务器端组件，它随Web应用的启动而启动，只初始化一次，然后会一直运行监视，随Web应用的停止而销毁
  - 作用一：做一些初始化工作
  - 作用二：监听web中的特定事件，比如HttpSession,ServletRequest的创建和销毁；变量的创建、销毁和修改等。可以在某些动作前后增加处理，实现监控，比如统计在线人数，利用HttpSessionLisener等。
- 拦截器（Interceptor）：是SpringMVC、Struts等表现层框架自己的，不会拦截jsp/html/css/image的访问等，只会拦截访问的控制器方法（Handler）。底层采用的是aop的思想
  - 从配置的角度也能够总结发现：serlvet、filter、listener是配置在web.xml中的，而interceptor是配置在表现层框架自己的配置文件中的
  - ==在Handler业务逻辑执行之前拦截一次==
  - 在Handler逻辑执行完毕但未跳转页面之前拦截一次
  - 在跳转页面之后拦截一次

### 1.2 自定义拦截器

- 实现接口HandlerInterceptor
- 重写方法：
  - preHandle：handler之前执行，返回true表示放行
  - postHandle：handler逻辑真正执行完成但尚未返回页面
  - afterCompletion：返回页面之后
- 自定义拦截器

```java
package com.itheima.interceptor;

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器1：preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器1：postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器1：afterCompletion");
    }
}

```

- springmvc.xml配置拦截器

```xml
 <!--配置拦截器-->
    <mvc:interceptors>
        <mvc:interceptor>
            <!--拦截当前目录下的所有子目录-->
            <mvc:mapping path="/**"/>
            <bean class="com.itheima.interceptor.MyInterceptor"/>
        </mvc:interceptor>
    </mvc:interceptors>
```

- handler处理请求

```java
@Controller
@RequestMapping("default")
public class DefaultController {
    @RequestMapping("gotoResult")
    public String gotoResult(Model model){
        System.out.println("====gotoResult===");
        model.addAttribute("nowDate", new Date());
        return "result";
    }
}
```

```jsp
  <fieldset>
      <h3>测试拦截器</h3>
      <a href="${pageContext.request.contextPath}/default/gotoResult.action">点击测试拦截器</a>
  </fieldset>
```

### 1.3 拦截器链

- 拦截器链执行时，拦截器链正常流程测试
  - preHandle顺序执行
  - postHandle倒序执行
  - afterCompletion倒序执行
- 拦截器链中断流程测试
  - 拦截器链中有中断时，整个链中的拦截器的postHandle都不会执行

```xml
<mvc:interceptors>
        <mvc:interceptor>
            <mvc:mapping path="/**"/>
            <bean class="com.itheima.interceptor.MyInterceptor2"></bean>
        </mvc:interceptor>
        <mvc:interceptor>
            <mvc:mapping path="/**"/>
            <bean class="com.itheima.interceptor.MyInterceptor"></bean>
        </mvc:interceptor>

    </mvc:interceptors>
```



### 1.4 拦截器登录案例

- 需求
  - 有一个登录页面，写一个Handler用于接收登录请求, 实现页面跳转
- 登录页面有一个提交表单的动作。需要在Controller中处理
  - 判断用户名密码是否正确（zhangsan/123）
  - 如果正确，向session中写入用户信息（写入用户名username）,跳转到登录成功页面
  - 如果不正确, 跳转到登录页面
- 开发拦截器
  - 拦截用户请求，判断用户是否登录（登录页面跳转请求和登录提交请求不能拦截）
  - 如果用户已经登录则放行
  - 如果用户未登录则跳转到登录页面
- index.jsp 登录页面

```jsp
<fieldset>
    <h3>测试登录案例</h3>
    <form method="post" action="${pageContext.request.contextPath}/user/login.action">
        用户名:<input type="text" name="username"><br>
        密　码:<input type="password" name="password"><br>
        <input type="submit" value="登录">
    </form>
</fieldset>
```

- UserController

```java
package com.itheima.controller;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("login")
    public String login(String username, String password, HttpServletRequest request){
        //模拟登录
        if ("zhangsan".equals(username) && "123".equals(password)) {
            System.out.println("登录成功");
            request.getSession().setAttribute("username", username);
            //跳转show页面, 显示数据
            return "redirect:/account/findAll.action";
        } else {
            System.out.println("登录失败");
            return "redirect:/index.jsp";
        }
    }
}

```

* AccountController

```java
package com.itheima.controller;

@Controller
@RequestMapping("account")
public class AccountController {

    @RequestMapping("findAll")
    public String findAll(Model model){
        model.addAttribute("nowDate", new Date() +"====查询所有账户");
        return "result";
    }
}
```

* result.jsp

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${nowDate}
</body>
</html>
```

- 拦截器

```java
package com.itheima.interceptor;

public class LoginInterceptor implements HandlerInterceptor {
    /*
    首先判断是否登录了，如果登录了，放行，如果没有登录，跳转到登录页面
      细节：
          判断是否是登录请求，如果是登录请求，放行
          如果不是登录请求： 判断session中是否存储了用户信息
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        //判断是否是登录请求，如果是登录请求，放行
        if ("/user/login.action".equals(requestURI)) {
            return true;
        }
        //如果不是登录请求： 判断session中是否存储了用户信息
        //从session中获取用户信息
        Object username = request.getSession().getAttribute("username");
        if (username != null) {
            return true;
        } else  {
            //如果没有登录,跳转到登录页面
            response.sendRedirect("/index.jsp");
        }
        return false;
    }
}

```

- springmvc.xml

```xml
<!--拦截器-->
    <mvc:interceptors>
        <mvc:interceptor>
            <mvc:mapping path="/**"/>
            <!--资源放行-->
            <!--<mvc:exclude-mapping path="/js/**"></mvc:exclude-mapping>-->
            <!--<mvc:exclude-mapping path="/css/**"></mvc:exclude-mapping>-->
            <!--<mvc:exclude-mapping path="/fonts/**"></mvc:exclude-mapping>-->
            <bean class="com.itheima.intercetor.LoginInterceptor"></bean>
        </mvc:interceptor>
    </mvc:interceptors>
```



## 二、整合SSM框架

#### 1、整合思路

```java
a. SSM介绍
	springmvc+ spring + mybatis=ssm
	mybatis 持久层的CURD
	spring 业务层  IOC、DI(解耦) 和AOP(事务问题）
	springMVC 表现层 MVC的操作
b. 整合使用的技术
	1). Spring		5.0.2
	2). mybatis		3.4.6
	3). SpringMVC	5.0.2
	4). log4J		
	5). ElementUI	
	6). Vue		
	......
c. 业务介绍
	我们需要完成一张账户表的查询和修改功能
```

#### 2、引入依赖和依赖分析

```java
a. Spring相关的
    1). spring-context : Spring 上下文
    2). spring-tx : Spring事务
    3). spring-jdbc : SpringJDBC
    4). spring-test : Spring单元测试
    5). spring-webmvc : SpringMVC
b. mybatis相关的
    1). mybatis : mybatis核心
c. mybatis与spring整合包
    1). mybatis-spring ：mybatis与spring整合
d. 其他
    1) 切面相关的 
    	aspectjweaver : AOP切面
    2) 数据源相关（选择使用）:
    	c3p0
    	commons-dbcp
    	spring自带的数据源
    	druid : 德鲁伊
    3) 单元测试相关的:
    	junit : 单元测试,与spring-test放在一起做单元测试
    4) ServletAPI相关的
    	jsp-api : jsp页面使用request等对象
    	servlet-api : java文件使用request等对象
    5) 日志相关的: 
	  log4j2
        log4j-core : log4j2核心包
        log4j-api : log4j2的功能包
        log4j-web : 当在Web应用中使用Log4j2或者其它日志框架时,需要确保:web应用启动时,日志组件能够被启动;web应用关闭时,日志组件能够被关闭。
        slf4j-api : Simple Logging Facade for Java，为java提供的简单日志Facade。Facade门面，更底层一点说就是接口 
	    slf4j:Simple Logging Facade for Java。 它提供了Java中所有日志框架的简单抽象。 
        log4j-slf4j-impl : slf4j的log4j实现类,也就是说slf4j的日志记录功能由log4j实现
        log4j-jcl : 程序运行的时候检测用了哪种日志实现类现在叫Apache Common Logging
      log4j
      	log4j: log4j 的jar包
      	slf4j-log4j12: log4j 通过slf4j-log4j12初始化Log4j，达到最终日志的输出
    6 数据库相关的
        mysql-connector-java : mysql的数据库驱动包
    7) 页面表达式
        JSTL : JSTL标签库必须jar包 基础功能
        standard : JSTL标签库的必须jar包 进阶功能
    8) 文件上传
        commons-fileupload : 上传插件
        commons-io : IO操作包
```

```xml

<dependencies>

    <!--mybatis核心jar包-->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.2</version>
    </dependency>
    <!--spring的核心容器jar包-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.1.9.RELEASE</version>
    </dependency>
    <!--Druid数据源-->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>1.1.20</version>
    </dependency>
    <!--mysql数据库驱动-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
    </dependency>
    <!--spring的jdbc操作数据库的jar包，包含spring自带数据源，jdbcTemplate-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>5.1.9.RELEASE</version>
    </dependency>
    <!--spring整合junit的jar包-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
        <version>5.1.9.RELEASE</version>
    </dependency>
    <!--Junit测试-->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
    <!--mybatis整合spring的jar包-->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>2.0.1</version>
    </dependency>

    <!--事务管理器jar包-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-tx</artifactId>
        <version>5.1.9.RELEASE</version>
    </dependency>
    <!--aop切面-->
    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>1.9.2</version>
    </dependency>

    <!--日志开始-->
    <!--引入日志的门脸-->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-log4j12</artifactId>
        <version>1.6.1</version>
    </dependency>
    <!-- 日志工具包 -->
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-api</artifactId>
        <version>2.10.0</version>
    </dependency>
    <!--日志核心包-->
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.10.0</version>
    </dependency>
    <!--web相关的功能包-->
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-web</artifactId>
        <version>2.9.1</version>
    </dependency>
    <!--为java做简单的日志记录-->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.25</version>
    </dependency>
    <!--slf4j的log4j实现类-->
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-slf4j-impl</artifactId>
        <version>2.9.1</version>
    </dependency>
    <!--程序运行的时候检测用了哪种日志实现类-->
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-jcl</artifactId>
        <version>2.9.1</version>
    </dependency>

    <!--日志结束-->

    <!--springmvc的核心包-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.1.9.RELEASE</version>
    </dependency>

    <!-- JSTL标签库 -->
    <dependency>
        <groupId>jstl</groupId>
        <artifactId>jstl</artifactId>
        <version>1.2</version>
    </dependency>
    <dependency>
        <groupId>taglibs</groupId>
        <artifactId>standard</artifactId>
        <version>1.1.2</version>
    </dependency>
    <!--servlet-api ：引入servlet的功能-->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>servlet-api</artifactId>
        <version>2.5</version>
        <scope>provided</scope>
    </dependency>
    <!--jsp-api: jsp页面的功能包 -->
    <dependency>
        <groupId>javax.servlet.jsp</groupId>
        <artifactId>jsp-api</artifactId>
        <version>2.2</version>
        <scope>provided</scope>
    </dependency>
    <!-- 文件上传 -->
    <dependency>
        <groupId>commons-fileupload</groupId>
        <artifactId>commons-fileupload</artifactId>
        <version>1.3.1</version>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-core</artifactId>
        <version>2.9.0</version>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.9.0</version>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-annotations</artifactId>
        <version>2.9.0</version>
    </dependency>
</dependencies>
```



#### 3、表和实体类的创建

```java
1. 表
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `money` double(8,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

2. 实体类
public class Account {
    private Integer id;
    private String name;
    private Double money;
}
```

#### 4、Dao接口的编写

```java
package com.itheima.dao;

/**
 * dao接口
 */
public interface AccountDao {
    //增
    public void save(Account account);

    //删
    public void deleteById(Integer id);

    //改
    public void update(Account account);

    //查
    public List<Account> findAll();
}
```

#### 5、Dao层xml的编写

```xml
<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.itheima.dao.AccountDao">

    <!--增-->
    <insert id="save" parameterType="account">
        insert into account values(#{id}, #{name}, #{money})
    </insert>

    <!--删-->
    <delete id="deleteById" parameterType="int">
        delete from account where id=#{id}
    </delete>

    <!--改-->
    <update id="update" parameterType="account">
        update account set name=#{name}, money=#{money} where id=#{id}
    </update>

    <!--查-->
    <select id="findAll" resultType="account">
        select * from account
    </select>

</mapper>
```

#### 6、Service层接口编写

```java
package com.itheima.service;

/*
Service接口
 */
public interface AccountService {
    //增
    public void save(Account account);

    //删
    public void deleteById(Integer id);

    //改
    public void update(Account account);

    //查
    public List<Account> findAll();
}
```

#### 7、Service层实现类编写

```java
package com.itheima.service.impl;

/*
接口实现类
 */
@Service
public class AccountServiceImpl implements AccountService {

    //依赖注入
    @Autowired
    //@Qualifier("accountDao")
    private AccountDao accountDao;

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void deleteById(Integer id) {
        accountDao.deleteById(id);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
```

#### 8、dao和service配置文件

```java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/tx
       http://www.springframework.org/schema/tx/spring-tx.xsd
       http://www.springframework.org/schema/aop
       http://www.springframework.org/schema/aop/spring-aop.xsd
">

    <!--dao层开始-->
        <!--引入属性文件-->
        <context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
        <!--数据源-->
        <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
            <property name="driverClassName" value="${jdbc.driverClassName}"/>
            <property name="url" value="${jdbc.url}"/>
            <property name="username" value="${jdbc.username}"/>
            <property name="password" value="${jdbc.password}"/>
        </bean>
        <!--创建SqlSessionFactory对象-->
        <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
            <!--数据源-->
            <property name="dataSource" ref="dataSource"></property>
            <!--别名映射-->
            <property name="typeAliasesPackage" value="com.itheima.pojo"></property>
            <!--引入mybatis的核心配置文件-->
            <property name="configLocation" value="classpath:SqlMapConfig.xml"></property>
        </bean>
        <!--扫描Dao包，创建动态代理对象, 会自动存储到spring IOC容器中-->
        <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
            <!--指定要扫描的dao的包-->
            <property name="basePackage" value="com.itheima.dao"></property>
            <!--可省略的配置: 注入sqlSessionFactory-->
            <!--<property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>-->
        </bean>
    <!--dao层结束-->

    <!--service层开始-->
        <!--开启注解扫描, 扫描包-->
        <context:component-scan base-package="com.itheima.service.impl"></context:component-scan>
        <!--声明式事务管理-->
        <!--1.创建事务管理器对象-->
        <bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
            <!--注入数据源-->
            <property name="dataSource" ref="dataSource"></property>
        </bean>
        <!--2.事务增强对象-->
        <tx:advice id="txAdvice" transaction-manager="txManager">
            <tx:attributes>
                <tx:method name="insert*"/>
                <tx:method name="add*"/>
                <tx:method name="update*"/>
                <tx:method name="save*"/>
                <tx:method name="del*"/>
                <tx:method name="*" propagation="SUPPORTS" read-only="true"></tx:method>
            </tx:attributes>
        </tx:advice>
        <!--3.aop切面配置-->
        <aop:config>
            <aop:pointcut id="pc" expression="execution(* com.itheima.service.impl.*.*(..))"></aop:pointcut>
            <aop:advisor advice-ref="txAdvice" pointcut-ref="pc"></aop:advisor>
        </aop:config>
    <!--service层结束-->
</beans>
```

#### 9、controller层编写

```java
@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("findAll")
    public List<Account> findAll(){
        List<Account> accountList = accountService.findAll();
        return accountList;
    }

    @RequestMapping("update")
    public String update(@RequestBody Account account){
        accountService.update(account);
        return "success";
    }
}
```

#### 10、spring-mvc 配置文件编写

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/mvc
       http://www.springframework.org/schema/mvc/spring-mvc.xsd
">

    <!--开启注解扫描, 扫描controller-->
    <context:component-scan base-package="com.itheima.controller"></context:component-scan>
    <!--视图解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/pages/"></property>
        <property name="suffix" value=".jsp"></property>
    </bean>
    <!--mvc注册驱动-->
    <mvc:annotation-driven></mvc:annotation-driven>
    <!--自定义类型转换器-->
    <!--文件上传解析器-->
    <!--资源放行-->
    <!--如果web.xml中 使用的是 /, 那么需要资源放行-->
    <!--<mvc:resources mapping="/js/**" location="/js/"></mvc:resources>-->
    <!--<mvc:resources mapping="/css/**" location="/css/"></mvc:resources>-->
    <!--<mvc:resources mapping="/fonts/**" location="/fonts/"></mvc:resources>-->
    <!--拦截器-->
    <!--<mvc:interceptors>-->
        <!--<mvc:interceptor>-->
            <!--<mvc:mapping path="/**"/>-->
            <!--&lt;!&ndash;资源放行&ndash;&gt;-->
            <!--<mvc:exclude-mapping path="/js/**"></mvc:exclude-mapping>-->
            <!--<mvc:exclude-mapping path="/css/**"></mvc:exclude-mapping>-->
            <!--<mvc:exclude-mapping path="/fonts/**"></mvc:exclude-mapping>-->
            <!--<bean class="com.itheima.intercetor.LoginInterceptor"></bean>-->
        <!--</mvc:interceptor>-->
    <!--</mvc:interceptors>-->

</beans>
```

#### 11、编写web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">

    <!--配置全局参数-->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:ApplicationContext.xml</param-value>
    </context-param>
    
    <!--编码过滤器-->
    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!--容器加载的监听器-->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <!--
        父容器: 用于dao和service对象，存储在spring的容器中
        前端控制器: 本身也会创建一个容器，是一个Spring的子容器, 把表现层对象存储在springmvc的容器中

        访问特点:
            子容器(SpringMVC)可以访问父容器(Spring)的对象
            父容器(Spring)不能访问子容器(SpringMVC)特有的对象
    -->
    <servlet>
        <servlet-name>dispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>dispatcherServlet</servlet-name>
        <url-pattern>*.action</url-pattern>
    </servlet-mapping>
</web-app>
```

#### 12、编写页面

https://www.w3cschool.cn/bootstrap/

index.jsp

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
    <fieldset>
        <p>测试SSM框架整合</p>
        <a href="./pages/data.html">进入测试</a>
    </fieldset>
</body>
</html>
```

data.html

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>SSM框架整合</title>
        <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
        <!-- 引入样式 -->
        <link rel="stylesheet" href="../elementui/index.css">
    </head>
    <body class="hold-transition">
        <div id="app">
            <div class="content-header">
                <h1><small>账户管理</small></h1>
            </div>
            <div class="app-container">
                <div class="box">
                    <div class="filter-container">
                        <el-button type="primary" class="butT" @click="handleCreate()">新建</el-button>
                    </div>
                    <el-table size="small" current-row-key="id" :data="dataList" stripe highlight-current-row>
                        <el-table-column type="index" align="center" label="序号"></el-table-column>
                        <el-table-column prop="name" label="账户名称" align="center"></el-table-column>
                        <el-table-column prop="money" label="金额" align="center"></el-table-column>

                        <el-table-column label="操作" align="center">
                            <template slot-scope="scope">
                                <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
                                <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                    <!-- 新增标签弹层 -->
                    <div class="add-form">
                        <el-dialog title="新增账户" :visible.sync="dialogFormVisible">
                            <el-form ref="dataAddForm" :model="formData"  label-position="right" label-width="100px">
                                <el-row>
                                    <el-col :span="24">
                                        <el-form-item label="id" >
                                            <el-input v-model="formData.id"/>
                                        </el-form-item>
                                    </el-col>
                                </el-row>

                                <el-row>
                                    <el-col :span="24">
                                        <el-form-item label="账户名称">
                                            <el-input v-model="formData.name" type="text"></el-input>
                                        </el-form-item>
                                    </el-col>
                                </el-row>
                                <el-row>
                                    <el-col :span="24">
                                        <el-form-item label="金额">
                                            <el-input v-model="formData.money" type="text"></el-input>
                                        </el-form-item>
                                    </el-col>
                                </el-row>
                            </el-form>
                            <div slot="footer" class="dialog-footer">
                                <el-button @click="dialogFormVisible = false">取消</el-button>
                                <el-button type="primary" @click="handleAdd()">确定</el-button>
                            </div>
                        </el-dialog>
                    </div>

                    <!-- 编辑标签弹层 -->
                    <div class="add-form">
                        <el-dialog title="编辑账户" :visible.sync="dialogFormVisible4Edit">
                            <el-form ref="dataAddForm" :model="formData"  label-position="right" label-width="100px">
                                <el-row>
                                    <el-col :span="24">
                                        <el-form-item label="id" >
                                            <el-input v-model="formData.id"/>
                                        </el-form-item>
                                    </el-col>
                                </el-row>

                                <el-row>
                                    <el-col :span="24">
                                        <el-form-item label="账户名称">
                                            <el-input v-model="formData.name" type="text"></el-input>
                                        </el-form-item>
                                    </el-col>
                                </el-row>
                                <el-row>
                                    <el-col :span="24">
                                        <el-form-item label="金额">
                                            <el-input v-model="formData.money" type="text"></el-input>
                                        </el-form-item>
                                    </el-col>
                                </el-row>
                            </el-form>
                            <div slot="footer" class="dialog-footer">
                                <el-button @click="dialogFormVisible4Edit = false">取消</el-button>
                                <el-button type="primary" @click="handleEdit()">确定</el-button>
                            </div>
                        </el-dialog>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <!-- 引入组件库 -->
    <script src="../js/vue.js"></script>
    <script src="../elementui/index.js"></script>
    <script src="../js/axios-0.18.0.js"></script>
    <script>
        var vue = new Vue({
            el: '#app',
            data:{
				dataList: [
                     // {id:1,name:"1234567890", money: 1000},
                     // {id:2,name:"2345678901", money: 2000},
                     // {id:3,name:"3456789012", money: 3000}
                ],//当前页要展示的分页列表数据
                formData: {
                    // id:3, name:"3456789012", money: 3000
                },//表单数据
                dialogFormVisible: false,//增加表单是否可见
                dialogFormVisible4Edit:false//编辑表单是否可见
            },
            //钩子函数，VUE对象初始化完成后自动执行
            created() {
                this.findPage();
            },
            methods: {
                //编辑
                handleEdit() {
                    //执行ajax操作, 从 Controller中 对指定的Account对象 进行更新

                    axios.post("http://localhost:8080/account/update.action?", this.formData)
                        .then(response => {
                            //关闭当前的 编辑窗口
                            this.dialogFormVisible4Edit = false;
                            //查询最新的账户数据
                            this.findPage();
                        })
                        .catch(error => {
                            //ajax执行失败后的回调代码
                            console.dir(error);
                        })

                    
                },
                //添加
                handleAdd (){
                    //发送ajax, 调用Controller中 save方法
                    //在ajax回调方法中做2件事
                    //1. 新建创建隐藏
                    //2. 刷新页面

                },
                //查询
                findPage() {
                    //执行ajax操作, 从 Controller中 查询所有的Account对象
                    axios.get("http://localhost:8080/account/findAll.action")
                        .then(response => {
                            //ajax执行成功后的回调代码
                            //console.log(response.data);

                            //把服务器返回的json数据 赋值给 dataList属性
                            this.dataList = response.data;
                        })
                        .catch(error => {
                            //ajax执行失败后的回调代码
                            console.dir(error);
                        })

                },
                // 新增弹窗
                handleCreate() {
                    this.dialogFormVisible = true;
                    //新建页面中 默认的数据应该为空 (  formData属性 赋值为空 )

                },
                //编辑弹框
                handleUpdate(row) {
                    this.dialogFormVisible4Edit = true;
                    //把当前点击行的数据row 赋值给 formData属性
                    this.formData = row;
                },
                // 删除
                handleDelete(row) {
                    this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        //发送ajax, 调用Controller中 delete方法
                        //在ajax回调方法中
                        //1. 刷新页面
                        this.$message({
                            type: 'success',
                            message: '删除成功'
                        });

                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '已取消删除'
                        });
                    });
                }
            }
        })
    </script>
</html>
```



#### 13、日志功能

```xml
1. log4j2
	引入必要依赖(资料中pom.xml)
	引入log4j2.xml （资料中）
2. log4j
	方法一：引入日志的门脸
		<dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>1.6.1</version>
        </dependency>
    方法二：
    	在sqlMapConfig.xml中配置日志
    	<settings>
        <setting name="logImpl" value="log4j"/>
    	</settings>
    	在spring中引入SqlMapConfig.xml
    	<!--引入mybatis的核心配置文件-->
       <property name="configLocation" value="classpath:SqlMapConfig.xml"></property>
```

#### 14、调试(排除错误) -- 单元测试

* dao所有功能

```java
package com.itheima.dao;

import com.itheima.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * dao层的测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
public class AccountDaoTest {

    //依赖注入
    @Autowired
    private AccountDao accountDao;

    @Test
    public void save() {
        Account account = new Account();
        account.setName("科霈老师");
        account.setMoney(99999d);

        accountDao.save(account);
    }

    @Test
    public void deleteById() {
        accountDao.deleteById(4);
    }

    @Test
    public void update() {
        Account account = new Account();
        account.setId(4);
        account.setName("科霈老师");
        account.setMoney(11d);

        accountDao.update(account);
    }

    @Test
    public void findAll() {
        List<Account> accountList = accountDao.findAll();
        for (Account account : accountList) {
            System.out.println("account = " + account);
        }
    }
}
```

* service所有功能

 ```java
package com.itheima.service;

import com.itheima.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * service层测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
public class AccountServiceTest {

    //依赖注入
    @Autowired
    private AccountService accountService;

    @Test
    public void save() {
        Account account = new Account();
        account.setName("科霈老师6666");
        account.setMoney(99999d);

        accountService.save(account);
    }

    @Test
    public void deleteById() {
        accountService.deleteById(5);
    }

    @Test
    public void update() {
        Account account = new Account();
        account.setId(3);
        account.setName("隔壁老王");
        account.setMoney(66666d);

        accountService.update(account);
    }

    @Test
    public void findAll() {
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println("account = " + account);
        }
    }
}
 ```

