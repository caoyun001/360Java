<%--
  Created by IntelliJ IDEA.
  User: 小玉
  Date: 2019/11/19
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <h3>SpringMVC框架的RequestMapping注解</h3>

    <fieldset>
        <h4>用法1: 多个URL路径映射到同一个Handler（同一个方法）</h4>
        <a href="http://localhost:8080/gotoResultURL1.do">测试路径1</a>
        <a href="${pageContext.request.contextPath}/gotoResultURL2.do">测试路径2</a>
    </fieldset>

    <fieldset>
        <h4>用法2:RequestMapping注解作用在类上，实现对请求路径的分类管理，限定类中方法访问的前缀</h4>
        <a href="http://localhost:8080/default/gotoResultURL1.do">测试Default路径</a>
        <a href="${pageContext.request.contextPath}/user/gotoResultURL1.do">测试User路径</a>
    </fieldset>

    <fieldset>
        <h4>用法3 method属性限定请求方法: 请求的handler相同，请求方式不同进入不同方法处理</h4>
        <a href="http://localhost:8080/default/gotoResultMethod.do">Get方式测试</a>
        <form action="http://localhost:8080/default/gotoResultMethod.do" method="post">
            <input type="submit" value="Post方式测试">
        </form>
    </fieldset>

    <fieldset>
        <h4>用法4 params属性限定请求参数 : 支持简单的表达式语法，url一样，根据携带参数的不同进入不同的方法处理</h4>
        <a href="http://localhost:8080/user/login.do?type=user">普通用户</a>
        <a href="http://localhost:8080/user/login.do?type=admin">管理员</a>
        <a href="http://localhost:8080/user/login.do?type=vip">VIP</a>
    </fieldset>
</body>
</html>
