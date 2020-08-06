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
    <%--加载js文件--%>
    <script src="./js/vue.js"></script>
    <script src="./js/axios-0.18.0.js"></script>

</head>
<body>
    SpringMVC框架的拦截器的登录案例
    <fieldset>
        <form action="http://localhost:8080/default/login.do" method="post">
            <input type="text" name="username" placeholder="请输入用户名">
            <input type="text" name="password" placeholder="请输入密码">
            <input type="submit" value="登录">
        </form>
    </fieldset>

</body>
</html>
