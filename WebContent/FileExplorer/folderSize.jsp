<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="conf.jsp"%>
<%
request.setCharacterEncoding("utf-8");
String parent = new String(request.getParameter("parent").getBytes("utf-8"),"utf-8");
long size = FileUtil.getSize(FileUtil.replWebToFilePath(parent));
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>文件管理系统　V1.1</title>
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/>
<link href="skin_1/style.css" type="text/css" rel="stylesheet"/>
</head>
<body class="htmlbody">
<p align=center><b>查看文件夹大小</b></p>
<table width="98%" border="0" align="center" cellpadding="3" cellspacing="1" class="tableborder">
	<tr>
		<td width="30%" class="tablerow1">当前文件夹：</td>
		<td class="tablerow1"><%=FileUtil.replWebToFilePath(parent)%></td>
	</tr>
	<tr>
		<td width="30%" class="tablerow2">大小：</td>
		<td class="tablerow2"><%=FileUtil.formatSize(size)%></td>
	</tr>
</table>
<p align=center><input type=button class="button" onclick="window.close()" value=" 关 闭 "/></p>
</body>
</html>