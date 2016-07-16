<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.linkyuji.pojo.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link
	href="<%=request.getContextPath()%>/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">

<style type="text/css">
.left {
	float: left;
	height: 800px;
	width: 15%;
	background: #dfdfdf
}

.right {
	float: right;
	height: 800px;
	width: 85%;
}

.htmlurl {
	float: right;
	height: 100%;
	width: 100%;
}
</style>

</head>
<%-- <script src="<%=request.getContextPath()%>/jquery/jquery-1.8.0.min.js"></script>
<script src="<%=request.getContextPath()%>/js/manager.js"></script> --%>
<body>
	<%
		Users a = (Users) session.getAttribute("user");
		if (a == null || a.getUsertype() != 1) {
	%>
	<meta http-equiv="refresh"
		content="0;url=<%=request.getContextPath()%>/login.jsp">

	<%
		return;
		}
	%>

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">管理员界面</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
			<li><a><%=a.getUserid() %></a></li>
				<li><a href="<%=request.getContextPath()%>/jsp/exit.jsp">注销</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a
						href="<%=request.getContextPath()%>/jsp/admin/indexuser.jsp">主页
							<span class="sr-only">(current)</span>
					</a></li>
					<li><a href="loaduser.do">用户管理</a></li>
					<li><a href="loadfile.do">文件管理</a></li>
					<li class="active"><a href="loadblog.do">文本管理</a></li>
				</ul>

			</div>
			<div id="managerurl"
				class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="sub-header">文本管理</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th style="width: 5%">博客ID</th>
								<th style="width: 65%">标题</th>
								<th style="width: 20%">修改时间</th>
								<th style="width: 10%">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allblog}" var="bloginfo" varStatus="status">
								<tr>
									<td>${bloginfo.idbloginfo}</td>
									<td><a href="readblog.jsp?item=${status.index}">${bloginfo.blogname}</a></td>
									<td>${bloginfo.modifydate}</td>
									<td><a
										href="deleteblog.do?idbloginfo=${bloginfo.idbloginfo}">删除</a></td>
									<!-- 自定义标签 -->
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<%=request.getContextPath()%>/jquery/jquery-1.8.0.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

</body>
</html>