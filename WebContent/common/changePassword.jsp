<%@ page language="java" pageEncoding="utf-8" import="utils.SHA1Utils, utils.StringUtils,
javax.servlet.http.HttpSession"%>
<%@include file="taglib.jsp"%>
<c:if test="${empty sessionScope.currentYH}">
	<script>
	 	localStorage.setItem('status',JSON.stringify({isChange:'-2'}));	
		alert("登陆已失效，请重新登陆！");
		window.close();
	</script>
</c:if>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>年终收入分配管理系统 　V1.0</title>
</head>
<script src="${basePath}/static/js/jQuery.js"></script>
<body>
<p align=center><b>修改密码</b></p>
<form action="" method="post" target=_self onsubmit="return check()">
<table width="98%" class="tableborder">	
		<tr align="center">
			<td class="tablerow1">原密码：</td>
			<td class="tablerow1" >
				<input type=password value="" name="oldPassword" id="inputOldPass" 
				onfocus="inputOldPassOnfocus()" onblur="inputOldPassOnblur()" size="30"/>
			</td>
		</tr>
		<tr align="center">
			<td class="tablerow1">新密码：</td>
			<td class="tablerow1" >
				<input type=password value="" name="newPassword" id="inputNewPass" 
				onfocus="inputNewPassOnfocus()" onblur="inputNewPassOnblur()" size="30"/>
			</td>
		</tr>
		<tr align="center">
			<td class="tablerow1">确认密码：</td>
			<td class="tablerow1" width="75%">
				<input type=password value="" name="confirmPassword" id="inputConfPass" 
				onfocus="inputConfPassOnfocus()" onblur="inputConfPassOnblur()" size="30"/>
			</td>
		</tr>
		
	</table>
	<div id="h"><p id="hint" align=center></p></div>
	<p align=center>
		<input type=submit class="button" value=" 确 定 "/>&nbsp;&nbsp;
		<input type=button class="button" onclick="window.close()" value=" 取 消 "/>
	</p>	
	</form>
	
	<script src="${basePath}/static/js/changePassword.js?2018081701"></script>
</body>
</html>