<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
         foreach标签:循环,包含传统for 和 增强for

         传统for     for(int a = 0 ; a < 10 ;a++){   System.out.println(a) }
         属性;
            begin=""  相当于 a=0
            end=""    相当于 a<10 (包含)
            step="2"   (步长) 相当于 a++   相当于 a+=2
            var="a"    属性var,定义属性值
                    含义: 将循环次数变量,存储到最小域对象 pageContext中
                    键名就是a
                    EL 表达式取出
           <c:foreach>
               循环体
            </c:foreach>
    --%>
    <c:forEach begin="1" end="10" step="2" var="a">
        <div style="color: red;font-size: 28px">div区域  ${a}</div>
    </c:forEach>
</body>
</html>
