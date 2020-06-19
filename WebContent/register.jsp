<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户注册</title>

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
<h1 align="center">用户注册</h1>
<s:div align="center"  style="color:red">
<s:property value="msg" />
</s:div>
<div align="center" class="from_selement">
 <s:form name="myForm" action="student_register" method="post"  >
 
	<s:textfield label="学号"  name="xuehao"/>
	<s:textfield label="姓名"  name="studentName"/>
	<s:password label="密码"  name="password"/>
	<s:radio label="性别"  list="#{'1':'男','0':'女'}" name="sex" value="1"/>	
	<s:textfield label="班级"  name="banji"/>
	<s:textfield label="生日"  name="birthday"/>	
	<tr align="center"><td> </td><td>	
 	</td></tr>
 	
 	
 	<tr align="center"><td> </td><td><s:submit theme="simple" value="提交"/>
 	<s:reset theme="simple" value="重置"/></td></tr>
 	
 </s:form>
 </div>
 <jsp:include page="bottom.jsp"></jsp:include>
</body>