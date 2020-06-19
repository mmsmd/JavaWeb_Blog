<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<script language="javascript">	
function CheckForm()
{
 
  if (document.LoginForm.admin.value=="")
  {
    alert("管理员账号不能为空！");
	document.LoginForm.admin.focus();
	return false;
  }
  if (document.LoginForm.adminpwd.value=="")
  {
    alert("密码不能为空！");
	document.LoginForm.adminpwd.focus();
	return false;
  }  
  return true;  
}
</script>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div align="center"><h1>管理员登录</h1><br><br>

<br><br>
<form action="admin_login"  name="LoginForm" method="post" onSubmit="return CheckForm()">
<s:fielderror name="adminNumber"></s:fielderror>
  管理员账号： <input id="admin" name="adminNumber" type="text"></input><br><br>
  管理员密码：  <input id="adminpwd" name="adminPassword" type="password"></input><br> <br>
   <input  name="sumbit" type="submit" value="登录"></input>&nbsp;&nbsp;&nbsp;
   <input  name="reset" type="reset" value="重置"></input><br><br>
  
</form>

</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>