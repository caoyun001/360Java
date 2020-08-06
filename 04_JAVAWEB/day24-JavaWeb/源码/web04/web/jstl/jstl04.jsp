<%@ page import="java.util.List" %>
<%@ page import="com.itheima.pojo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
       foreach标签: 增强for循环
       遍历数组,遍历集合
       属性:
         items: 遍历的容器
         var: 遍历的容器中的每个元素,存储在pageContext域对象
             var属性值,就是域对象的键名

         varStatus(变量状态属性):
              varStatus="vs": 会将对象,存在pageContext域中
              域对象的键名就是 vs
              对象,是定义了循环状态的对象
              对象中.有个属性count,循环的次数


       输出循环的次数
       int count = 0;
       for(String s: str){
           count++;
          System.out.println(s);
       }
    --%>
    <%
        String[] strs = {"i","love","java"};
        pageContext.setAttribute("strs",strs);
    %>

    <c:forEach items="${strs}" var="s" varStatus="vs">
        <%--EL 在pageContext域中取出键值对,键是s,值是数组元素--%>
        ${s}  ${vs.count} <br>
    </c:forEach>
    <hr>

    <%--
       集合,存储User对象
    --%>
    <%
        List<User> list = new ArrayList<User>();
        User u1 = new User();
        u1.setUsername("张三");
        u1.setPassword("123");

        User u2 = new User();
        u2.setUsername("李四");
        u2.setPassword("456");

        list.add(u1);
        list.add(u2);

        pageContext.setAttribute("list",list);
    %>

    <%--
        $ {list} 域对象中的键,取出的值,值是List集合
        var: 集合中的元素,存储到pageContext域对象,
        s: 域对象的键名
    --%>
    <c:forEach items="${list}" var="s">
        ${s.username}  ${s.password}
    </c:forEach>




</body>
</html>
