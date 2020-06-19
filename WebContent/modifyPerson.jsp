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
	
	<hr width="600">
	<div align="center" style="color:red;"><s:property value="msg" /></div>
	<div align="center">
		<form action="student_updatePerson" method="post">
<table style="border-collapse:collapse;width:300px;height:300px;border:1px solid blue;">
<tr><td>学生ID:</td><td><input type="text" readonly="readonly" name="studentID" value="${session.student_info[6]}"/></td></tr><tr>
<tr><td>学号:</td><td><input type="text" name="xuehao" value="${session.student_info[0]}"/></td></tr><tr>
<td>姓名:</td><td><input type="text" name="studentName" value="${session.student_info[1]}"/></td></tr><tr>
<td>密码:</td><td><input type="text" name="password" value="${session.student_info[2]}"/></td></tr><tr>
<td>性别:</td><td><input type="text" name="sex" value="${session.student_info[3]}"/></td></tr><tr>
<td>班级:</td><td><input type="text" name="banji" value="${session.student_info[4]}"/></td></tr><tr>
<td>生日:</td><td><input type="text" name="birthday" value="${session.student_info[5]}"/></td></tr><tr>
<td align="center"colspan="2"><input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="重置"/></td></tr>
</table>
</form>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>