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
          <td colspan="9">
            <a href="UserServlet?cmd=toAddUser" class="btn btn-default">添加</a>
          </td>
        </tr>
        <tr class="bg-primary">
          <th>序号</th>
          <th>用户名</th>
          <th>邮箱</th>
          <th>角色</th>
          <th>来源</th>
          <th>创建日期</th>
          <th>备注</th>
          <th>状态</th>
          <th>操作</th>
        </tr>
       <c:forEach items="${users}" var="user">
         <tr>
           <td>${user.id}</td>
           <td>${user.username}</td>
           <td>${user.email}</td>
           <td>

               <c:forEach items="${user.roles}" var="role" varStatus="st">
                 <c:if test="${st.index != 0 and st.index % 3 == 0 }">
                   <br/>
                 </c:if>
                 <c:if test="${user.roles != null and user.roles !='' }">
                 &nbsp; &nbsp;<button class="btn btn-default btn-xs">${role.name}</button>
                 </c:if>
                 <c:if test="${user.roles == null or user.roles == ''}">
                   <button class="btn btn-default btn-xs">未分配角色</button>
                 </c:if>
               </c:forEach>
           </td>
           <td>${user.source}</td>
           <td>${user.create_date}</td>
           <td>${user.remark}</td>
           <td>
             <c:if test="${user.state == 0}">
               启用
             </c:if>
             <c:if test="${user.state != 0}">
               禁用
             </c:if>
           </td>
           <td><a class="btn btn-default btn-sm" href="UserServlet?cmd=editUser&id=${user.id}">修改</a>
               <a class= "btn btn-default btn-sm" href="UserServlet?cmd=deleteUser&id=${user.id}">删除</a></td>
         </tr>
       </c:forEach>
      </table>

    </div>
  </body>
</html>
