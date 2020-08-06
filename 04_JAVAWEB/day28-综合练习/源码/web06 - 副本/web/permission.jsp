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

    <script type="text/javascript">
      function del(id) {
          //提示判断
          if(confirm("确定要删除吗?")){
            //服务器发送请求,提交主键
              location.href = "${pageContext.request.contextPath}/permission?operator=delPermission&id="+id;
          }
      }
    </script>

  </head>
  <body>
    <div class="container-fluid">
      <table class="table table-bordered  table-hover">
        <tr>
          <td colspan="9">
            <form action="/permission?operator=queryByWhere" method="post">
              <input type="text" name="name"> 权限名称查询   <input type="text" name="keyword"> 权限编码  <input type="submit" value="查询"  class="btn btn-default">
            </form>
            &nbsp;&nbsp;<a href="addPermission.jsp" class="btn btn-default">添加</a>
          </td>
        </tr>
        <tr class="bg-primary">
          <th>序号</th>
          <th>权限名称</th>
          <th>权限编码</th>
          <th>权限描述</th>
          <th>操作</th>
        </tr>

        <%--标签循环,取出域对象中的集合,遍历--%>
        <c:forEach items="${permissionList}" var="permission">
           <tr>
             <td>${permission.id}</td>
             <td>${permission.name}</td>
             <td>${permission.keyword}</td>
             <td>${permission.description}</td>
             <td>
               <%--
                  修改数据,先要回显数据
                  发请求,根据主键查询
               --%>
               <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/permission?operator=queryById&id=${permission.id}">修改</a>
               <%--
                  提示用户是否确定删除
                  JS的事件
                  点击删除按钮,调用JS的函数,函数传递主键

                  href="#" 超链接地址,写#号,表示当前页面
                  阻止页面从新打开,不能写 #

                  javascript:;
                  javasctipt:void(0)
               --%>
               <a  class= "btn btn-default btn-sm" href="javascript:void(0)" onclick="del(${permission.id})">删除</a></td>
           </tr>
        </c:forEach>
    
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
