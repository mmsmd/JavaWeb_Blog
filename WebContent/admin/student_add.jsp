<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>增加学生</title>

<style type="text/css">
h1{color:blue; }
.from_selement{
font-size:18px;
}
  {
  height:20px;
  vertical-align:bottom;
  }
</style>

</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<h1 align="center">增加学生信息</h1>
<s:div align="center"  style="color:red">
<s:property value="msg" />
</s:div>
<div align="center" class="from_selement">
 <form  action="admin_studentAdd" method="post"  >
 <table style="border-collapse:collapse;width:300px;height:300px;border:1px solid blue;">

<tr><td>学号:</td><td><input type="text" name="student.xuehao" /></td></tr><tr>
<td>姓名:</td><td><input type="text" name="student.studentName" /></td></tr><tr>
<td>密码:</td><td><input type="text" name="student.password" /></td></tr><tr>
<td>性别:</td><td><input type="text" name="student.sex" /></td></tr><tr>
<td>班级:</td><td><input type="text" name="student.banji" /></td></tr><tr>
<td>生日:</td><td><input type="text" name="student.birthday"/></td></tr><tr>
<td align="center"colspan="2"><input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="重置"/></td></tr>
</table>
 	
 </form>
 </div>
 <jsp:include page="bottom.jsp"></jsp:include>
</body>