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
<script src="<%=request.getContextPath()%>/jquery/jquery-1.8.0.min.js"></script>
<script src="<%=request.getContextPath()%>/js/manager.js"></script>
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
					<li class="active"><a href="loaduser.do">用户管理</a></li>
					<li><a href="loadfile.do">文件管理</a></li>
					<li><a href="loadblog.do">文本管理</a></li>
				</ul>

			</div>


			<%
				request.setCharacterEncoding("UTF-8");
				List<Users> list = (List<Users>) session.getAttribute("userlist");

				String temp = (String) request.getParameter("item");

				Users user = (Users) list.get(Integer.parseInt(temp));
			%>
			<div id="managerurl"
				class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="sub-header">用户管理</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>用户ID</th>
								<th>用户名</th>
								<th>密码</th>
								<th>类型</th>
								<th>操作</th>
							</tr>
						</thead>

						<tbody>

							<tr>
								<form action="modifyuser.do" method="post">
								<td><input
									style='border-left: 0px; border-top: 0px; border-right: 0px; border-bottom: 1px'
									type="text" name="userid" value="<%=user.getUserid()%>"
									readonly="readonly"></td>
								<td><input type="text" name="username"
									value="<%=user.getUsername()%>"></td>
								<td><input type="text" name="password"
									value="<%=user.getUserpsw()%>"></td>
								<td><%=user.getUsertype()%></td>
								<td><input type="submit" value="提交"></td>
								<!-- 自定义标签 -->
								</form>
							</tr>
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