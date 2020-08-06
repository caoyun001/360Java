<%--
  Created by IntelliJ IDEA.
  User: shisongonly
  Date: 2019/10/15
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <!--
      HTML中嵌入Java代码
      将一个语言,嵌入到另一个语言
      java嵌入到了HTML  (Java换名,脚本语言)
  -->
  <%
      int a = 1;

      if(a > 1){

  %>

        <div style="color: red">div区域一</div>
   <%  } else {%>

        <div style="color: blue">div区域二</div>
   <%}%>
</body>
</html>
