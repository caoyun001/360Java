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

          <%--
             域中取出数据
             域对象的键名pageBean
             属性list
          --%>
        <c:forEach items="${pageBean.list}" var="permission">
           <tr>
             <td>${permission.id}</td>
             <td>${permission.name}</td>
             <td>${permission.keyword}</td>
             <td>${permission.description}</td>
             <td>

               <a class="btn btn-default btn-sm" href="#">修改</a>

               <a  class= "btn btn-default btn-sm" href="javascript:void(0)" >删除</a></td>
           </tr>
        </c:forEach>
    
      </table>
	  
	  <!--分页工具条-->
	  <nav class="text-center">
        <ul class="pagination">

          <%--
             上一页 = 当前页-1

             判断如果已经是第一页,不能点击
             判断当前页==1
          --%>

          <c:if test="${pageBean.currentPage==1}">
            <li class="disabled">
              <a href="javascript:;" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
          </c:if>

            <c:if test="${pageBean.currentPage!=1}">
              <li>
                <a href="${pageContext.request.contextPath}/permission?operator=queryByPage&currentPage=${pageBean.currentPage-1}" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
                </a>
              </li>
            </c:if>


          <%--
             处理页码
             循环出来的,开始是1,到总页数结束

             点击页码,当前点击页数,提交到服务器
          --%>
          <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
            <%--
               当前页不能点击
               循环变量是页码 == currentPage 判定是当前页, 不能点击
            --%>
            <c:if test="${pageBean.currentPage==i}">
              <li class="active"><a href="javascript:;">${i}</a></li>
            </c:if>

            <c:if test="${pageBean.currentPage!=i}">
              <li><a href="${pageContext.request.contextPath}/permission?operator=queryByPage&currentPage=${i}">${i}</a></li>
            </c:if>

          </c:forEach>

            <%--
               下一页 = 当前页+1

               已经是最后一页,不能点击
               currentPag当前页==totalPage总页数,最后一页,不能点击

            --%>
            <c:if test="${pageBean.currentPage==pageBean.totalPage}">

              <li class="disabled">
                <a href="javascript:;" aria-label="Next">
                  <span aria-hidden="true">&raquo;</span>
                </a>
              </li>
            </c:if>

            <c:if test="${pageBean.currentPage!=pageBean.totalPage}">
              <li>
                <a href="${pageContext.request.contextPath}/permission?operator=queryByPage&currentPage=${pageBean.currentPage+1}" aria-label="Next">
                  <span aria-hidden="true">&raquo;</span>
                </a>
              </li>
            </c:if>

        </ul>
      </nav>
    </div>
    </div>
  </body>
</html>
<%--
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
--%>