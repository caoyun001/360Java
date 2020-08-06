
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
       EL表达式 内置对象
       用到了内置的4个对象
       applicationScope   ServletContext域
       sessionScope       session域
       requestScope       request域
       pageScope          pageContext域

       pageContext 是EL中的内置对象
       内置对象,获取到JSP中的九大内置对象
       request对象.getContextPath()获取Web应用名称
       getContextPath()
    --%>
   ${pageContext.request.contextPath}

  <form action="${pageContext.request.contextPath}/servlet" method="post">

      <input type="submit">
  </form>
</body>
</html>
