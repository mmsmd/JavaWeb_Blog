<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@page import="com.maoshuo.entity.Student,java.util.ArrayList,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生后台管理</title>
</head>
<style>
.table_list{
border:2px solid blue;
border-collapse: collapse;
width:600px;
}
.td_list{
border: 1px solid black;
height: 30px;
}
</style>
<body>
<jsp:include page="top.jsp"></jsp:include>
<h2 align="center">学生后台管理</h2>
<div align="center">
      <button class="button" onclick="window.location.href='student_add.jsp'">增加学生</button>
<hr>
<table border="1" width="500px" class="table_list">
<tr class="td_list">
<th>序号</th><th>学号</th><th>姓名</th>
<th>密码</th><th>性别</th>
<th>班级</th><th>生日</th><th>编辑</th>

<s:set var="i" value="0"/>
<s:iterator value="#session.student_list" id="st">
<tr class="td_list">       
                <td align="center"><s:property value="#i+1" /></td>
				<td align="center"><s:property value="#st.xuehao" /></td>
				<td align="center"><s:property value="#st.studentName" /></td>
				<td align="center"><s:property value="#st.password" /></td>
				<td align="center"><s:property value="#st.sex" /></td>
				<td align="center"><s:property value="#st.banji" /></td>
				<td align="center"><s:property value="#st.birthday" /></td>				
				<td><form action="admin_studentQuery" method="post">
                       <input type="hidden" name="xuehao" value="<s:property value='#st.xuehao'/>"/>
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