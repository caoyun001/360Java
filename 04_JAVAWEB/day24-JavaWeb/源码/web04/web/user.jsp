<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            font-size: 20px;
        }
    </style>
</head>
<body>
    <%--
      每个超链接上添加参数,告知服务器,我要做什么
    --%>
    <a href="${pageContext.request.contextPath}/user?operator=login">登录</a> <br>
    <a href="${pageContext.request.contextPath}/user?operator=register">注册</a> <br>
    <a href="${pageContext.request.contextPath}/user?operator=updatePassword">改密</a> <br>
    <a href="${pageContext.request.contextPath}/user?operator=findPassword">找回密码</a> <br>

</body>
</html>
