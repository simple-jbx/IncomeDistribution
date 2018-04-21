<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="conf.jsp"%>
<%
//文件管理系统 V1.1
//2018-04-19
//simple
	request.setCharacterEncoding("utf-8");
	String action = request.getParameter("action");
	//党服务器解码为非utf-8时需修改
	String file = new String(request.getParameter("file").getBytes("utf-8"),"UTF-8");
	if("update".equals(action))
	{
		String code = new String(request.getParameter("code").getBytes("utf-8"),"UTF-8");
		FileUtil.deleteFile(file);
		FileUtil.createFile(file,code);
		out.println(Tool.makeSimpleMsg("文件保存成功！"));
	}
	String code = FileUtil.readFile2String(file);
	String top = "";
	if(!Tool.isEmp(file))
	{
		String[] tmp = file.split("/");
		if(tmp.length>1)
		{
			for(int i=0;i<tmp.length-1;i++)
				top += tmp[i]+"/";
		}
	}
	%>
	<html>
	<head>
	<title>文件管理系统　V1.1</title>
	<link href="skin_1/style.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
	<form action="" target=_self method="post">
		<input type=hidden value="<%=file%>" name="file"/>
		<input type=hidden value="update" name="action"/>
		<br/><p align=center><font size="3"><b>文件管理系统　V1.0</b></font></p>
		<table id="tablehovered1" border="0" align="center" cellpadding="3" cellspacing="1" class="tableborder">
			<tr>
				<th height="25" >
					文件编辑器
				</th>
			</tr>
			<tr>
				<td  width="15%" height="30" class="tablerow2">
					文件源代码
				</td>
			</tr>
			<tr>
				<td  width="15%" height="30" class="tablerow1" align=center>
					<textarea rows="30" cols="155" name="code"><%=code%></textarea>
				</td>
			</tr>
		</table>
		<p align=center><input type="submit" value=" 保 存 " class="button"/>&nbsp;&nbsp;
		<input type=button onclick="location.href='index.jsp?parent=<%=top%>'" value=" 返 回 " class="button"/></p>
	</form>
</body>
</html>