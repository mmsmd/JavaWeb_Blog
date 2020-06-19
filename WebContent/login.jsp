<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<html>
<head>
	<title>用户登录</title>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>

<h1 align="center">用户登录</h1>
<s:div align="center"  style="color:red">
<s:property value="msg" />
</s:div>
<div align="center" class="from_selement">
 <s:form name="myForm" action="student_login" method="post" >
 
	<s:textfield label="学号"  name="xuehao"/>
	<s:password label="密码"  name="password"/> 		
 	<tr align="center"><td> </td><td><s:submit theme="simple" value="登录"/>
 	<s:reset theme="simple" value="重置"/></td></tr>
 	
 </s:form>
 
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>
