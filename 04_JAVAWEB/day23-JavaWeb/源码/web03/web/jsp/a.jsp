<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <!--
     Java代码,嵌入到HTML语言中
     称为jsp技术

     < %
          嵌入Java代码
          以前怎么写,现在一样
          判断,循环,调用方法,定义变量...
      %>

      < %=
         相当于是输出语句
         变量 输出在页面中
      %>
  -->
 <%
     Date date = new Date();
     int a = 1;
     System.out.println(date.toString());
 %>

 <%= date   %>

 <%!
   double d = 1.5;
 %>
</body>
</html>
