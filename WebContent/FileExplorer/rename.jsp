<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="conf.jsp"%>
<%
//文件管理系统 V1.1
//2018-04-19
//simple
	String parent = new String(request.getParameter("parent").getBytes("utf-8"),"UTF-8");
	
	String action = request.getParameter("action");
	String top = "";
	File[] curFiles = null;
	String curName = "";
	if(!Tool.isEmp(parent))
	{
		String[] tmp = parent.split("/");
		curName = tmp[1];
		if(tmp.length>1)
		{
			for(int i=0;i<tmp.length-1;i++)
				top += tmp[i]+"/";
			curName = tmp[tmp.length-1];
		}
		
		curFiles = FileUtil.getFileList(FileUtil.replWebToFilePath(top));
		//System.out.println(top);
	}
	if("update".equals(action))
	{
		String newName = new String(request.getParameter("newname").getBytes("utf-8"),"UTF-8");
		FileUtil.reName(FileUtil.replWebToFilePath(parent),FileUtil.replWebToFilePath(top)+"\\"+newName);
		out.println(Tool.makeSimpleMsg("操作成功！"));
		out.println("<script>window.opener.opener = null;window.opener.location.replace(window.opener.location.href);window.close();</script>");
	}
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
	<p align=center><b>文件重命名</b></p>
	<form action="" target=_self onsubmit="return check()">
	<input type=hidden value="update" name="action">
	<input type=hidden value="<%=parent%>" name="parent">
	<table width="98%" border="0" align="center" cellpadding="3" cellspacing="1" class="tableborder">
		<tr>
			<td width="30%" class="tablerow2">路径</td>
			<td class="tablerow2">
				<%=top%>
			</td>
		</tr>
		<tr>
			<td width="30%" class="tablerow1">原文件：</td>
			<td class="tablerow1">
				<%=curName%>
			</td>
		</tr>
		<tr>
			<td width="30%" class="tablerow2">新名称：</td>
			<td class="tablerow2">
				<input type=text value="" name="newname" size="30"/>
			</td>
		</tr>
	</table>
	<p align=center>
	<input type=submit class="button" onclick="check()" value=" 确 定 " />&nbsp;&nbsp;
	<input type=button class="button" onclick="window.close()" value=" 取 消 "/></p>
	</form>
		<script type="text/javascript">
	function check()
	{
		var newName = document.getElementById("newname");
		//System.out.println(newName);
		if(newName.value=="")
		{
			alert("名称还没写呢！");
			newName.focus();
			return false;
		}
		
		var fileArr = new Array(<%=curFiles.length%>);
		<%
		for(int i = 0; i < curFiles.length; i++)
		{
		%>
		fileArr[<%=i%>] = "<%=curFiles[i].getName().toLowerCase()%>";
		alert(fileArr[<%=i%>]);
		<%
		}
		%>
		for(var i = 0; i < fileArr.length; i++)
		{
			if(fileArr[i] == newName.value.toLowerCase())
			{
				alert("当前文件夹中已有："+newName.value+"，请换个其它名称！");
				return false;
			}
		}
		return true;
	}
	</script>
</body>
</html>