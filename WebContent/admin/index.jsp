<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理首页</title>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<h1 align="center">管理首页</h1>

<div align="center">
	<table width="300" border="0" align="center" cellpadding="0" cellspacing="0">

		<tr>
			<td width="226" class="导航">
			<form action="admin_query" method="post">
             <input type="submit" value="学生管理" />
            </form></td>
		</tr>
		
		<tr>
			<td width="226" class="导航">
			<form action="news_query" method="post">
             <input type="submit" value="新闻管理" />
            </form></td>
		</tr>
		
		<tr>
			<td width="226" class="导航">
			<form action="notice_query" method="post">
             <input type="submit" value="通知管理" />
            </form></td>
		</tr>
		
	</table>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>