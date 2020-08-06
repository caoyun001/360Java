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
    <center><h3>新增权限</h3></center>
    <center>
      <form action="PermissionServlet?cmd=addPermission" method="post">
        <div class="form-group" style="width: 45%" align="left">
          <label for="name" >权限名称</label>
          <input type="text" class="form-control" id="name" name="name" >
        </div>
        <div class="form-group" style="width: 45%" align="left">
          <label for="keyword">权限编码</label>
          <input type="text" class="form-control" id="keyword" name="keyword" >
        </div>
        <div class="form-group" style="width: 45%" align="left">
          <label for="des">权限描述</label>
          <input type="text" class="form-control"  id="des"  name="des" >
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
