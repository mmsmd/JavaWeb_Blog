<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:bean id="pageBean" name="com.maoshuo.bean.PageBean"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更多通知</title>
<link rel="stylesheet" type="text/css" href="css/reception.css"/>
<style>
.table_list{
	border:0px;
	border-collapse:collapse;
	width:300px;
}
.td_list{
	border:0px solid black;
	height:30px;}
</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div align="center">
	<h1 align="center">	更多通知</h1>
	
		
			<table style="width:800px;" class="table_list">
				<tr class="td_list">
					<th>序号</th>
					<th align="left">通知标题</th>
					<th align="left">上传时间</th>
					
					<s:set var="i" value="0"/>
					<s:iterator value="#request.pageBean.list" id="st">
						<tr class="td_list">
							<td align="center" style="width:50px;"><s:property value="#i+1"/></td>
							<td align="left" style="width:200px;"><a href="notice_show.jsp?notice_id=<s:property value="#st.noticeID"/>"><s:property value="#st.title"/></a></td>
							<td align="left" style="width:200px;"><s:property value="#st.submitTime"/></td>
						</tr>
						<s:set var="i" value="#i+1"/>
					</s:iterator>
					<tr height="30"><td colspan="3"></td></tr>
					<tr align="center"><td colspan="3"><a href="noticeMore.action?Flag=sub">上一页</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="noticeMore.action?flag=add">下一页</a></td></tr>
			</table>
			当前是第<s:property value="#request.pageBean.page"/>页（共<s:property value="#request.pageBean.totalPage"/>页，共
			<s:property value="#request.pageBean.totalCount"/>条)
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>