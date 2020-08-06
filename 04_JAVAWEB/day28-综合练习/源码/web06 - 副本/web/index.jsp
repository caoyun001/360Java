<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link href="css/bootstrap.css" rel="stylesheet">
	<script src="js/jquery-1.11.3.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<style>
		a,td,th{
			font-size: 15px;
		}

		div a {
			margin-top: 25px;
			line-height: 13px;
		}
	</style>
<title>Insert title here</title>
</head>
<body style="margin:0px;">
	<div class="container-fluid">
		<div class="row" >
			<div class="col-md-2 ">
				<img src="img/logo2.png" />
			</div>
			<div class="col-md-3 col-md-offset-3 "  style="vertical-align: middle">
				<font color="#4169e1" style="font-family: 华文琥珀; font-size: 30px">传&nbsp;智&nbsp;播&nbsp;客&nbsp;权&nbsp;限&nbsp;管&nbsp;理</font>
			</div>
		</div>
	</div>
	<table class="table table-condensed" style="height: 550px" >
		<tr>
			<td style="width:140px;" valign="top" align="center">
				<div align="right">
					<a class="btn btn-default" target="dataFrame" href="${pageContext.request.contextPath}/permission?operator=queryByPage">权限分页</a>
				</div>

				<div align="right">
					<a class="btn btn-default" target="dataFrame" href="${pageContext.request.contextPath}/permission?operator=queryAll">权限列表</a>
				</div>
				<div align="right">
					<a class="btn btn-default" target="dataFrame" href="${pageContext.request.contextPath}/roleListServlet">角色列表</a>
				</div>
				<div align="right">
					<a class="btn btn-default" target="dataFrame" href="${pageContext.request.contextPath}/userListServlet">用户列表</a>
				</div>
			</td>
			<td>
				<iframe name="dataFrame" frameborder="0" height="100%" width="100%" src="welcome.jsp">

				</iframe>
			</td>
		</tr>

	</table>
</body>
</html>