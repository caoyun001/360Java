# SpringMVC第二天笔记

## 1. Controller方法（Handler）的返回值

### 1.1 返回ModelAndView

* 讲解略,   SpringMVC第一天 已使用

### 1.2 返回字符串（直接返回逻辑视图名，数据使用Model和ModelMap封装）

- ModelAndView = ModelMap+ view（逻辑视图名）
- 现在直接将逻辑视图名以字符串形式return（文件名）
- Model接口方法 addAttribute(String key,Object value)存储键值对，将被存储到request域中

```java
    /**
     *  返回字符串，返回视图逻辑名，文件名
     *  Model接口封装数据
     *  键值对存储request域对象
     */
    @RequestMapping("gotoResultModel")
    public String gotoResultModel(Model model){
        //封装数据
        model.addAttribute("nowDate", new Date()+"====gotoResultModel");
        //指定页面
        return "result";
    }
```

```jsp
<fieldset>
    <h4>方法返回值String, 参数为 Model类型</h4>
    <a href="${pageContext.request.contextPath}/default/gotoResultModel.do">测试</a>
</fieldset>
```

- ModelMap封装数据，方法addAttribute(String key,Object value)存储键值对，将被存储到request域中

```java
/**
 *  返回字符串，返回视图逻辑名，文件名
 *  ModelMap类封装数据
 *  键值对存储request域对象
 *  ModelMap类有获取的方法，而Model接口没有
 */
    @RequestMapping("gotoResultModelMap")
    public String gotoResultModelMap(ModelMap modelMap){
        //封装数据
        modelMap.addAttribute("nowDate", new Date()+"====gotoResultModelMap");
        //指定页面
        return "result";
    }
```

```jsp
    <fieldset>
        <h4>方法返回值String, 参数为 ModelMap类型</h4>
        <a href="${pageContext.request.contextPath}/default/gotoResultModelMap.do">测试</a>
    </fieldset>
```

### 1.3 没有返回值(Request, Response)

- request对象实现转发

```java
    /**
     * 返回值为void类型, 使用Request对象 实现页面跳转(注意: 无法将SpringMVC 提供的Model, ModelMap封装的数据 请求转发到目标页面)
     * @param modelMap
     * @return
     */
    @RequestMapping("gotoResultRequest")
    public void gotoResultRequest(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过SpringMVC框架把封装数据到Request域中( 跳转页面的方式必须采用的是SpringMVC框架提交的方式, 才能把数据 传递过去 )
        modelMap.addAttribute("nowDate", new Date()+"====gotoResultRequest");
        //指定页面
        //请求转发
//        request.setAttribute("键", "值");
        request.getRequestDispatcher("/default/gotoResultModelMap.do").forward(request, response);
    }
```

```jsp
    <fieldset>
        <h4>方法返回值void, 使用Request对象进行跳转页面</h4>
        <a href="${pageContext.request.contextPath}/default/gotoResultRequest.do">测试</a>
    </fieldset>
```

- response对象实现重定向

```java
    /**
     * 返回值为void类型, 使用Response跳转页面 (注意: 无法将SpringMVC 提供的Model, ModelMap封装的数据 重定向到目标页面)
     */
    @RequestMapping("gotoResultResponse")
    public void gotoResultResponse(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过SpringMVC框架把封装数据到Request域中( 跳转页面的方式必须采用的是SpringMVC框架提交的方式, 才能把数据 传递过去 )
        modelMap.addAttribute("nowDate", new Date()+"====gotoResultResponse");
        //指定页面
        //重定向
        //response.sendRedirect("http://localhost:8080/default/gotoResultModelMap.do");
        response.sendRedirect(request.getContextPath()+"/default/gotoResultModelMap.do");
    }
```

```jsp
    <fieldset>
        <h4>方法返回值void, 使用Response对象进行跳转页面</h4>
        <a href="${pageContext.request.contextPath}/default/gotoResultResponse.do">测试</a>
    </fieldset>
```

- response对象响应字符串

```java
/**
 * 直接使用response对象响应字符串
 */
@RequestMapping("gotoResultResponseSendString")
public void gotoResultResponseString(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.getWriter().print("Hello MVC");
}
```

```jsp
<fieldset>
    <p>05测试——SpringMVC（Controller方法没有返回值，response响应字符串）</p>
    <a href="${pageContext.request.contextPath}/default/gotoResultResponseSendString.action">点击测试</a>
</fieldset>
```

### 1.4 SpringMVC格式: 实现重定向和转发的字符串写法

```java
    /**
     * 返回值为String类型, 通过SpringMVC框架 使用重定向 实现页面跳转(注意: 不可以将SpringMVC 提供的Model, ModelMap封装的数据 请求转发到目标页面)
     *
     * 格式用法: redirect:请求的地址
     */
    @RequestMapping("gotoResultRedirect")
    public String gotoResultRedirect(ModelMap modelMap){
        //通过SpringMVC框架把封装数据到Request域中( 跳转页面的方式必须采用的是SpringMVC框架提交的方式, 才能把数据 传递过去 )
        modelMap.addAttribute("nowDate", new Date()+"====gotoResultRedirect");
        //指定页面
        //请求转发
        return "redirect:/default/gotoResultModelMap.do";
    }

    /**
     * 返回值为String类型, 通过SpringMVC框架 使用请求转发 实现页面跳转(注意: 可以将SpringMVC 提供的Model, ModelMap封装的数据 请求转发到目标页面)
     *
     * 格式用法: forward:请求的地址
     */
    @RequestMapping("gotoResultForward")
    public String gotoResultForward(ModelMap modelMap){
        //通过SpringMVC框架把封装数据到Request域中( 跳转页面的方式必须采用的是SpringMVC框架提交的方式, 才能把数据 传递过去 )
        modelMap.addAttribute("nowDate", new Date()+"====gotoResultForward");
        //指定页面
        //请求转发
        return "forward:/default/gotoResultModelMap.do";
    }
```

* index.jsp

```jsp
<fieldset>
    <h4>方法返回值String, 使用SpringMVC的 请求转发进行跳转页面</h4>
    <a href="${pageContext.request.contextPath}/default/gotoResultForward.do">测试</a>
</fieldset>

<fieldset>
    <h4>方法返回值String, 使用SpringMVC的 重定向进行跳转页面</h4>
    <a href="${pageContext.request.contextPath}/default/gotoResultRedirect.do">测试</a>
</fieldset>
```



## 2. Json格式数据实现Ajax交互

  json数据是咱们企业级开发数据交互经常使用的一种方式，它比较轻量级，格式比较清晰

  交互：前端和后端的互动

- 前端传递json字符串到后台，后台如何能够自动转换为pojo对象
- @RequestBody注解，将JSON 字符串转换为POJO对象
  - 作用：用于获取请求体（按照http协议进行一个完整的封装，往往都是由请求头+请求体等组成）内容，不适用于Get请求方式
- 后台return 对象，能否前端直接接收到json格式的字符串
  - @ResponseBody注解
    - 作用：该注解用于将Controller的方法返回的对象转换为json字符串返回给客户端


### AJax的格式:

##### Vue的Ajax异步请求 axios发送get请求

```js
axios.get('/user?id=12345')
    .then(response => {
    	console.log(response.data);
	})
    .catch(error => {
    	console.dir(error)
	});
或
axios.get('/user',{
        params:{
			id:12345
        }
	})
    .then(response => {
    	console.log(response.data);
	})
    .catch(error => {
    	console.dir(error)
	});
```

##### Vue的Ajax异步请求 axios发送post请求

```js
axios.post('/user', json对象)
    .then(response => {
		console.log(response.data);
	})
    .catch(error => {
		console.dir(err)
    });
或
axios.post('/user', 参数字符串)
    .then(response => {
		console.log(response.data);
	})
    .catch(error => {
		console.dir(err)
    });

```

### 代码演示

##### 1. pom.xml

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.1.9.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.1.9.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>servlet-api</artifactId>
        <version>2.5</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>javax.servlet.jsp</groupId>
        <artifactId>jsp-api</artifactId>
        <version>2.2</version>
        <scope>provided</scope>
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

##### 2.index.jsp页面

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <%--导入js文件--%>
    <script src="js/vue.js"></script>
    <script src="js/axios-0.18.0.js"></script>
</head>
<body>
    SpringMVC框架的进行 Ajax 交互

    <fieldset>
        <h4>Ajax 的Json数据</h4>
        <div id="app">
            <input type="button" @click="clickMe()" value="发送Ajax数据">
            <%--使用插值表达式--%>
            {{ userList }}
        </div>
    </fieldset>
</body>
</html>
<script>
    <!-- 创建一个Vue对象 -->
    new Vue({
        el: '#app',
        data:{
            userList: []
        },
        methods:{
            clickMe:function(){

                var params = {id:1, username:'你好', sex:'男'};
                //发起ajax
               axios.post("/ajax/testAjax.do", params)
                   .then(response => {
                       //成功
                       //console.log(response.data);
                       this.userList = response.data
                   }).catch(error =>{
                       //失败
                       console.dir(error);
                   });
            }
        }
    })
</script>

```

##### 3. 处理器 AjaxController.java

```java
/**
 * @RestController: 相当于在类上标记了Controller
 *                  相当于在每一个处理器方法上标记了@ResponseBody
 *
 * @RestController比@Controller 多了 @ResponseBody
 *
 * @ResponseBody: 作用是可以把返回值以流的形式返回ajax
 *                可以把对象转换为json串
 * @RequestBody: 把请求体（json字符串）转换对象， 需要引入json需要的依赖
 */
package com.itheima.controller;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("ajax")
public class AjaxController {

    //测试Ajax的方法
    @RequestMapping("testAjax")
    //@ResponseBody
    public List<User> testAjax(@RequestBody User user){
        //打印接受的数据
        System.out.println("user = " + user);

        //准备给客户端浏览器返回的json数据
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("王五");
        user1.setSex("男");

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("赵六");
        user2.setSex("女");

        ArrayList<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);

        return userList;
    }
}

```



## SpringMVC对Restful风格URL的支持(了解)

### http请求方式：get post put delete 

- get：主要是想做select

- post：主要是想做insert

- put：主要是想做update

- delete：主要是想做delete

- 以上是http协议的标准，但是你用post请求也完全可以完成crud操作（无非就是把参数传递到后台对应处理即可）



### 什么是RESTful？

 RESTful就是一个资源定位及资源操作的风格。不是标准也不是协议，只是一种风格。基于这个风格设计的软件可以更简洁，更有层次。

- 资源：互联网所有的事物都可以被抽象为资源 url

- （只要互联网上的事物可以用一个url来表示，那么它就是一个资源）

- 资源操作：使用POST、DELETE、PUT、GET，使用不同方法对资源进行操作。

  分别对应添加、删除、修改、查询。



### 传统方式操作资源

操作啥（原来url）？操作谁（传入的参数）

url中先定义动作，然后传递的参数表明这个动作操作的是哪个对象（数据）

先定位动作，然后定位对象

`http://localhost:8080/springmvc02/user/queryUserById.do?id=1`查询

`http://localhost:8080/springmvc02/user/saveUser.do`         新增

`http://localhost:8080/springmvc02/user/updateUser.do`          更新

`http://localhost:8080/springmvc02/user/deleteUserById.do?id=1`   删除

 

### 使用RESTful操作资源

**先定义对象**

`http://localhost:8080/springmvc02/user/1`   (操作的对象）  查询,GET

`http://localhost:8080/springmvc02/user`       新增,POST

`http://localhost:8080/springmvc02/user`       更新,PUT

`http://localhost:8080/springmvc02/user/1`   删除,DELETE



### HiddenHttpMethodFilter过滤器

由于浏览器 form 表单只支持 GET 与 POST 请求，而DELETE、PUT 等 method 并不支持，Spring3.0之后添加了一个过滤器，可以将浏览器请求改为指定的请求方式，发送给我们的控制器方法，使得支持 GET、POST、PUT 与DELETE请求.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">

    <!--配置表单 可使用POST、DELETE、PUT、GET，使用不同方法对资源进行操作-->
    <filter>
        <filter-name>methodFilter</filter-name>
        <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>methodFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

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
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
```

- 增加请求参数_method，该参数的取值就是我们需要的请求方式

```java
package com.itheima.controller;

@RestController()
public class RestFulController {
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String find(@PathVariable("id") Integer ids){
        System.out.println("get:"+id);
        return "show";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public String save(@PathVariable("id") Integer id){
        System.out.println("post:"+id);
        return "show";
    }

    //@ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable("id") Integer id){
        System.out.println("put:"+id);
        return "show";
    }

    //@ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        System.out.println("delete:"+id);
        return "show";
    }
}

```

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/user/1">get请求</a>

<form action="${pageContext.request.contextPath}/user/1" method="post">
    <input type="submit" value="post请求">
</form>

<form action="${pageContext.request.contextPath}/user/1" method="post">
    <%--
    1. 该表单的请求方式还必须是post
    2. 添加一个隐藏域，属性名是_method ,值：put或者delete
    3. jsp仅仅支持get和post请求，所有put和delete请求的处理器（方法）必须标记@ResponseBody（或者在类上标记@RestController）
    --%>
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="put请求">
</form>

<form action="${pageContext.request.contextPath}/user/1" method="post">
    <%--
    1. 该表单的请求方式还必须是post
    2. 添加一个隐藏域，属性名是_method ,值：put或者delete
    3. jsp仅仅支持get和post请求，所有put和delete请求的处理器（方法）必须标记@ResponseBody（或者在类上标记@RestController）
    --%>
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="delete请求">
</form>
</body>
</html>
```



## SpringMVC实现文件上传

**前提**

```properties
1. form表单请求方式必须是post
2. 添加form表单的参数：enctype 多部件表单类型 enctype="multipart/form-data"
3. 引入依赖：commons-upload, commons-io
```

#### 1、文件上传

##### a、引入依赖

```xml
<!-- 引入fileUpload会自动依赖commons-io --> 
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.3.1</version>
</dependency>
```

##### b、spring-mvc.xml 配置文件

```xml
<!-- 配置文件上传解析器 -->
<!-- id的值是固定的-->
<bean id="multipartResolver"
				class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		<!-- 设置上传文件的最大尺寸为5MB -->
		<property name="maxUploadSize">
			<value>5242880</value>
		</property>
</bean>
```

##### c、页面配置

```jsp
 <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="uploadFile">
        <input type="text" name="username">
        <input type="submit" value="上传">
    </form>
```

##### d、controller代码

```java
@Controller()
public class UploadController {

    /**
     * 本地上传
     MultipartFile接口方法：
     - String getOriginalFilename()获取上传文件名
     - byte[] getBytes()文件转成字节数组
     - void transferTo(File file)转换方法，将上传文件转换到File对象
     */
    @RequestMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request){

        //32位的随机内容的字符串
        String uuid = UUID.randomUUID().toString().replace("-","");
        //文件名称
        String filename = uploadFile.getOriginalFilename();
        System.out.println("filename = " + filename);

        //文件上传
        String realPath = request.getSession().getServletContext().getRealPath(request.getContextPath() + "/upload");
        File path = new File(realPath, uuid+filename);
        try {
            uploadFile.transferTo(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
```

#### 2、跨服上传

##### a、引入依赖

```xml
<!--引入jersey服务器的包-->
    <dependency>
      <groupId>com.sun.jersey</groupId>
      <artifactId>jersey-core</artifactId>
      <version>1.18.1</version>
    </dependency>
    <dependency>
      <groupId>com.sun.jersey</groupId>
      <artifactId>jersey-client</artifactId>
      <version>1.18.1</version>
    </dependency>
```

##### b、修改tomcat配置

```
1. tomcat默认不能跨服上传的
2. tomcat/conf/web.xml 	
		
    <!--需要添加的-->
	<init-param>
    	<param-name>readonly</param-name>
    	<param-value>false</param-value>
    </init-param>
```

##### c、配置图片服务器

```
1. 创建一个web项目
2. 配置一个tomcat，与原来tomcat端口号不一致
3. 在webapp目录下创建一个upload目录，空的文件夹不会编译，需要在upload目录添加（任意）一个文件
```

##### d、修改controller代码

```java
   /**
     * 跨服上传
       MultipartFile接口方法：
        - String getOriginalFilename()获取上传文件名
        - byte[] getBytes()文件转成字节数组
     */
    @RequestMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request){

        //32位的随机内容的字符串
        String uuid = UUID.randomUUID().toString().replace("-","");
        //文件名称
        String filename = uploadFile.getOriginalFilename();
        System.out.println("filename = " + filename);

        //跨服务器上传
        String serverUrl = "http://localhost:8081/upload";
        //向服务器上传的客户端对象
        Client client = Client.create();
        WebResource resource = client.resource(serverUrl + "/" + uuid + filename);
        //执行上传文件到 指定的服务器
        //转出字节数组开始上传
        try {
            resource.put(String.class, uploadFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }
```

 

## SpringMVC中的统一异常处理

```java
package com.itheima.exception;

@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    /**
     * 解析异常
     * @param request  请求对象
     * @param response 响应对象
     * @param handler 处理器
     * @param ex  异常对象
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        System.out.println("出现了异常");
        ex.printStackTrace();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "系统错误，请联系管理员!!!");
        modelAndView.setViewName("error");
        return modelAndView;
    }
}

```

- springmvc.xml配置异常处理器

```xml
<bean class="com.itheima.exception.MyHandlerExceptionResolver"></bean>
```

