<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="basics_systemJQuery.js"></script>
<script type="text/javascript">
function SetHome(obj,vrl){ 
try{ 
obj.style.behavior='url(#default#homepage)';obj.setHomePage(vrl); 
} 
catch(e){ 
if(window.netscape) { 
try { 
netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect"); 
} 
catch (e) { 
alert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将 [signed.applets.codebase_principal_support]的值设置为'true',双击即可。"); 
} 
var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch); 
prefs.setCharPref('browser.startup.homepage',vrl); 
}else{ 
alert("您的浏览器不支持，请按照下面步骤操作：1.打开浏览器设置。2.点击设置网页。3.输入："+vrl+"点击确定。"); 
} 
} 
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>毛朔的网站</title>
<link rel="stylesheet" type="text/css" href="css/reception.css" />
</head>
<body>

<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="2" align="center"><img src="images/maoshuo.jpg" width="192" height="131" alt="毛朔" /></td>
    <td colspan="2" align="center" class="biaoti">毛朔的网站</td>
    <td colspan="2" align="center" class="biaoti"><p class="签名">内外相应，</p>
    <p class="签名">言行相称</p></td>
  </tr>
  <tr>
    <td colspan="6">&nbsp;</td>
  </tr>
  <tr>
    <td width="100" class="导航"><a href="index.jsp">首页</a></td>
    
               <s:if test="#session.userName!=''&&#session.userName!=null">	
               <td width="300" class="导航">	
		        <s:property value="#session.userName" />，欢迎你！ <a href="person.jsp">设置</a>
		        <a href="exit.jsp">退出</a>
		       </s:if>
		       <s:else>
		       <td width="150" class="导航">
		             <a href="login.jsp">登录</a></td>
		       <td width="150" class="导航"><a href="register.jsp">注册</a>  </td>        
		       </s:else>
    
    <td width="226" class="导航"><a href="newsMore.action">更多新闻</a></td>
    <td width="169" class="导航"><a href="noticeMore.action">更多通知</a></td>
    <td width="169" class="导航"><a href="javascript:void(0)" οnclick="SetHome(this,window.location)">设为首页</a></td>
    <td width="168" class="导航"><a href="admin/login.jsp">后台管理</a></td>
  </tr>
  </table>
 <hr width="1024" />
</body>
</html>