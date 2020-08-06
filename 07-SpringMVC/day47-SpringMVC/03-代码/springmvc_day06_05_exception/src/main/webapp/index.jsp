<%--
  Created by IntelliJ IDEA.
  User: 小玉
  Date: 2019/11/19
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <h3>SpringMVC框架的Handler方法的返回值</h3>

    <fieldset>
        <h4>方法返回值String, 参数为 Model类型</h4>
        <a href="${pageContext.request.contextPath}/default/gotoResultModel.do">测试</a>
    </fieldset>

    <fieldset>
        <h4>方法返回值String, 参数为 ModelMap类型</h4>
        <a href="${pageContext.request.contextPath}/default/gotoResultModelMap.do">测试</a>
    </fieldset>

    <fieldset>
        <h4>方法返回值void, 使用Request对象进行跳转页面</h4>
        <a href="${pageContext.request.contextPath}/default/gotoResultRequest.do">测试</a>
    </fieldset>

    <fieldset>
        <h4>方法返回值void, 使用Response对象进行跳转页面</h4>
        <a href="${pageContext.request.contextPath}/default/gotoResultResponse.do">测试</a>
    </fieldset>

    <fieldset>
        <h4>方法返回值String, 使用SpringMVC的 请求转发进行跳转页面</h4>
        <a href="${pageContext.request.contextPath}/default/gotoResultForward.do">测试</a>
    </fieldset>

    <fieldset>
        <h4>方法返回值String, 使用SpringMVC的 重定向进行跳转页面</h4>
        <a href="${pageContext.request.contextPath}/default/gotoResultRedirect.do">测试</a>
    </fieldset>

</body>
</html>
