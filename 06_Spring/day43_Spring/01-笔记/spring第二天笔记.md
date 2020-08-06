# 1. IoC的综合案例(CRUD) - 纯xml开发

## 1.1 综合案例介绍

**案例的需求**

实现账户表的增删改查操作

**案例的要求**

选用基于XML的Spring和Mybatis整合配置实现。

* 数据库表结构介绍

```mysql
CREATE TABLE `account` (
`id`  int(11) NOT NULL ,
`name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`money`  double NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
ROW_FORMAT=COMPACT
```

## 1.2 案例的实现

### 1.2.1 创建工程导入坐标

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.1.9.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>5.1.9.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.2</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
    </dependency>
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>1.1.20</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>2.0.1</version>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
    </dependency>
</dependencies>
```

### 1.2.2 编写基础代码

```java
/**
 * 账户的实体类
 */
public class Account {

    private Integer id;
    private String name;
    private Double money;

	//省略set,get,toString等方法
}
```

```java
/**
 * 账户的业务层接口
 */
public interface AccountService {
    /**
     * 保存
     */
    void save(Account account);

    /**
     * 根据id删除
     */
    void delete(Integer id);

    /**
     * 更新账户
     */
    void update(Account account);

    /**
     * 根据id查询
     */
    Account findById(Integer id);

    /**
     * 根据名称查询账户
     */
    Account findByName(String name);

    /**
     * 查询所有
     */
    List<Account> findAll();
}

```

```java
/**
 * 账户业务接口实现类
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void delete(Integer id) {
        accountDao.delete(id);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Override
    public Account findByName(String name) {
        return accountDao.findByName(name);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}

```

```java
/**
 * 账户持久层接口
 */
public interface AccountDao {
    /**
     * 保存
     */
    void save(Account account);

    /**
     * 根据id删除
     */
    void delete(Integer id);

    /**
     * 更新账户
     */
    void update(Account account);

    /**
     * 根据id查询
     */
    Account findById(Integer id);

    /**
     * 根据名称查询账户
     */
    Account findByName(String name);

    /**
     * 查询所有
     */
    List<Account> findAll();
}
```

### 1.2.3 编写mybatis的映射配置

```xml
<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.itheima.dao.AccountDao">

    <!--保存-->
    <insert id="save" parameterType="account">
        insert into account values(#{id},#{name},#{money})
    </insert>

    <!--根据id删除-->
    <delete id="delete" parameterType="int" >
        delete from account where id=#{id}
    </delete>

    <!--更新账户-->
    <update id="update" parameterType="account">
        update account set name=#{name},money=#{money} where id=#{id}
    </update>

    <!--根据id查询-->
    <select id="findById" parameterType="int" resultType="account">
        select * from account where id=#{id}
    </select>

    <!--根据名称查询账户-->
    <select id="findByName" parameterType="string" resultType="account">
        select * from account where name=#{name}
    </select>

    <!--查询所有-->
    <select id="findAll" resultType="account">
        select * from account
    </select>
</mapper>
```

### 1.2.4 创建Spring配置文件并导入约束

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">    
</beans>
```

### 1.2.5 编写spring和mybatis整合配置

```xml
<!--配置dao-->
<!--配置properties文件的位置-->
<context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
<!--配置数据源-->
<bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
    <property name="driverClassName" value="${jdbc.driverClassName}"></property>
    <property name="url" value="${jdbc.url}"></property>
    <property name="username" value="${jdbc.username}"></property>
    <property name="password" value="${jdbc.password}"></property>
</bean>
<!--配置mybatis的SqlSessionFactory工厂-->
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="druidDataSource"></property>
    <property name="typeAliasesPackage" value="com.itheima.pojo"></property>
</bean>
<!--配置创建dao代理实现类的扫描器-->
<bean id="mapperScannerConfigurer" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="basePackage" value="com.itheima.dao"></property>
</bean>
```

### 1.2.6 编写spring的配置

```xml
<!--配置service-->
<bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl">
    <property name="accountDao" ref="accountDao"></property>
</bean>
```

### 1.2.7 测试

```java
/*
测试类
 */
public class CRUDTest {
    @Test
    public void findByName(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        AccountService accountService = applicationContext.getBean(AccountService.class);
        Account account = accountService.findByName("迪丽热巴");
        System.out.println("account = " + account);
    }

    @Test
    public void findAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        AccountService accountService = applicationContext.getBean(AccountService.class);
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println("account = " + account);
        }
    }
}
```



# 2. Spring注解开发

## 2.1 bean标签和注解的对应

- bean标签对应注解@Component


- - 注解属性value：bean标签的id属性
  - 不指定value属性，默认就是类名，首字母小写
  - 该注解衍生出了三个注解，@Controller,@Service,@Repository，用法和@Componet一致，为了更加清晰的提现层的概念。

- bean标签属性scope对应注解@Scope

  - 注解属性value：singleton，prototype

- bean标签属性init-method对应注解@PostConstruct

- bean标签属性destroy-method对应注解@PreDestroy

  ​

- service层

  ```java
  public interface AccountService {

      //模拟保存账户
      void save();
  }
  ```

  ```java
  //@Component("accountService")
  @Service("accountService")
  @Scope("prototype")
  public class AccountServiceImpl implements AccountService {

      private AccountDao accountDao;

      public void setAccountDao(AccountDao accountDao) {
          this.accountDao = accountDao;
      }

      @Override
      public void saveAccount() {
          accountDao.saveAccount();
      }
  }
  ```

- dao层

  ```java
  public interface AccountDao {

      //模拟保存账户
      void save();
  }
  ```

  ```java
  //@Component("accountDao")
  @Repository("accountDao")
  public class AccountDaoImpl implements AccountDao {
      @Override
      public void saveAccount() {
          System.out.println("保存了账户");
      }

      private void init() {
          System.out.println("AccountDao对象初始化");
      }

      private void destroy() {
          System.out.println("AccountDao对象 销毁了");
      }
  }
  ```

- 添加applicationContext配置文件命名空间

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns:context="http://www.springframework.org/schema/context"
         xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
  >
      
      <!-- 开启spring的注解扫描，扫描包中类的注解-->
      <context:component-scan base-package="com.itheima"></context:component-scan>
  </beans>
  ```

- 测试注解

  ```java
  @Test
  public void testIOC(){
      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      AccountService accountService = context.getBean(AccountService.class);
      AccountDao accountDao = context.getBean(AccountDao.class);

      System.out.println(accountService);
      System.out.println(accountDao);

      context.close();
  }
  ```

## 2.2 依赖注入注解

- @Autowired注解（Spring框架提供）

    按照类型注入，如果无法确定唯一类型（接口有多个实现类），需要配合注解@Qualifier的使用

- @Qualifier("id") 注解（Spring框架提供）

    * 按照id注入

- @Resource注解（JDK提供）

  - 注解属性name：配置类的id

  ```java
  @Resource(name="accountDao")
  private AccountDao accountDao;
  ```

**代码演示**

- 业务层

```java
@Service("accountService")
@Scope("singleton")
public class AccountServiceImpl implements AccountService {

     @Autowired
    //@Qualifier("accountDao2")
    //@Resource(name = "accountDao2")
    private AccountDao accountDao;

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }
}
```

- dao层

```java
package com.itheima.dao.impl;

/**
 * 账户dao实现类
 */
@Component("accountDao")
//@Repository("accountDao")
@Scope("singleton")
public class AccountDaoImpl implements AccountDao {

    @Override
    public void saveAccount(Account account) {
        System.out.println("模拟转账");
    }

    @PostConstruct()
    public void init(){
        System.out.println("AccountDaoImpl 初始化...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("AccountDaoImpl 销毁...");
    }
}

```



## 2.3 Spring对Junit的支持

- junit运行的时候底层使用了Runner对象，有一个默认使用的Runner对象。
- Spring对junit的支持，其实是自己实现了一个Runner对象（按照junit runner的要求实现）
- Spring对junit的支持的体现
  - 好处一：配置完之后，不需要我们手动的启动Spring
  - 好处二：可以在junit测试类中使用@AutoWired等方式注入对象，直接对其进行调用测试
- 使用步骤
  - 引入spring-test.jar
  - 配置测试类

```java
  //Spring框架中的Runner对象, 替换Junit中的Runner对象
  @RunWith(SpringJUnit4ClassRunner.class)

  //框架启动入口, xml配置文件启动(2选1)
  @ContextConfiguration(locations = "classpath:beans.xml")
  //框架启动入口, 注解方式配置文件启动(2选1)
  //@ContextConfiguration(classes = SpringConfig.class)
```

- 代码实现

  - pom.xml

  ```xml
  <dependencies>
      <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-context</artifactId>
          <version>5.1.9.RELEASE</version>
      </dependency>
      <dependency>
          <groupId>junit</groupId>
          <artifactId>junit</artifactId>
          <version>4.12</version>
      </dependency>
      <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-test</artifactId>
          <version>5.1.9.RELEASE</version>
      </dependency>
  </dependencies>
  ```

  - 测试类

  ```java
  package com.itheima;

  //Spring框架中的Runner对象, 替换Junit中的Runner对象
  @RunWith(SpringJUnit4ClassRunner.class)
  //框架启动入口, 注解方式配置文件启动
  //@ContextConfiguration(classes = SpringConfig.class);
  //框架启动入口, xml配置文件启动
  @ContextConfiguration(locations = "classpath:ApplicationContext.xml")
  public class AccountTest {

      //注入业务层接口
      @Autowired
      private AccountService service;

      @Test
      public void testIOC(){

          System.out.println("service = " + service);
          Account account = new Account();
          account.setName("小米");
          account.setMoney(888.0F);
          service.saveAccount(account);
      }
  }
  ```




# 3. IoC的综合案例(CRUD) - 半注解半xml开发

**企业主流的开发方式**

注意：往往第三方jar中的对象我们使用xml配置（比如druid数据库连接池、Mybatis的SQLSessionFactory）,类似于service层和dao层的实现类，这属于我们自己写的代码，往往会使用注解，这就是半xml半注解的模式。

- applicationContext.xml配置

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns:context="http://www.springframework.org/schema/context"
         xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

      <!--配置dao-->
      <!--配置properties文件的位置-->
      <context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
      <!--配置数据源-->
      <bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
          <property name="driverClassName" value="${jdbc.driverClassName}"></property>
          <property name="url" value="${jdbc.url}"></property>
          <property name="username" value="${jdbc.username}"></property>
          <property name="password" value="${jdbc.password}"></property>
      </bean>
      <!--配置mybatis的SqlSessionFactory工厂-->
      <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
          <property name="dataSource" ref="druidDataSource"></property>
          <property name="typeAliasesPackage" value="com.itheima.pojo"></property>
      </bean>
      <!--配置创建dao代理实现类的扫描器-->
      <bean id="mapperScannerConfigurer" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
          <property name="basePackage" value="com.itheima.dao"></property>
      </bean>

      <!--配置service-->
      <!--让Spring开启注解扫描-->
      <context:component-scan base-package="com.itheima"></context:component-scan>
  </beans>
  ```

- service层

  ```java
  package com.itheima.service.impl;

  /**
   * 账户业务接口实现类
   */
  @Service("accountService")
  public class AccountServiceImpl implements AccountService {

      //依赖注入
      @Autowired
      private AccountDao accountDao;

      //增删改查方法 无修改, 笔记中代码省略
      
  }
  ```

- 测试类


```java
/*
测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    //测试类方法省略
    @Test
    public void findAll() {
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println("account = " + account);
        }
    }
}
```



# 4. IoC的综合案例(CRUD) - 纯注解开发

- @Configuration标识当前类是Spring的一个配置类

- @ComponentScan替代xml中的`<context:component-scan/>`

- @Import引入其他配置类,被引入的配置类可以不加@Configuration注解

- @PropertySource：引入外部properties文件，注意加classpath:

- @Value对成员变量赋值

- @Bean将一个方法的返回值对象加入到Spring的容器当中管理

- @Qualifier可以使用在方法参数上，表明对应的形参引入/注入的对象类型

  ​
## 4.1 SpringConfig框架启动配置类

```java
//Spring配置类，框架启动入口
@Configuration
//启动注解扫描
@ComponentScan({"com.itheima"})
public class SpringConfig {

    //方法的返回值, 加入到SpringIOC容器中管理
    @Bean("druidDataSource")
    public DataSource createDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/ssm_lx");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        return druidDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean(@Qualifier("druidDataSource") DataSource ds){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(ds);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.itheima.pojo");
        return sqlSessionFactoryBean;
    }

    @Bean("scannerConfigurer")
    public MapperScannerConfigurer createMapperScannerConfigurer(){
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage("com.itheima.dao");
        return scannerConfigurer;
    }
}

```

- 测试

```java
/*
测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
//框架启动入口, 注解方式配置文件启动(2选1)
@ContextConfiguration(classes = SpringConfig.class)
public class CRUDTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void findByName(){
        Account account = accountService.findByName("迪丽热巴");
        System.out.println("account = " + account);
    }

    @Test
    public void findAll(){
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println("account = " + account);
        }
    }
}
```



## 4.2 注解开发的SpringConfig配置优化

- SpringConfig框架启动配置类

  ```java
  /*
  作为Spring框架的主配置文件
   */
  @Configuration
  //开启Spring容器的注解扫描
  @ComponentScan({"com.itheima"})
  //导入子配置文件
  @Import({JDBCConfig.class, MybatisConfig.class})
  public class SpringConfig {

  }
  ```

- JDBCConfig配置类

  ```java
  //用于指定与数据库相关配置的配置文件
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
      @Bean("ataSource")
      public DataSource createDataSource(){
          //创建Druid数据源
          DruidDataSource druidDataSource = new DruidDataSource();
          //配置相关信息(Driver, url, username, password)
          druidDataSource.setDriverClassName(driverClassName);
          druidDataSource.setUrl(url);
          druidDataSource.setUsername(username);
          druidDataSource.setPassword(password);

          return druidDataSource;
      }
  }
  ```

- Mybatis配置类


  ```java
  //用于配置与Mybatis相关的配置
  @Configuration
  public class MybatisConfig {
      //配置SqlSessionFactoryBean对象
      @Bean("sqlSessionFactory")
      public SqlSessionFactoryBean createSqlSessionFactoryBean(DataSource ds){
          //创建SqlSessionFactoryBean 对象
          SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
          //配置相关信息(数据源, pojo别名映射)
          sqlSessionFactory.setDataSource(ds);
          sqlSessionFactory.setTypeAliasesPackage("com.itheima.pojo");

          return sqlSessionFactory;
      }

      //配置dao的包扫描
      @Bean("scannerConfigurer")
      public MapperScannerConfigurer createMapperScannerConfigurer(){
          //创建MapperScannerConfigurer 对象
          MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
          //配置相关信息(扫描的dao包, 找到了dao层的接口文件, 找到了SQL映射文件, 生成接口实现类对象并存到Spring容器中)
          scannerConfigurer.setBasePackage("com.itheima.dao");

          return scannerConfigurer;
      }
  }
  ```

- 测试类

  ```java
  /*
  测试类
   */
  @RunWith(SpringJUnit4ClassRunner.class)
  //加载的xml配置文件
  //@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})

  //加载的注解形式的Spring主配置文件
  @ContextConfiguration(classes = {SpringConfig.class})
  public class AccountServiceTest {

      @Autowired
      private AccountService accountService;
  	
      //其他方法省略

      @Test
      public void findAll() {
          List<Account> accountList = accountService.findAll();
          for (Account account : accountList) {
              System.out.println("account = " + account);
          }
      }
  }
  ```

  ​

# 5. 案例：模拟转账

案例：模拟转账（并且模拟转账异常）

- 汇款人账户减少一定的金额
- 收款人账户增加一定的金额
- 计算之后，更新数据库
- 问题：模拟转账异常（人为制造异常，在两次update之间造了异常）



## 5.1 转账编码

##### 1、引入依赖

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.1.9.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>5.1.9.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.2</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
    </dependency>
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>1.1.20</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>2.0.1</version>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
        <version>5.1.9.RELEASE</version>
    </dependency>
</dependencies>
```

##### 2、业务层

```java
/**
 * 账户的业务层接口
 */
public interface AccountService {
    /**
     * 转账
     */
    void transfer(String source, String target, double money);
    
    //其他方法省略
}
```

```java
/**
 * 账户业务接口实现类
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    //依赖注入
    @Autowired
    private AccountDao accountDao;

    /*
    转账业务逻辑
    1.先查询账户信息
    2.修改账户信息
    3.持久化账户信息
     */
    @Override
    public void transfer(String source, String target, double money) {
        try {
            //开启事务

            // 转账业务逻辑
            //1 先查询账户信息
            Account sourceAccount = accountDao.findByName(source);
            Account targetAccount = accountDao.findByName(target);
            //2 修改账户信息
            sourceAccount.setMoney(sourceAccount.getMoney() - money);
            targetAccount.setMoney(targetAccount.getMoney() + money);
            //3 持久化账户信息
            accountDao.update(sourceAccount);
            //int i = 1/0;
            accountDao.update(targetAccount);

            //提交事务
        } catch (Exception e){
            e.printStackTrace();
            //回滚事务

        } finally {
            //关闭资源
        }
    }
    
    //其他方法省略
}
```

##### 3、测试

```java
/*
测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class CRUDTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void tranfer(){
        accountService.transfer("迪丽热巴","古力娜扎",1);
    }
}
```

##### 4、发现问题

```
转账过程出现事务问题
```


