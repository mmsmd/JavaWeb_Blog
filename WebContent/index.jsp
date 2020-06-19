<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>毛朔的网站</title>
<link rel="stylesheet" type="text/css" href="css/reception.css" />
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
	<h1 align="center">网站首页</h1>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
 
  <tr>
    <td colspan="2" align="left" style="width: 291px; "><span class="标题2">图片新闻</span></td>
    <td colspan="2" style="width: 351px; "><span class="标题2"><a href="newsMore.action">更多新闻 </a></span>&gt;&gt;</td>
    <td colspan="2"><span class="标题2"><a href="noticeMore.action">更多通知</a></span>&gt;&gt;</td>
  </tr>
  <tr>
    <td colspan="2" align="left" style="width: 320px; "><span><img src="images/1.jpg" width="293" height="249" /></span></td>
    <td colspan="2" style="width: 370px; ">
    	<table style="width:370px;" class="table_list">
    		<tr class="td_list">
    			<th>序号</th>
    			<th align="left">新闻标题</th>
    			<th align="left">发布时间</th>
    		</tr>
    			<s:set var="i" value="0" />
    			<s:iterator value="#session.news_list" id="st">
    				<tr class="td_list">
    					<td align="center" style="width:50px;"><s:property value="#i+1"/></td>
    					<td align="left" style="width:200px;"><a href="news_show.jsp?news_id=<s:property value="#st.newsID"/>">
    					<s:property value="#st.title"/></a></td>
    					<td align="left" style="width:200px;"><s:property value="#st.submitTime"/></td>
    				</tr>
    				<s:set var="i" value="#i+1"/>
    			</s:iterator>
    	</table>
    </td>
    
    <td colspan="2" style="width: 350px; ">
		<table style="width:370px;" class="table_list">
    		<tr class="td_list">
    			<th>序号</th>
    			<th align="left">通知标题</th>
    			<th align="left">发布时间</th>
    		</tr>
    			<s:set var="i" value="0" />
    			<s:iterator value="#session.notice_list" id="st">
    				<tr class="td_list">
    					<td align="center" style="width:50px;"><s:property value="#i+1"/></td>
    					<td align="left" style="width:200px;"><a href="notice_show.jsp?notice_id=<s:property value="#st.noticeID"/>">
    					<s:property value="#st.title"/></a></td>
    					<td align="left" style="width:200px;"><s:property value="#st.submitTime"/></td>
    				</tr>
    				<s:set var="i" value="#i+1"/>
    			</s:iterator>
    	</table>
	</td>
  </tr>
  <tr>
    <td colspan="6"><img src="images/bottom.png" width="1013" height="102" /></td>
  </tr>
</table>
	
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>