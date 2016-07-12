<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
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
<script src="js/user.js"></script>
<body>
	
	<center>
	<div style="width: 1700">
		<h1>用户注册</h1>
	<br><br><br><br><br>
	<div style="width:180px;;" >
		<form class="bs-example bs-example-form" role="form"
			action="user/regiset.do" method="post">
			<div class="input-group">
				<center><input id="username" name="username" type="text" class="form-control" placeholder="用户名"></center>
				<label id="reg" style="color: green;"></label>
			</div>
			<br>

			<div class="input-group">
				<input name="password"  type="password" class="form-control"
					placeholder="密码">
			</div>
			<br>
			<div class="input-group">
				<input name="passwordagain"  type="password" class="form-control"
					placeholder="确认密码">
					<label id="psw" style="color: red;"></label>
			</div>
			<br>  
			<input id="submit" type="submit" value="提交" class="btn btn-default">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


		</form>
	</div>
	</div>
	</center>
</body>


</html>