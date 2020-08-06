<%@ page import="com.itheima.pojo.Address" %>
<%@ page import="com.itheima.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%--
      EL 表达式取出域对象的数据
      存储的数据是自定义的对象
  --%>

  <%
      Address address = new Address();
      address.setCity("北京市");
      address.setArea("昌平区");

      User user = new User();
      user.setUsername("张三");
      user.setPassword("123");

      //address对象,添加到User对象中
      user.setAddress(address);

      //user对象存储在域对象
      pageContext.setAttribute("user",user);
  %>

   <%--   < %=%>  取出数据, 张三, 昌平区
       pageContext.getAttribute("user") 取出来的对象是User
       张三是User对象的成员变量  getUserName()   类型强制转换
    --%>
   <%= ((User)pageContext.getAttribute("user")).getUsername()  %>

   <%= ((User)pageContext.getAttribute("user")).getAddress().getArea() %>
  <hr>

  <%--
       ${ } 取出数据, 张三, 昌平区

       $ {user} 最小域对象中,取出了 user对象
       EL 无需强制转换
       EL 不需要调用方法,直接写成员变量名即可
  --%>
  ${user.username}

  ${user.address.area}

</body>
</html>
