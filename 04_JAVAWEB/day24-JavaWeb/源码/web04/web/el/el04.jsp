<%@ page import="com.itheima.pojo.User" %>
<%@ page import="com.itheima.pojo.Address" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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

        Map<String,User> map = new HashMap<String, User>();
        map.put("user1",user1);
        map.put("user2",user2);

        pageContext.setAttribute("map",map);
    %>

    <%--
            取出数据 李四 武清
            是Map集合中的键 user2对应值

            域对象键名.Map集合的键名
            写法: 防君子不防小人
            域对象键名['Map集合键名']

             map.put("user.1",user1);
     --%>

    ${map['user2'].username}
    ${map['user2'].address.area}



</body>
</html>
