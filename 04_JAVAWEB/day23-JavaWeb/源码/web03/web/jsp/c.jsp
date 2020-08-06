<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: shisongonly
  Date: 2019/10/15
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <!--
      JSP页面的执行原理
      Java代码,归JVM运行,需要编译为class文件

      C:\Users\shisongonly\.IntelliJIdea2017.3\system\tomcat\Tomcat_8_5_32_JavaWeb_4\work\Catalina\localhost\web03\org\apache\jsp\jsp
      直接使用Tomcat运行,文件会在Tomcat的work目录下

      c.jsp 被翻译为  c_jsp.java  编译为 c_jsp.class
      jsp本质就是Servlet!!

      < %  %> 嵌入的Java代码,被翻译到Servlet的service方法

      < %=%> 被翻译到Servlet的service方法,添加输出流

      < %! %> 代码,会翻译到Servlet的成员变量,不会在service方法中
   -->
  <%
      String str = "abcdef111";
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Date date = sdf.parse("2019-1-1");

  %>

 <%=str %>
 <br>
<%=str.length()%>

<%! double d = 1;%>
</body>
</html>
