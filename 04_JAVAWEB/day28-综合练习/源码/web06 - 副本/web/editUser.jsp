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
        <form action="UserServlet?cmd=saveUpdateUser" method="post" class="form-horizontal">
               <h3>更新用户</h3>
            <hr width="80%" align="left"/>
                <div class="form-group" >
                <label for="name" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-5">
                    <input type="text" class="form-control" id="name" value="${user.username}" name="name">
                        <input type="hidden" class="form-control" id="id" value="${user.id}" name="id">
                    </div>
                </div>

                <div class="form-group" >
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-5">
                        <input type="password" class="form-control" id="password" value="${user.password}" name="password">
                    </div>
                </div>

                <div class="form-group" >
                    <label for="email" class="col-sm-2 control-label">邮箱</label>
                    <div class="col-sm-5">
                        <input type="email" class="form-control" id="email" value="${user.email}" name="email">
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">角色</label>
                    <div class="col-sm-5">
                       <c:forEach items="${user.roles}"  var="role" varStatus="st">
                           <c:if test="${st.index != 0 and st.index % 4 == 0 }">
                               <br/>
                           </c:if>
                           <c:if test="${role.flag == 1}">
                               <input  type="checkbox" value="${role.id}" name="role" checked>${role.name}  &nbsp;&nbsp;
                           </c:if>
                           <c:if test="${role.flag != 1}">
                               <input  type="checkbox" value="${role.id}" name="role">${role.name}  &nbsp;&nbsp;
                           </c:if>
                       </c:forEach>
                    </div>
                </div>

                <div class="form-group" align="left">
                    <label for="source" class="col-sm-2 control-label">用户来源</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="source" value="${user.source}" name="source">
                    </div>
                </div>

            <div class="form-group" align="left">
                <label for="remark" class="col-sm-2 control-label">备注</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="remark" value="${user.remark}" name="remark">
                </div>
            </div>

            <div class="form-group" align="left">
                <label  class="col-sm-2 control-label">是否可用</label>
                <div class="col-sm-5">
                    <c:if test="${user.state == 0}">
                        启用&nbsp;&nbsp;<input type="radio"  value="0" checked  name="status">&nbsp;&nbsp;
                        禁用&nbsp;&nbsp;<input type="radio"  value="1"  name="status">
                    </c:if>
                    <c:if test="${user.state != 0}">
                        启用&nbsp;&nbsp;<input type="radio"  value="0"   name="status">&nbsp;&nbsp;
                        禁用&nbsp;&nbsp;<input type="radio"  value="1"  checked name="status">
                    </c:if>

                </div>
            </div>
            <div class="col-md-4 col-md-offset-3">
            <input  type="submit" value="保存" class="btn-primary">
            <input  type="button" onclick="javascript:window.history.go(-1)" value="返回" class="btn-primary">
            </div>
        </form>
    </div>

</body>
</html>
