<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>通知信息修改</title>
<link rel="stylesheet" type="text/css" href="css/reception.css" />
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
	<h1 align="center">通知信息修改</h1>
	<div align="center">
   <form action="notice_personQuery" method="post">
       <input type="hidden" name="noticeID" value="<s:property value="#session.noticeID"/>"/>
       <input type="submit" value="通知信息查询"/>
   </form>
   </div>
	<hr width="600">
	<div align="center" style="color:red;"><s:property value="msg" /></div>
	<div align="center">
		<form action="notice_updatePerson" method="post">
<table style="border-collapse:collapse;width:300px;height:300px;border:1px solid blue;">
<tr><td><h2>通知标题：</h2></td></tr><tr><td><input type="text" name="title"/></td></tr>
<tr><td><h2>通知内容:</h2></td></tr><tr><td><textarea class="ckeditor" id="editor1" cols="80" name="content" rows="8"></textarea></td></tr>
<tr><td align="center"colspan="2"><input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="重置"/></td></tr>
</table>
</form>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>