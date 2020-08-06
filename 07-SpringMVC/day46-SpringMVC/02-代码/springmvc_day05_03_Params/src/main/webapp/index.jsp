<%--
  Created by IntelliJ IDEA.
  User: 小玉
  Date: 2019/11/19
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <h3>请求惨绑定</h3>

    <fieldset>
        <h4>功能1: 默认支持ServletAPI</h4>
        <a href="${pageContext.request.contextPath}/params/gotoParams.do?id=123&name=lisi">测试</a>
    </fieldset>

    <fieldset>
        <h4>功能2: 绑定简单的数据类型</h4>
        <a href="${pageContext.request.contextPath}/params/gotoParamsBase.do?isVIP=0">测试</a>
    </fieldset>

    <fieldset>
        <h4>功能3: @RequsestParam注解的使用</h4>
        <a href="${pageContext.request.contextPath}/params/gotoParamsRequestParam.do?id=1001">测试</a>
    </fieldset>

    <fieldset>
        <h4>功能4: 绑定pojo对象</h4>
        <a href="${pageContext.request.contextPath}/params/gotoParamsPojo.do?id=2&name=lisi">测试</a>
    </fieldset>

    <fieldset>
        <h4>功能5: 绑定pojo对象的包装对象</h4>
        <a href="${pageContext.request.contextPath}/params/gotoParamsQueryVo.do?user.id=2&user.name=zhang3">测试</a>
    </fieldset>

    <fieldset>
        <h4>功能6: 绑定List集合包装pojo对象</h4>
        <form action="${pageContext.request.contextPath}/params/gotoParamsList.do" method="get">
            <table>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>sex</th>
                </tr>
                <tr>
                    <td><input type="text" name="userList[0].id" placeholder="请输入ID"></td>
                    <td><input type="text" name="userList[0].name" placeholder="请输入用户名"></td>
                    <td><input type="text" name="userList[0].sex" placeholder="请输入性别"></td>
                </tr>
                <tr>
                    <td><input type="text" name="userList[1].id" placeholder="请输入ID"></td>
                    <td><input type="text" name="userList[1].name" placeholder="请输入用户名"></td>
                    <td><input type="text" name="userList[1].sex" placeholder="请输入性别"></td>
                </tr>
            </table>


            <input type="submit" value="提交">
        </form>
    </fieldset>

    <fieldset>
        <h4>功能7: 绑定Map集合包装pojo对象</h4>
        <form action="${pageContext.request.contextPath}/params/gotoParamsMap.do" method="post">
            <table>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>sex</th>
                </tr>
                <tr>
                    <td><input type="text" name="userMap['user001'].id" placeholder="请输入ID"></td>
                    <td><input type="text" name="userMap['user001'].name" placeholder="请输入用户名"></td>
                    <td><input type="text" name="userMap['user001'].sex" placeholder="请输入性别"></td>
                </tr>
                <tr>
                    <td><input type="text" name="userMap['user002'].id" placeholder="请输入ID"></td>
                    <td><input type="text" name="userMap['user002'].name" placeholder="请输入用户名"></td>
                    <td><input type="text" name="userMap['user002'].sex" placeholder="请输入性别"></td>
                </tr>
            </table>


            <input type="submit" value="提交">
        </form>
    </fieldset>

    <fieldset>
        <h4>08: 获取请求参数，字符串转成日期对象</h4>
        <a href="${pageContext.request.contextPath}/params/sendParamsDate.do?date=2019-11-19">字符串转成日期对象</a><br>
    </fieldset>

    <fieldset>
        <h4>09: 获取请求头参数，@RequestHeader注解</h4>
        <a href="${pageContext.request.contextPath}/params/sendParamsHeader.do">获取请求头参数</a><br>
    </fieldset>

    <fieldset>
        <h4>10: 获取指定的Cookie的value值，@CookieValue注解</h4>
        <a href="${pageContext.request.contextPath}/params/sendParamsCookie.do">获取指定的Cookie的value值</a><br>
    </fieldset>
</body>
</html>
