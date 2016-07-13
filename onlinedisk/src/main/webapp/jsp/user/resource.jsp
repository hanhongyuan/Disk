<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.linkyuji.pojo.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>不止于网盘</title>
<link
	href="<%=request.getContextPath()%>/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">

</head>
<script src="<%=request.getContextPath()%>/jquery/jquery-1.8.0.min.js"></script>



<body>
	<%
		Users a = (Users) session.getAttribute("user");
		if (a == null || a.getUsertype() != 2) {
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
			<a class="navbar-brand" href="#">不止于网盘</a>
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
						href="<%=request.getContextPath()%>/jsp/user/indexuser.jsp">主页
							<span class="sr-only">(current)</span>
					</a></li>
					<li><a href="loadResource.do?parent=0">我的资源</a></li>
					<li><a href="blog/loadblog.do">我的博客</a></li>
				</ul>

			</div>
			<div id="managerurl"
				class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="sub-header">我的资源</h2>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a onclick="openNew()">新建文件夹</a></li>
						<li><a href="#">上传文件
								<form id="uploadfile" action="upload.do"
									enctype="multipart/form-data" method="post">
									<input title="点击选择文件" id="upfile" multiple="multiple"
										accept="*/*" type="file" name="upload" onchange="changefile()"
										style="position: absolute; opacity: 0; top: 0; left: 0; width: 100%; height: 100%; cursor: pointer;"></input>
								</form>
						</a></li>
					</ul>
				</div>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th style="width: 80%">文件名</th>
								<th style="widows: 20%">操作</th>
							</tr>
						</thead>
						<tbody>
							<%
								int up = Integer.parseInt(session.getAttribute("upper").toString());
								if (up != -1) {
									
							%>
									<tr><td><a href="loadResource.do?parent=${upper}">上一级</a></td><td></td></tr>
							<%
								}
							%>
							<tr id="newfolder" style="display: none;">
								<form action="addFolder.do" method="post">
									<td><input id="newf" name="thenewfolder" type="text"
										class="form-control" value="新建文件夹"></input></td>
									<td><input type="submit" value="提交"></input> <input
										type="button" value="取消" onclick="closeNew()"></input></td>
								</form>
							</tr>
							<c:forEach items="${folderlist}" var="folderinfo">
								<tr>
									<td><a
										href="loadResource.do?parent=${folderinfo.idfolder}"><img
											src="<%=request.getContextPath()%>/images/folder.gif"></img>${folderinfo.foldername}</a></td>
									<td><a
										href="deleteFolder.do?folderid=${folderinfo.idfolder}">删除</a></td>
									<!-- 自定义标签 -->
								</tr>
							</c:forEach>

							<c:forEach items="${filelist}" var="fileinfo">
								<tr>
									<td>${fileinfo.filename}</td>
									<td><a href="download.do?fileid=${fileinfo.idfile}">下载</a>&nbsp&nbsp&nbsp

										<a href="deletefile.do?fileid=${fileinfo.idfile}">删除</a></td>
									<!-- 自定义标签 -->
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script>
		function closeNew() {
			document.getElementById("newfolder").style.display = "none";
			document.getElementById("newf").value = "新建文件夹";
		}

		function openNew() {
			document.getElementById("newfolder").style.display = "inline";
		}

		function changefile() {
			var a = document.getElementById("upfile").value;
			var as = document.getElementById("uploadfile");
			as.submit();

		}
	</script>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<%=request.getContextPath()%>/jquery/jquery-1.8.0.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	<script src="http://cdn.bootcss.com/jquery/1.9.1/jquery.min.js"></script>
	<script src="https://mindmup.s3.amazonaws.com/lib/jquery.hotkeys.js"></script>
	<script
		src="http://cdn.bootcss.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/bootstrap-3.3.5-dist/js/bootstrap-wysiwyg.js"></script>
</body>
</html>