<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@page import="com.maoshuo.entity.Student,java.util.ArrayList,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知后台管理</title>
</head>
<style>
.table_list{
border:2px solid blue;
border-collapse: collapse;
width:1024px;
}
.td_list{
border: 1px solid black;
height: 30px;
}
</style>
<body>
<jsp:include page="top.jsp"></jsp:include>
<h2 align="center">通知后台管理</h2>
<div align="center">
      <button class="button" onclick="window.location.href='notice_add.jsp'">增加通知</button>
<hr>
<table border="1" class="table_list">
<tr class="td_list">
<th>序号</th><th width="50px">通知ID</th>
<th width="200px">通知标题</th><th>内容</th>
<th>上传时间</th><th>编辑</th>

<s:set var="i" value="0"/>
<s:iterator value="#session.notice_list" id="st">
<tr class="td_list">       
                <td align="center"><s:property value="#i+1" /></td>
				<td align="center"><s:property value="#st.noticeID" /></td>
				<td align="center"><s:property value="#st.title" /></td>
				<td align="center"><s:property value="#st.content" /></td>
				<td align="center"><s:property value="#st.submitTime" /></td>		
				<td><form action="notice_personQuery" method="post">
                       <input type="hidden" name="noticeID" value="<s:property value='#st.noticeID'/>"/>
                        <input type="submit" value="编辑"/>
                     </form>	
				
				</td>
</tr>				
			<s:set var="i" value="#i+1"/>
</s:iterator>
</table>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>