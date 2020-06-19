<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新闻信息</title>

<link rel="stylesheet" type="text/css" href="css/reception.css"/>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
	<h1 align="center">新闻信息</h1>
	<hr width="1024">
	<div align="center">
	
	<s:set var="newsid"><s:property value="#parameters['news_id']"/></s:set>
	
	<table style="border-collapse:collapse;width:800px;height:50px;border:1px solid blue">
	<s:iterator value="#session.news_list" id="st">
		<s:if test="#st.newsID==#newsid">
			<tr class="td_list">
				<td>新闻标题:</td><td align="left" style="width:650px;">
				<s:property value="#st.title"/></td></tr>
			<tr class="td_list">
				<td>新闻内容:</td><td align="left" style="width:650px;">
				<s:property escape="false" value="#st.content"/></td></tr>
			<tr class="td_list">
				<td>新闻发布时间:</td><td align="left" style="width:650px;">
				<s:property value="#st.submitTime"/></td>
			</tr>
			</s:if>
	</s:iterator>
	</table>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>