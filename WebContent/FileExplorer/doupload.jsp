<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="conf.jsp"%>
<%@ page import="com.jspsmart.upload.*" %>
<%
	request.setCharacterEncoding("utf-8");
	com.jspsmart.upload.SmartUpload mySmartUpload=new com.jspsmart.upload.SmartUpload();
	mySmartUpload.initialize(pageContext);
	mySmartUpload.setMaxFileSize(1000 * 1024*1024);//设置上传文件大小限制
	String parent = (String)session.getAttribute("parent");
	//System.out.print(parent);
	//初始化
	mySmartUpload.upload();
	//循环取得所有上载的文件    
	String fileName = "";
	long size = 0;
	for (int i=0;i<mySmartUpload.getFiles().getCount();i++)
	{
		//取得上载的文件
		com.jspsmart.upload.File file = mySmartUpload.getFiles().getFile(i);
		if (!file.isMissing())
		{
		   	//取得上载的文件的文件名
		    fileName=file.getFileName();
		    size = file.getSize();
		    //保存路径
		    //将文件保存在服务器端
		    file.saveAs(parent+fileName,SmartUpload.SAVE_PHYSICAL);
		    out.println("<script>alert('文件上载成功！！！');</script>");
	   }
	   else     
	   {
			out.println("<script>alert('文件上载失败！！！');</script>");
			return;
	   }
	}
	session.removeAttribute("parent");
	%>
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>文件管理系统</title>
	<meta http-equiv="Expires" content="0"/>
	<meta http-equiv="Cache-Control" content="no-cache"/>
	<meta http-equiv="Pragma" content="no-cache"/>
	<link href="skin_1/style.css" type="text/css" rel="stylesheet"/>
	</head>
	<body class="htmlbody">
	<p align=center><b>上传文件</b></p>
	<table width="98%" border="0" align="center" cellpadding="3" cellspacing="1" class="tableborder">
		<tr>
			<td width="30%" class="tablerow1">文件</td>
			<td class="tablerow1">
				<%=parent+fileName %>
			</td>
		</tr>
		<tr>
			<td width="30%" class="tablerow2">大小</td>
			<td class="tablerow2">
				<%=FileUtil.formatSize(size) %>
			</td>
		</tr>
	</table>
	<p align=center>
		<input type=button class="button" value=" 关 闭 " onclick="window.opener.opener = null;window.opener.location.reload();window.close();"/>
	</p>
</body>
</html>