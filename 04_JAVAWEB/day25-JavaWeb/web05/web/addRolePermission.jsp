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
        <form action="RoleServlet?cmd=addRolePermission" method="post" class="form-horizontal">
               <h3>添加角色</h3>
            <hr width="80%" align="left"/>
                <div class="form-group" >
                <label for="roleName" class="col-sm-2 control-label">设置角色</label>
                    <div class="col-sm-5">
                    <input type="text" class="form-control" id="roleName" placeholder="请输入角色名称" name="roleName">
                    </div>
                </div>
                <div class="form-group" >
                    <label for="keyword" class="col-sm-2 control-label">角色编码</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="keyword" placeholder="请输入角色编码" name="keyword">
                    </div>
                </div>
                <div class="form-group" align="left">
                    <label for="description" class="col-sm-2 control-label">角色描述</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="description" placeholder="请输角色描述" name="description">
                    </div>
                </div>
            <br/>
            <h3>权限配置</h3>
            <hr width="80%" align="left"/>
            <div class="col-md-offset-1" >
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
            </div>
           <br/><br/>

            <input  type="submit" value="保存" class="btn-primary">
            <input  type="button" onclick="javascript:window.history.go(-1)" value="返回" class="btn-primary">
        </form>
    </div>

</body>
</html>
