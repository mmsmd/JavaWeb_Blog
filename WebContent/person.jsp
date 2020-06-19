<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息修改</title>
<link rel="stylesheet" type="text/css" href="css/reception.css" />
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
	<h1 align="center">个人信息修改</h1>

	<div align="center">
		<s:a href="modifyPassword.jsp">修改密码</s:a><br><br>
		<s:a href="student_personQuery">修改个人信息</s:a>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>