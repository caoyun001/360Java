<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <a href="addPermission.jsp" class="btn btn-default">添加</a>
          </td>
        </tr>
        <tr class="bg-primary">
          <th>序号</th>
          <th>权限名称</th>
          <th>权限编码</th>
          <th>权限描述</th>
          <th>操作</th>
        </tr>
    
         <tr>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td><a class="btn btn-default btn-sm" href="updatePermission.jsp">修改</a>
             <a  class= "btn btn-default btn-sm" href="#">删除</a></td>
         </tr>
    
      </table>
	  
	  <!--分页工具条-->
	  <nav class="text-center">
        <ul class="pagination">
          <li class="disabled">
            <a href="#" aria-label="Previous">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li>
          <li class="active"><a href="#">1</a></li>
          <li><a href="#">2</a></li>
          <li><a href="#">3</a></li>
          <li><a href="#">4</a></li>
          <li><a href="#">5</a></li>
          <li>
            <a href="#" aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li>
        </ul>
      </nav>
    </div>
    </div>
  </body>
</html>
