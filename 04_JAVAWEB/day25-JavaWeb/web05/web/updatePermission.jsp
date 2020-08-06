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

  <div class="container">
    <center><h3>权限修改</h3></center>
    <center>
      <form action="${pageContext.request.contextPath}/permission?operator=updatePermission" method="post">

        <%--查询权限的主键,放在表单中,一起提交服务器,不能告诉用户, 隐藏域,不在页面显示--%>
        <input type="hidden" value="${permission.id}" name="id" >

       <%--
           从request域对象中,取出permission对象
           对象中的数据,填充文本输入框中
       --%>
        <div class="form-group" style="width: 45%" align="left">
          <label for="name" >权限名称</label>
          <input type="text" class="form-control" id="name" name="name" value="${permission.name}">
        </div>
        <div class="form-group" style="width: 45%" align="left">
          <label for="name">权限编码</label>
          <input type="text" class="form-control"  name="keyword" value="${permission.keyword}">
        </div>
        <div class="form-group" style="width: 45%" align="left">
          <label for="des">权限描述</label>
          <input type="text" class="form-control" id="des"  name="description" value="${permission.description}">
        </div>
        <center>
          <button type="submit" id="sub" class="btn btn-primary">提交</button>
          <button type="reset" class="btn btn-default">重置</button>
          <button type="button" class="btn btn-default" onclick="javascript:window.history.go(-1)">返回</button>
        </center>
      </form>
    </center>
  </div>
  </body>
</html>
