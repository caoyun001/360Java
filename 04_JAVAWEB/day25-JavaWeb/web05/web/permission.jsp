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
       function del( id) {
           //js内置的函数,直接调用,名字 confirm
           //函数返回值,真假值,返回是true,确认删除
           //var b = confirm("确定要删除吗");
           //alert(b);
           if( confirm("确定要删除吗?") ){
               //服务器发送请求,提交主键id删除
               location.href="${pageContext.request.contextPath}/permission?operator=delPermission&id="+id;
           }
       }
    </script>

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

        <%--
           权限的数据展示在 tr行
           存储在request域对象中
           域对象中,存储的是List,遍历

           循环foreach标签,关键属性 items 属性值就是集合
           List集合,存储的是permission类的对象

           属性 var="属性值"  属性值会作为键,存储在pageContext中
           值就是集合中的元素

        --%>
        <c:forEach items="${requestScope.permissionList}" var="permission">
           <tr>
             <%--EL 表达式,取出permission键对应的值--%>
             <td>${permission.id}</td>
             <td>${permission.name}</td>
             <td>${permission.keyword}</td>
             <td>${permission.description}</td>
               <%--
                  点击修改的超链接的时候
                  服务器发送请求,提交被修改数据的主键
               --%>
             <td><a class="btn btn-default btn-sm"
                    href="${pageContext.request.contextPath}/permission?operator=queryById&id=${permission.id}">修改</a>

               <%--
                 onclick=del() 点击超链接,调用js代码中的函数 del()
                 传递参数,要删除的id传递参数
               --%>
               <a  class= "btn btn-default btn-sm"
                   href="#" onclick="del(${permission.id})">删除</a></td>

                 <%--
                  删除按钮,超链接,点击连接,服务器Servlet发送请求
                  携带参数,是要删除方法名
                  携带要删除的权限的主键id值
               --%>
              <%-- <a  class= "btn btn-default btn-sm"
                   href="${pageContext.request.contextPath}/permission?operator=delPermission&id=${permission.id}">删除</a></td>--%>
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
