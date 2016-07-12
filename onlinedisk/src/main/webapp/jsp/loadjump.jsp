<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.linkyuji.pojo.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页面跳转</title>
</head>
<body>
	<%
		Users a = (Users) session.getAttribute("user");
		if (a == null)
			return;
		if (a.getUsertype() == 1) {
	%>
		<meta http-equiv="refresh" content="0;url=<%=request.getContextPath()%>/jsp/admin/indexuser.jsp">
	<%
		} else {
			%>
	<meta http-equiv="refresh" content="0;url=<%=request.getContextPath()%>/jsp/user/indexuser.jsp">
	<%
		}
	%>
</body>
</html>