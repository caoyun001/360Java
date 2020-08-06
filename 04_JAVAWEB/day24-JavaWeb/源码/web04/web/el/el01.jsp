
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%--
       EL表达式,只能写在jsp页面中
       语法 ${表达式}
       EL表达式作用:
          从域对象中取出数据
          ServletContext     整个Web程序
          session            一次会话
          request            一次请求
          pageContext        当前jsp页面
   --%>

   <%
       //ServletContext 域对象存储键值对
       application.setAttribute("key1","app");

       //session  域对象存储键值对
       session.setAttribute("key1","session");

       //request  域对象存储键值对
       request.setAttribute("key1","request");

       //pageContext  域对象存储键值对
       pageContext.setAttribute("key1","page");
   %>

   <%--
      原始方式 < % %> 取出数据
   --%>
   application::  <%= application.getAttribute("key") %> <br/>
   session:: <%= session.getAttribute("key")%> <br/>
   request:: <%= request.getAttribute("key")%> <br/>
   pageContext:: <%= pageContext.getAttribute("key")%> <br/>
   <hr>
  <%--
     EL 表达式取出数据
     xxxxScope.key
     ${applicationScope.键名}   //ServletContext 域对象存储键值对
     ${sessionScope.键名}   //session 域对象存储键值对
     ${requestScope.键名}   //request 域对象存储键值对
     ${pageScope.键名}   //pageContext 域对象存储键值对
  --%>
   application:: ${applicationScope.key}<br/>
   session:: ${sessionScope.key}<br>
   request:: ${requestScope.key}<br>
   pageContext::${pageScope.key}

   <hr>
   <%--
      EL 表达式取出域对象的数据,简化方式,推荐使用
      ${键名}  将会从最小的域对象开始查找,一旦找到,就不会在查找

      友好性: 客户端的友好性
        < %=%> 取出域对象数据,没有此键,页面中显示 null
        ${} 取出域对象的数据,没有次键, 页面中显示 ""
   --%>
   ${key}

</body>
</html>
