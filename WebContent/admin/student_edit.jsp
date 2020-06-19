<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@page import="com.maoshuo.entity.Student,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑学生信息</title>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<%String xuehao=request.getParameter("xuehao"); %>
	<h1 align="center">学生信息编辑与删除</h1>	
	<div align="center">
	<table>
   <tr>
   <td>
   <form action="admin_studentDelete" method="post">
       <input type="hidden" name="xuehao" value="<%=xuehao %>"/>
       <input type="submit" value="删除该学生"/>
   </form>
   </tr>
   </table>
  
   </div>
	<hr width="600">
	<div align="center" style="color:red;"><s:property value="msg" /></div>
	<div align="center">
	
	<form action="admin_updateStudent" method="post">
<table style="border-collapse:collapse;width:300px;height:300px;border:1px solid blue;">
<tr><td>学生ID:</td><td><input type="text" readonly="readonly" name="student.studentID" value="${session.student_info[6]}"/></td></tr><tr>
<tr><td>学号:</td><td><input type="text" name="student.xuehao" value="${session.student_info[0]}"/></td></tr><tr>
<td>姓名:</td><td><input type="text" name="student.studentName" value="${session.student_info[1]}"/></td></tr><tr>
<td>密码:</td><td><input type="text" name="student.password" value="${session.student_info[2]}"/></td></tr><tr>
<td>性别:</td><td><input type="text" name="student.sex" value="${session.student_info[3]}"/></td></tr><tr>
<td>班级:</td><td><input type="text" name="student.banji" value="${session.student_info[4]}"/></td></tr><tr>
<td>生日:</td><td><input type="text" name="student.birthday" value="${session.student_info[5]}"/></td></tr><tr>
<td align="center"colspan="2"><input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="重置"/></td></tr>
</table>
</form>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>