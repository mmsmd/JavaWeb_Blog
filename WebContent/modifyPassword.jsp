<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>密码修改</title>
<link rel="stylesheet" type="text/css" href="css/reception.css" />
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
	<h1 align="center">密码修改</h1>
       
	<div align="center">
		<s:form action="student_modifyPassword" method="post">
		<s:textfield label="请输入新的密码"   name="password"/>
		<s:textfield label="请再次输入新的密码"    name="confirmPassword" />
		<s:submit  value="提交"/>
		</s:form>
		
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>