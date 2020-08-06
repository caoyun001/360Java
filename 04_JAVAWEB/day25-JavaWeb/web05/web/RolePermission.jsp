<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <form action="RoleServlet?cmd=updatePermission" method="post">
               <h3>角色权限配置</h3>
            <hr width="80%" align="left"/>
                  角色名称
                  <input type="text" name="roleName" value="${role.name}" disabled>
                        <input type="hidden" name="roleId" value="${role.id}">

            <br/><br/>
            <h3>权限配置</h3>
            <hr width="80%" align="left"/>
                <c:forEach items="${permissions}" var="per" varStatus="st">
                    <c:if test="${st.index > 0 and st.index % 6 == 0  }">
                        <br/> <br/>
                    </c:if>
                    <c:if test="${per.flag == 1}">
                        <input  type="checkbox" value="${per.id}" name="permissionIds" checked> ${per.name} &nbsp; &nbsp; &nbsp;
                    </c:if>
                    <c:if test="${per.flag != 1}">
                        <input  type="checkbox" value="${per.id}" name="permissionIds" > ${per.name} &nbsp; &nbsp; &nbsp;
                    </c:if>

                </c:forEach>
           <br/><br/>

            <input  type="submit" value="保存" class="btn-primary">
            <input  type="button" onclick="javascript:window.history.go(-1)" value="返回" class="btn-primary">
        </form>
    </div>

</body>
</html>
