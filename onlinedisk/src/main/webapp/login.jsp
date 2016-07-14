<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<!-- Bootstrap -->
<link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap-3.3.5-dist/img/main.css" rel="stylesheet" >

<style type="text/css">
body {
	margin: 10px;
	padding-top:200px;
	padding-left: 150px;
	padding-right: 150px;
	background-color: #E7EAEB;

	
}

</style>
</head>
<script src="jquery/jquery-1.8.0.min.js"></script>
<script src="js/userlogin.js"></script>

<body>
	
	<center>
	<div style="width: 1700">
		<h1>不就是个网盘嘛</h1>
	<br><br><br><br><br>
	<div style="width:180px;;" >
		<form id="userlogin" class="bs-example bs-example-form" role="form"
			action="user/load.do" method="post">
			<div class="input-group">
				<input name="username" type="text" class="form-control" placeholder="用户名">
			</div>
			<br>

			<div class="input-group">
				<input name="password"  type="password" class="form-control"
					placeholder="密码">
			</div>
			<br> 
			<input id="sub" type="button" value="登录" class="btn btn-default">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<Button type="button" class="btn btn-default"
				onclick="javascript:window.location.href='register.jsp'">注册</Button>

		</form>
	</div>
	</div>
	</center>
</body>
</html>