<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <style>
      th,td{
        text-align: center;
      }
      td,th{
        font-size: 14px;
      }
    </style>

  </head>
  <body>
    <div class="container-fluid">
      <table class="table table-bordered  table-hover">
        <tr>
          <td colspan="9" align="left">
            <a href="RoleServlet?cmd=toAddPermission" class="btn btn-default">添加</a>
          </td>
        </tr>
        <tr class="bg-primary">
          <th>序号</th>
          <th>角色名称</th>
          <th>权限</th>
          <th>操作</th>
        </tr>
       <c:forEach items="${roleList}" var="role">
         <tr>
           <td>${role.id}</td>
           <td>${role.name}</td>
           <td align="left">
             <c:forEach items="${role.permissionList}" var="per" varStatus="st">
                <c:if test="${st.index > 0 and st.index % 5 == 0 }">
                  <br/>
                </c:if>
               &nbsp;&nbsp;  <button class="btn btn-default btn-xs"> ${per.name}</button>
             </c:forEach>
           </td>
           <td><a class="btn btn-default btn-sm" href="RoleServlet?cmd=setPermission&id=${role.id}&name=${role.name}">权限设置</a>  <a class= "btn btn-default btn-sm" href="RoleServlet?cmd=deleteRoleById&id=${role.id}">删除</a></td>
         </tr>
       </c:forEach>
      </table>
    </div>
  </body>
</html>
