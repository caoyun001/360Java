<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  ${message}
  <form method="post" action="${pageContext.request.contextPath}/login">
      用户名: <input type="text" name="username"><br>
      密的码: <input type="password" name="password"> <br>
      <input type="submit" value="登录">
  </form>
</body>
</html>
