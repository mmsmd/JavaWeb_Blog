<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-contro;" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>增加新闻</title>

<script type="text/javascript" src="../js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../ckeditor/sample.js"></script>
<script type="text/javascript" src="../ckeditor/config.js"></script>
<script type="text/javascript">
var editor=CKEDITOR.replace('editor1',{
	filebrowserImageUploadUrl:"picture/editor/upload",
	removePlugins:'elementspath.resize',
	codeSnippet_theme:'zenburn',
	height:'600'
});
</script>

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
<h1 align="center">增加新闻</h1>
<s:div align="center"  style="color:red">
<s:property value="msg" />
</s:div>
<div align="center" class="from_selement">
 <form  action="news_add" method="post"  >
 <table style="border-collapse:collapse;width:1000px;height:300px;border:1px solid blue;">

<tr><td><h2>新闻标题：</h2></td></tr><tr><td><input type="text" name="title"/></td></tr>
<tr><td><h2>新闻内容:</h2></td></tr><tr><td><textarea class="ckeditor" id="editor1" cols="80" name="content" rows="8"></textarea></td></tr>
<tr><td align="center"colspan="2"><input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="重置"/></td></tr>
</table>
 	
 </form>
 </div>
 <jsp:include page="bottom.jsp"></jsp:include>
</body>