<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
       if标签: 判断使用
       注意.没有else标签

       JSTL标签配合EL使用

       <c:if  test=""> if语句判断主体 </c:if>
       test的属性值结果是true,执行判断体
    --%>

   <%
      pageContext.setAttribute("number",3);
   %>

    <c:if test="${number >= 5}">
        <div style="color: red;font-size: 28px">div区域</div>
    </c:if>

    <c:if test="${number < 5}">
        <div style="color: blue;font-size: 28px">div区域</div>
    </c:if>

</body>
</html>
