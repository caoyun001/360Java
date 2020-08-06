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
           取出域对象的数据
           request域对象数据,存储的PageBean对象
           从PageBean对象中,取出List集合,遍历
        --%>
        <c:forEach items="${pageBean.list}" var="permission">
           <tr>
             <td>${permission.id}</td>
             <td>${permission.name}</td>
             <td>${permission.keyword}</td>
             <td>${permission.description}</td>

             <td><a class="btn btn-default btn-sm"
                    href="#">修改</a>

              <a  class= "btn btn-default btn-sm"
                  href="#">删除</a></td>
           </tr>
        </c:forEach>
      </table>
	  
	  <!--分页工具条-->
	  <nav class="text-center">
        <ul class="pagination">

          <%--
             上一页按钮
             计算方式: 上一页=当前页-1
             超链接发送请求,提交当前页-1

             按钮当到到第一页的时候,不能再点了
         --%>
           <c:if test="${pageBean.currentPage==1}">
            <li class="disabled">
              <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
           </c:if>

        <%--不是第一页,按钮可以点击--%>
            <c:if test="${pageBean.currentPage!=1}">
            <li >
              <a href="${pageContext.request.contextPath}/permission?operator=queryByPage&currentPage=${pageBean.currentPage-1}" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
            </c:if>
          <%--
             页码处理
             页码是从1开始,到总页数结束
             总页数在PageBean对象中的变量 totalPage
             循环出现来的
             页码显示的是循环中变量
          --%>
          <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
            <%--
                点击页码,向服务器发送请求,提交当前页数
                超链接请求,传递参数
                如果页码正好是当前页,不能点击
                循环中的变量,就是页码
                判断: 页码是不是=当前页数  (PageBean对象的属性currentPage)
            --%>
            <c:if test="${pageBean.currentPage==i}">
                 <li class="active"><a href="#">${i}</a></li>
            </c:if>

            <c:if test="${pageBean.currentPage!=i}">
              <li><a href="${pageContext.request.contextPath}/permission?operator=queryByPage&currentPage=${i}">${i}</a></li>
            </c:if>

          </c:forEach>
            <%--<li class="active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>--%>



          <%--
           下一页 = 当前页+1

           判断,如果已经是最后一页,不能点击
           当前页=总页数,就是最后一页
          --%>`

            <c:if test="${pageBean.currentPage == pageBean.totalPage}">
              <li class="disabled">
                <a href="#" aria-label="Next">
                  <span aria-hidden="true">&raquo;</span>
                </a>
              </li>
            </c:if>

            <c:if test="${pageBean.currentPage != pageBean.totalPage}">
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