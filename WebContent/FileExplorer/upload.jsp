<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="cn.gh.util.*,java.io.*"%>
<%
//文件管理系统 V1.1
//2018-04-19
//simple
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
	String parent = new String(request.getParameter("parent").getBytes("utf-8"),"UTF-8");
	session.setAttribute("parent",parent);
	%>
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>文件管理系统　V1.1</title>
	<meta http-equiv="Expires" content="0"/>
	<meta http-equiv="Cache-Control" content="no-cache"/>
	<meta http-equiv="Pragma" content="no-cache"/>
	<link href="skin_1/style.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript">
	function check()
	{
		var newName = document.getElementById("nfile");
		if(newName.value=="")
		{
			alert("还没选要上传的文件！");
			newName.focus();
			return false;
		}
		return true;
	}
	</script>
	</head>
	<body class="htmlbody">
	<p align=center><b>上传文件</b></p>
	<form action="doupload.jsp" onsubmit="return check()" METHOD="POST" ENCTYPE="multipart/form-data">
	<input type=hidden value="<%=parent%>" name="parent">
	<table width="98%" border="0" align="center" cellpadding="3" cellspacing="1" class="tableborder">
		<tr>
			<td width="30%" class="tablerow2">路径</td>
			<td class="tablerow2">
				<%=FileUtil.replWebToFilePath(parent)%>
			</td>
		</tr>
		<tr>
			<td width="30%" class="tablerow1">文件</td>
			<td class="tablerow1">
				<input type=file name="nfile" size="30"/>
			</td>
		</tr>
	</table>
	<p align=center>
	注：文件大小在 <font color=red><b>1000M</b></font> 以内
	<input type=submit class="button" value=" 确 定 "/>&nbsp;&nbsp;
	<input type=button class="button" onclick="window.close()" value=" 取 消 "/></p>
	</form>
</body>
</html>