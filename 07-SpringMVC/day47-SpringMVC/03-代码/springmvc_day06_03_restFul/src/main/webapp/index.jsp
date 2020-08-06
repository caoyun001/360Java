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
    <h3>SpringMVC框架的 RestFul风格的URL介绍</h3>
    <fieldset>
        <h4>查询, get</h4>
        <a href="${pageContext.request.contextPath}/user/1">Get测试</a>
    </fieldset>

    <fieldset>
        <h4>增加, post</h4>
        <form action="${pageContext.request.contextPath}/user/1" method="post">
           <input type="submit" value="post测试">
        </form>
    </fieldset>

    <fieldset>
        <h4>更新, Put</h4>
        <form action="${pageContext.request.contextPath}/user/1" method="post">
            <input type="hidden" name="_method" value="PUT">
            <input type="submit" value="PUT测试">
        </form>
    </fieldset>

    <fieldset>
        <h4>删除, Delete</h4>
        <form action="${pageContext.request.contextPath}/user/1" method="post">
            <input type="hidden" name="_method" value="DELETE">
            <input type="submit" value="DELETE测试">
        </form>
    </fieldset>

</body>
</html>
