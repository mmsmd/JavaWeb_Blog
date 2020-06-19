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
   <form action="admin_personQuery" method="post">
       <input type="hidden" name="adminNumber" value="<s:property value="#session.adminNumber"/>"/>
       <input type="submit" value="管理员信息查询"/>
   </form>
   </div>
	<hr width="600">
	<div align="center" style="color:red;"><s:property value="msg" /></div>
	<div align="center">
		<form action="admin_updatePerson" method="post">
<table style="border-collapse:collapse;width:300px;height:300px;border:1px solid blue;">
<tr><td>管理员ID:</td><td><input type="text" readonly="readonly" name="adminID" value="${session.admin_info[3]}"/></td></tr><tr>
<tr><td>账号:</td><td><input type="text" name="adminNumber" value="${session.admin_info[0]}"/></td></tr><tr>
<td>姓名:</td><td><input type="text" name="adminName" value="${session.admin_info[1]}"/></td></tr><tr>
<td>密码:</td><td><input type="text" name="adminPassword" value="${session.admin_info[2]}"/></td></tr><tr>

<td align="center"colspan="2"><input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="重置"/></td></tr>
</table>
</form>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>