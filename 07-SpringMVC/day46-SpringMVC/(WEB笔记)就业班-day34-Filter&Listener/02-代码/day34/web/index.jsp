<%--
  Created by IntelliJ IDEA.
  User: likepei
  Date: 2019/7/16
  Time: 8:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
    <body>
        <form action="${pageContext.request.contextPath}/safe" method="get">
            <h2>去海边游泳,请选择要携带的物品</h2>
            <input type="checkbox" name="product" value="泳裤"/>泳裤
            <input type="checkbox" name="product" value="比基尼"/>比基尼
            <input type="checkbox" name="product" value="摄像机"/>摄像机
            <input type="checkbox" name="product" value="单反相机"/>单反相机
            <input type="checkbox" name="product" value="防晒油"/>防晒油
            <input type="checkbox" name="product" value="手榴弹"/>手榴弹
            <input type="checkbox" name="product" value="冲锋枪"/>冲锋枪
            <br/>
            <input type="submit" value="提交"/>
        </form>
    </body>
</html>
