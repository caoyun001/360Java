# 今日授课目标

- 掌握工程热部署
- 掌握多环境的配置文件
- 掌握配置文件存放路径，及其加载顺序
- 掌握自定义配置文件名称
- 掌握内置web应用服务器的切换：tomcat切换为jetty
- 掌握为SpringBoot配置生产级监控Actuator
- 搭建Spring Boot Admin服务链接SpringBoot项目
- 了解SpringBoot自动配置实现原理【不要求掌握】

# 七、SpringBoot工程热部署

只需导入开发者工具依赖坐标，即可实现热部署功能：

```xml
<!--spring-boot开发工具jar包，支持热部署--> 
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
</dependency>
```

但还需注意：加入坐标之后，如果想要代码立即生效，必须在修改代码之后进行代码构建。默认情况IDEA不会自动构建，需要手动构建。如图两处地方均可。

![image-20191116073526958](../../../new-%25E9%25A1%25B9%25E7%259B%25AE%25E4%25BA%258C%25E5%2589%258D%25E7%25BD%25AE/day02-SpringBoot/03%25E8%25AE%25B2%25E4%25B9%2589/01-SpringBoot-%25E8%25AE%25B2%25E4%25B9%2589.assets/image-20191116073526958.png)

每次手动构建很麻烦？！！还有一种自动构建解决方案，但不建议使用。就是设置`Build Project Automatically`。同时打开Maintenance维护(打开快捷键`Shift + Ctrl + Alt + /`)，选择Registry(注册表)，设置运行时自动编译。

![image-20191116073950737](../../../new-%25E9%25A1%25B9%25E7%259B%25AE%25E4%25BA%258C%25E5%2589%258D%25E7%25BD%25AE/day02-SpringBoot/03%25E8%25AE%25B2%25E4%25B9%2589/01-SpringBoot-%25E8%25AE%25B2%25E4%25B9%2589.assets/image-20191116073950737.png)

# 八、配置文件延伸

## 8.1 多环境配置文件

我们在开发Spring Boot应用时，通常同一套程序会被安装到不同环境，比如：开发dev、测试test、生产pro等。其中数据库地址、服务器端口等等配置都不同，如果每次打包时，都要修改配置文件，那么非常麻烦。profile功能就是来进行动态配置切换的。 

**profile配置方式有两种：**

  - 多profile文件方式：提供多个配置文件，每个代表一种环境。
    - application-dev.properties/yml 开发环境
    - application-test.properties/yml 测试环境
    - application-pro.properties/yml 生产环境
  - yml多文档方式：在yml中使用 --- 分隔不同配置

**profile激活方式：**

- 配置文件： 再配置文件中配置：spring.profiles.active=dev
- 虚拟机参数：在VM options 指定：-Dspring.profiles.active=dev
- 命令行参数：java –jar xxx.jar --spring.profiles.active=dev

## 8.2 松散绑定

不论配置文件中的属性值是短横线、驼峰式还是下换线分隔配置方式，在注入配置时都可以通过短横线方式取出值；

使用范围：properties文件、YAML文件、系统属性

| 命名风格   | 示例                            |
| ---------- | ------------------------------- |
| 短横线分隔 | itheima.spring-boot.one-example |
| 驼峰式     | itheima.SpringBoot.OneExample   |
| 下划线分隔 | itheima.spring_boot.one_example |

**注意：@Value取值配置不能写驼峰式和下划线，只能写短横线，否则会报错**

## 8.3 配置路径及其加载顺序

Springboot程序启动时，会从以下位置加载配置文件：

- 1.file:./config/：当前项目下的/config目录下
- 2.file:./      ：当前项目的根目录
- 3.classpath:/config/：classpath的/config目录

- 4.classpath:/ ：classpath的根目录

加载顺序为上文的排列顺序，高优先级配置的属性会生效

![image-20191129115637643](02-SpringBoot-%E8%AE%B2%E4%B9%89.assets/image-20191129115637643.png)

**注意：在多个model的工程中，这种配置顺序不生效**

## 8.4 外部配置加载顺序

1. 开启 DevTools 时， ~/.spring-boot-devtools.properties
2. 测试类上的 @TestPropertySource 注解
3. @SpringBootTest#properties 属性
4. **==命令⾏参数（--server.port=9000 ）==**
5. SPRING_APPLICATION_JSON 中的属性  
6. ServletConfig 初始化参数
7. ServletContext 初始化参数
8. java:comp/env 中的 JNDI 属性
9. System.getProperties()
10. **操作系统环境变量**
11. random.* 涉及到的 RandomValuePropertySource
12. **jar 包外部的 application-{profile}.properties 或 .yml**
13. **jar 包内部的 application-{profile}.properties 或 .yml**
14. **jar 包外部的 application.properties 或 .yml**
15. **jar 包内部的 application.properties 或 .yml**  
16. **@Configuration 类上的 @PropertySource**
17. SpringApplication.setDefaultProperties() 设置的默认属性

官方说明[地址](https://docs.spring.io/spring-boot/docs/2.1.11.RELEASE/reference/html/boot-features-external-config.html)：

## 8.5 修改配置文件的位置及默认名称：

第一种方式：IDEA通过参数注入方式配置：

![image-20191129120809657](02-SpringBoot-%E8%AE%B2%E4%B9%89.assets/image-20191129120809657.png)

第二种方式：命令行：

![image-20191129121309318](02-SpringBoot-%E8%AE%B2%E4%B9%89.assets/image-20191129121309318.png)

```yml
# 自定义配置文件名称
--spring.config.name=myApplication
# 指定配置文件存储位置
--spring.config.location=classpath:/myconfig/application.yml
```

# 九、SpringBoot进阶

## 9.1 SpringBoot的监听器

### 1、什么是监听器

JavaEE包括13门规范，其中 Servlet规范包括三个技术点：Servlet、Listener、Filter

监听器就是监听某个对象的状态变化的组件

监听器，字面上的理解就是，观察监听某个事件的发生，当被监听的事件真的发生了，在这个事件发生后做点事      

监听器的相关概念：

- **事件源：**被监听的对象

- **监听器：**监听事件源对象 事件源对象的状态的变化都会触发监听器

- **响应行为：**监听器监听到事件源的状态变化时 所涉及的功能代码 ---- 程序员编写的代码

<img src="02-SpringBoot-%E8%AE%B2%E4%B9%89.assets/clip_image002.jpg" alt="img" style="zoom: 50%;" />    

**1、js中的事件监听机制：onclick=fun()**

**2、Servlet中的监听器：web.xml**

```xml
<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
```

**3、SpringBoot中的监听器**

- CommandLineRunner：应用程序启动完成后
- ApplicationRunner：应用程序启动完成后
- ApplicationContextInitializer：应用程序初始化之前【对框架开发者有意义】
- SpringApplicationRunListener：应用程序全阶段监听【对框架开发者有意义】
  1. 应用程序开始启动--starting
  2. 环境准备完成--environmentPrepared
  3. spring容器准备完成--environmentPrepared
  4. spring容器加载完成--environmentPrepared
  5. 应用程序启动完成--started
  6. 应用程序开始运行--running
  7. 应用程序运行时抛出异常时调用--failed

> Spring Boot的扩展机制Spring Factories
>
> - 主要目的是解耦：将监听器的配置权交给第三方厂商、插件开发者
> - 框架提供接口，实现类由你自己来写，释放原生API能力，增加可定制性
> - META-INF/spring.factories文件中配置接口的实现类名称

在ApplicationContextInitializer接口的实现类中必须写一个构造方法：

```java
//注意：此构造方法必须要写
public My04SpringApplicationRunListener(SpringApplication application, String[] args) {}
```



### 2、监听器案例

**需求：当应用程序启动完成时，初始化redis缓存。**

**实现步骤**：

1. 实现ApplicationRunner接口，重写run()方法
2. 注入UserService接口实现类及RedisTemplate对象
3. 将用户数据存入redis缓存

**实现过程：**

```java
//1.实现ApplicationRunner接口，重写run()方法
@Component
public class InitialzerRedisCacheListnener implements ApplicationRunner {
    //2.注入UserService接口实现类及RedisTemplate对象
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //3.将缓存数据存入redis
        String key = UserService.class.getName() + ".findAll()";
        redisTemplate.boundValueOps(key).set(userService.findAll());
    }
}
```

## 9.2 自动配置实现原理详解

> redisTemplate的bean怎么注入spring容器中的？
>
> redisTemplate中的host和port怎么配置的？

### 1、@Import注解进阶

三种Jar包外导入类的方式：

- 直接导入
- 通过配置类导入
- 通过ImportSelector接口实现类导入

### 2、@Configuration注解进阶

**配置类中的条件注解@Conditional及其衍生注解**

- class类条件
  - @ConditionalOnClass==存在类条件
  - @ConditionalOnMissingClass==不存在类条件
- 属性条件
  - @ConditionalOnProperty==属性条件，还可以为属性设置默认值
- Bean条件
  - @ConditionalOnBean==存在Bean条件
  - @ConditionalOnMissingBean==不存在Bean条件
  - @ConditionalOnSingleCondidate==只有一个Bean条件
- 资源条件
  - @ConditionalResource==资源条件
- Web应用条件
  - @ConditionalOnWebApplication==web应用程序条件
  - @ConditionalOnNotWebApplication==不是web应用程序条件
- 其他条件
  - @ConditionalOneExpression==EL表达式条件
  - @ConditionalOnJava==在特定的Java版本条件

自动配置类的执行顺序

1. @AutoConfigureBefore==在那些自动配置之前执行
2. @AutoConfigureAfter==在那些自动配置之后执行
3. @AutoConfigureOrder==自动配置顺序

Redis的自动配置

![image-20191128175029652](02-SpringBoot-%E8%AE%B2%E4%B9%89.assets/image-20191128175029652.png)

Mybatis的自动配置

![image-20191128175943991](../../../new-%25E9%25A1%25B9%25E7%259B%25AE%25E4%25BA%258C%25E5%2589%258D%25E7%25BD%25AE/day02-SpringBoot/03%25E8%25AE%25B2%25E4%25B9%2589/01-SpringBoot-%25E8%25AE%25B2%25E4%25B9%2589.assets/image-20191128175943991.png)

### 3、@EnableAutoConfiguration注解

其本质是配置类@Import与@Configuration的组合

![image-20191128180244863](../../../new-%25E9%25A1%25B9%25E7%259B%25AE%25E4%25BA%258C%25E5%2589%258D%25E7%25BD%25AE/day02-SpringBoot/03%25E8%25AE%25B2%25E4%25B9%2589/01-SpringBoot-%25E8%25AE%25B2%25E4%25B9%2589.assets/image-20191128180244863.png)

![image-20191128180821680](02-SpringBoot-%E8%AE%B2%E4%B9%89.assets/image-20191128180821680.png)

## 9.3 自定义auto-configuration及starter

### **目标：**

为传智播客教育集团研究院开发的，基于自主研发的模板引擎代码生成神器加入自动配置。要求当导入starter坐标时，自动创建代码生成器框架的核心对象codeutil。

**分析过程：**

>  参考Mybatis实现的自动配置

自动配置和starter是针对已有框架进行的整合！

**必备四角色：框架、自动配置模块、starter模块、开发者**



- 定制自动配置必要内容
  - autoconfiguration模块，包含自动配置代码。自定义itcast-spring-boot-autoconfigure。
  - starter模块。自定义itcast-spring-boot-starter
- 自动配置命名方式
  
  - 官方的Starters
    - spring-boot-starter-*
  - 非官方的starters
    - *-spring-boot-starter
- SpringBoot起步依赖，Starter Dependencies


**一些注意事项**

- starter中仅添加必备依赖坐标
- 需要声明对spring-boot-autoconfigure的依赖
- 测试项目的包名不能与自定义starter和自动配置的包名相同
  - com.itheima
  - cn.itcast

### **实现步骤：**

1. 获取准备好的框架--黑马架构师-代码生成器
2. 创建 itcast-spring-boot-autoconfigure 模块
   - 定义代码生成器核心对象的配置类信息
   - 在META-INF/spring.factories扩展自动配置
3. 创建 itcast-spring-boot-starter 模块
4. 将自动配置模块及starter模块安装到本地仓库
5. 测试模块springboot04-test-my-auto-configuration
   - 引入自定义的 itcast-spring-boot-starter依赖坐标
   - 测试核心代码生成器对象，是否自动配置成功了

### **实现过程：**

1. 获取准备好的框架--黑马架构师-代码生成器![image-20191217043940737](02-SpringBoot-%E8%AE%B2%E4%B9%89.assets/image-20191217043940737.png)

   - CodeUtils：

     ```java
     /**
      * 代码生成器，程序执行入口
      */
     public class CodeUtils {
         
         public void generatorCode(){
             //生成代码
             System.out.println("-----------黑马架构师代码生成器执行--------");
         }
     }
     ```
   
2. 创建 itcast-spring-boot-autoconfigure 模块![image-20191217043914579](02-SpringBoot-%E8%AE%B2%E4%B9%89.assets/image-20191217043914579.png)

   - HeimaConfiguration

     ```java
     @Configuration
     @ConditionalOnClass(CodeUtils.class)
     @Import(HeimaProperties.class)
     public class HeimaConfiguration {
     
         //配置黑马架构师的核心对象CodeUtils
         @Bean
         @ConditionalOnProperty(name = "spring.heima.enable",havingValue = "true",matchIfMissing = true)
         public CodeUtils codeUtil(){
             return new CodeUtils();
         }
     }
     ```

   - HeimaProperties

     ```java
     @ConfigurationProperties(prefix = "spring.heima")
     public class HeimaProperties {
         private String username;
         private String password;
     	//getter setter toString
     }
     ```

   - META-INF/spring.factories

     ```properties
     # 注册自定义自动配置
     org.springframework.boot.autoconfigure.EnableAutoConfiguration=cn.itcast.config.HeimaConfiguration
     ```

   - pom.xml

     ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     <project xmlns="http://maven.apache.org/POM/4.0.0"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
         <modelVersion>4.0.0</modelVersion>
     
         <parent>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-parent</artifactId>
             <version>2.1.11.RELEASE</version>
         </parent>
         <groupId>cn.itcast</groupId>
         <artifactId>itcast-spring-boot-autoconfigure</artifactId>
         <version>1.0-SNAPSHOT</version>
     
         <dependencies>
             <dependency>
                 <groupId>org.springframework.boot</groupId>
                 <artifactId>spring-boot-autoconfigure</artifactId>
             </dependency>
             <!--导入需要加入自定义自动配置的框架-->
             <dependency>
                 <groupId>cn.itcast</groupId>
                 <artifactId>itcast-codeutils</artifactId>
                 <version>1.0-SNAPSHOT</version>
             </dependency>
         </dependencies>
     </project>
     ```

3. 创建 itcast-spring-boot-starter 模块![image-20191217044311090](02-SpringBoot-%E8%AE%B2%E4%B9%89.assets/image-20191217044311090.png)

   - pom.xml

     ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     <project xmlns="http://maven.apache.org/POM/4.0.0"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
         <modelVersion>4.0.0</modelVersion>
     
         <groupId>com.itcast</groupId>
         <artifactId>itcast-spring-boot-starter</artifactId>
         <version>1.0-SNAPSHOT</version>
         <dependencies>
             <!--黑马架构师-代码生成器的依赖-->
             <dependency>
                 <groupId>com.itheima</groupId>
                 <artifactId>itcast-codeutil</artifactId>
                 <version>1.0-SNAPSHOT</version>
             </dependency>
             <!--框架的自动配置依赖-->
             <dependency>
                 <groupId>com.itcast</groupId>
                 <artifactId>itcast-spring-boot-autoconfigure</artifactId>
                 <version>1.0-SNAPSHOT</version>
             </dependency>
         </dependencies>
     </project>
     ```

4. 将自动配置模块及starter模块安装到本地仓库，执行maven的install命令

5. 测试模块springboot04-test-my-auto-configuration![image-20191217051715315](02-SpringBoot-%E8%AE%B2%E4%B9%89.assets/image-20191217051715315.png)

   - 引入自定义的 itcast-spring-boot-starter依赖坐标

     ```xml
     <!--导入黑马架构师的起步依赖-->
     <dependency>
         <groupId>cn.itcast</groupId>
         <artifactId>itcast-spring-boot-starter</artifactId>
         <version>1.0-SNAPSHOT</version>
     </dependency>
     ```

   - 测试核心代码生成器对象，是否自动配置成功了![image-20191217051826363](02-SpringBoot-%E8%AE%B2%E4%B9%89.assets/image-20191217051826363.png)

## 9.4 切换内置的web应用服务器

> 前置条件，必须会使用Maven helper的插件，懂得依赖排除

SpringBoot的web环境中默认使用tomcat作为内置服务器，其实SpringBoot提供了另外2中内置服务器供我们选择，我们可以很方便的进行切换。

Jetty： Jetty 是一个开源的servlet容器，它为基于Java的web容器，例如JSP和servlet提供运行环境。Jetty是使用[Java语言](https://baike.baidu.com/item/Java语言)编写的，它的API以一组JAR包的形式发布。 

Undertow： 是红帽公司开发的一款**基于 NIO 的高性能 Web 嵌入式服务器** 

**操作过程：**

1. 在spring-boot-starter-web排除tomcat

   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-web</artifactId>
    	<!--排除tomcat的starter-->   
       <exclusions>
           <exclusion>
               <artifactId>spring-boot-starter-tomcat</artifactId>
               <groupId>org.springframework.boot</groupId>
           </exclusion>
       </exclusions>
   </dependency>
   ```

2. 导入其他容器的starter

   ```xml
   <!--导入jetty容器依赖-->
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-jetty</artifactId>
   </dependency>
   ```

3. 配置之后的效果![image-20191128210602147](../../../new-%25E9%25A1%25B9%25E7%259B%25AE%25E4%25BA%258C%25E5%2589%258D%25E7%25BD%25AE/day02-SpringBoot/03%25E8%25AE%25B2%25E4%25B9%2589/01-SpringBoot-%25E8%25AE%25B2%25E4%25B9%2589.assets/image-20191128210602147.png)

## 9.5 SpringBoot启动流程分析

**执行流程图：**

![SpringBoot启动流程](02-SpringBoot-%E8%AE%B2%E4%B9%89.assets/SpringBoot%E5%90%AF%E5%8A%A8%E6%B5%81%E7%A8%8B-1576531480954.png)

**源码分析：**

SpringApplication类的构造方法

```java
//SpringApplication类的构造方法
public SpringApplication(ResourceLoader resourceLoader, Class<?>... primarySources) {
    //设置资源加载器
    this.resourceLoader = resourceLoader;
    //判断启动引导类是否为空
    Assert.notNull(primarySources, "PrimarySources must not be null");
    this.primarySources = new LinkedHashSet<>(Arrays.asList(primarySources));
    //判断是否是web应用
    this.webApplicationType = WebApplicationType.deduceFromClasspath();
    //设置应用的初始化器
    setInitializers((Collection) getSpringFactoriesInstances(ApplicationContextInitializer.class));
    //设置应用的监听器
    setListeners((Collection) getSpringFactoriesInstances(ApplicationListener.class));
    //
    this.mainApplicationClass = deduceMainApplicationClass();
}
```

SpringApplication类的run()方法

```java
//SpringApplication类的run()方法
public ConfigurableApplicationContext run(String... args) {
    //创建计时器，记录SpringBoot启动耗时
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();//开始计时
    //创建Spring的IOC容器
    ConfigurableApplicationContext context = null;
    //SpringBoot异常报告对象
    Collection<SpringBootExceptionReporter> exceptionReporters = new ArrayList<>();
    configureHeadlessProperty();
    //获取所有监听器
    SpringApplicationRunListeners listeners = getRunListeners(args);
    listeners.starting();//执行监听器的starting方法
    try {
        //创建应用参数对象
        ApplicationArguments applicationArguments = new DefaultApplicationArguments(args);
        //准备应用环境
        ConfigurableEnvironment environment = prepareEnvironment(listeners, applicationArguments);
        configureIgnoreBeanInfo(environment);
        //打印Banner内容
        Banner printedBanner = printBanner(environment);
        //创建Spring容器
        context = createApplicationContext();
        //获取异常报告的的实例
        exceptionReporters = getSpringFactoriesInstances(SpringBootExceptionReporter.class,
                                                         new Class[] { ConfigurableApplicationContext.class }, context);
        //准备Spring的容器
        prepareContext(context, environment, listeners, applicationArguments, printedBanner);
        //刷新Spring的容器，将所有对象注入Spring容器
        refreshContext(context);
        afterRefresh(context, applicationArguments);
        stopWatch.stop();//停止计时
        if (this.logStartupInfo) {
            new StartupInfoLogger(this.mainApplicationClass).logStarted(getApplicationLog(), stopWatch);
        }
        //执行所有监听器的started方法
        listeners.started(context);
        //启动完成
        callRunners(context, applicationArguments);
    }
    catch (Throwable ex) {
        handleRunFailure(context, ex, exceptionReporters, listeners);
        throw new IllegalStateException(ex);
    }

    try {
        //执行监听器的running方法
        listeners.running(context);
    }
    catch (Throwable ex) {
        handleRunFailure(context, ex, exceptionReporters, null);
        throw new IllegalStateException(ex);
    }
    //启动完成返回Spring的容器
    return context;
}
```

# 10、生产级监控Actuator

## 10.1 Actuator简介

SpringBoot自带监控功能Actuator，可以帮助实现对程序内部运行情况监控，比如监控状况、Bean加载情况、配置属性、日志信息等。

使用步骤：

1. 导入依赖坐标

   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-actuator</artifactId>
   </dependency>
   ```

   

2. 访问监控地址： http://localhost:8080/actuator 

## 10.2 监控应用endpoint

| 路径            | 描述                                                         | 默认开启 |
| --------------- | ------------------------------------------------------------ | -------- |
| /beans          | 显示容器的全部的Bean，以及它们的关系                         | Y        |
| /env            | 获取全部环境属性                                             | Y        |
| /env/{name}     | 根据名称获取特定的环境属性值                                 | Y        |
| /health         | 显示健康检查信息                                             | Y        |
| /info           | 显示设置好的应用信息                                         | Y        |
| /mappings       | [显示所有的@RequestMapping信息](mailto:显示所有的@RequestMapping信息) | Y        |
| /metrics        | 显示应用的度量信息                                           | Y        |
| /scheduledtasks | 显示任务调度信息                                             | Y        |
| /httptrace      | 显示Http Trace信息                                           | Y        |
| /caches         | 显示应用中的缓存                                             | Y        |
| /conditions     | 显示配置条件的匹配情况                                       | Y        |
| /configprops    | [显示@ConfigurationProperties的信息](mailto:显示@ConfigurationProperties的信息) | Y        |
| /loggers        | 显示并更新日志配置                                           | Y        |
| /shutdown       | 关闭应用程序                                                 | N        |
| /threaddump     | 执行ThreadDump                                               | Y        |
| /headdump       | 返回HeadDump文件，格式为HPROF                                | Y        |
| /prometheus     | 返回可供Prometheus抓取的信息                                 | Y        |

举例：

http://localhost:8080/actuator/beans

![image-20191217063204378](02-SpringBoot-%E8%AE%B2%E4%B9%89.assets/image-20191217063204378.png)

http://localhost:8080/actuator/mappings

![image-20191217063320936](02-SpringBoot-%E8%AE%B2%E4%B9%89.assets/image-20191217063320936.png)

## 10.3 配置

```properties
# 暴露所有的监控点
management.endpoints.web.exposure.include=*
# 定义Actuator访问路径
management.endpoints.web.base-path=/act
# 开启endpoint 关闭服务功能
management.endpoint.shutdown.enabled=true

# 连接SpringBoot的admin
spring.boot.admin.client.url=http://localhost:9000
```

## 10.4 通过Spring Boot Admin了解程序的运行状态

目的：为SpringBoot应用程序提供一套管理界面

主要功能：

- 集中展示应用程序Actuator相关的内容
- 变更通知

### **搭建服务端：**

①创建 admin-server 模块

![image-20191217065058593](02-SpringBoot-%E8%AE%B2%E4%B9%89.assets/image-20191217065058593.png)

②导入依赖坐标 admin-starter-server

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.9.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.itheima</groupId>
    <artifactId>springboot06-admin-server</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springboot06-admin-server</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
        <spring-boot-admin.version>2.1.5</spring-boot-admin.version>
    </properties>

    <dependencies>
        <!--导入spring boot admin 服务端的启动依赖坐标
        注意：必须导入其依赖管理清单bom
        -->
        <dependency>
            <groupId>de.codecentric</groupId>
            <artifactId>spring-boot-admin-starter-server</artifactId>
        </dependency>
    </dependencies>
    <!--spring boot admin的依赖管理清单-->
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>de.codecentric</groupId>
                <artifactId>spring-boot-admin-dependencies</artifactId>
                <version>${spring-boot-admin.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
</project>

```

③在引导类上启用监控功能@EnableAdminServer

```java
@SpringBootApplication
@EnableAdminServer
public class Springboot06AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot06AdminServerApplication.class, args);
    }

}
```



### **配置客户端：**

①创建 admin-client 模块

②导入依赖坐标 admin-starter-client

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.9.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.itheima</groupId>
    <artifactId>springboot06-actuator</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springboot06-actuator</name>
    <description>Demo project for Spring Boot</description>
    <dependencies>

        <!--spring boot admin 客户端依赖坐标-->
        <dependency>
            <groupId>de.codecentric</groupId>
            <artifactId>spring-boot-admin-starter-client</artifactId>
        </dependency>
        <!--SpringBoot的生产级监控 Actuator依赖坐标-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
    <!--spring boot admin的bom-->
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>de.codecentric</groupId>
                <artifactId>spring-boot-admin-dependencies</artifactId>
                <version>2.1.5</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
</project>
```

③配置相关信息：server地址等

```properties
# 暴露所有的监控点
management.endpoints.web.exposure.include=*
# 定义Actuator访问路径
management.endpoints.web.base-path=/act
# 开启endpoint 关闭服务功能
management.endpoint.shutdown.enabled=true

# 连接SpringBoot的admin
spring.boot.admin.client.url=http://localhost:9000
```

④启动server和client服务，访问server

![image-20191217065601483](02-SpringBoot-%E8%AE%B2%E4%B9%89.assets/image-20191217065601483.png)

![image-20191217065635826](02-SpringBoot-%E8%AE%B2%E4%B9%89.assets/image-20191217065635826.png)

# 总结

- 掌握工程热部署
- 掌握多环境的配置文件
- 掌握配置文件存放路径，及其加载顺序
- 掌握自定义配置文件名称application.yml
- 了解SpringBoot自动配置实现原理【不要求掌握】
- 掌握内置web应用服务器的切换：tomcat切换为jetty
- 了解为SpringBoot配置生产级监控Actuator
- 搭建Spring Boot Admin服务链接SpringBoot项目