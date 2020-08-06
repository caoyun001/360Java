<%@ page import="com.itheima.pojo.User" %>
<%@ page import="com.itheima.pojo.Address" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%--
     EL 表达式取出域对象数据
     User对象封装了Address对象

     创建多个User和多个Address
     存储在集合List
  --%>

  <%
      User user1 = new User();
      User user2 = new User();

      Address address1 = new Address();
      Address address2 = new Address();

      address1.setCity("北京");
      address1.setArea("昌平区");

      address2.setCity("天津");
      address2.setArea("武清");

      user1.setUsername("张三");
      user1.setPassword("123");
      user1.setAddress(address1);

      user2.setUsername("李四");
      user2.setPassword("456");
      user2.setAddress(address2);

      List<User> list = new ArrayList<User>();
      list.add(user1);
      list.add(user2);

      pageContext.setAttribute("list",list);

  %>

   <%--
        < %= %> 取出数据  李四  武清

        pageContext.getAttribute("list") 取出是域对象中的集合List,集合的索引1,才能取到李四
        ((List<User>) pageContext.getAttribute("list"))  强制转成List集合
   --%>
   <%= ((List<User>) pageContext.getAttribute("list")).get(1).getUsername()  %>

  <%= ((List<User>) pageContext.getAttribute("list")).get(1).getAddress().getArea()  %>

  <hr>

  <%--
       EL 取出数据  李四  武清
        $ {list} 取出域对象pageContext中的集合List,集合的索引1
        $ {list[1]} 集合的索引, 1索引就是User对象
  --%>

  ${list[1].username}
  ${list[1].address.area}
</body>
</html>
