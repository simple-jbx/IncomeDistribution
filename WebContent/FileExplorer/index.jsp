<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="conf.jsp"%>
<%
	//文件管理系统 V1.1
	//2018-4-19
	//simple.jbx@snnu.edu.cn
	//File files = new File(".");
	//File[] roots = files.listFiles();
	File[] roots = File.listRoots();
	String parent = request.getParameter("parent");
	//System.out.println(parent);
	request.setCharacterEncoding("utf-8");
	if(Tool.isEmp(parent))
		parent= "";
	//else
		//默认服务器使用utf-8解码，因此当服务器使用非utf-8解码时需修改
		//parent = new String(request.getParameter("parent").getBytes("utf-8"),"UTF-8");
	//System.out.println(parent);
	String action = request.getParameter("action");
	if("delete".equals(action))
	{
		String t = request.getParameter("t");
		String file = new String(request.getParameter("file").getBytes("utf-8"),"UTF-8");
		if("1".equals(t))
			FileUtil.deleteFile(file);
		else
			FileUtil.delFolder(file);
		Thread.sleep(200l);
	}
	String top = "";
	File[] curFiles = null;
	if(!Tool.isEmp(parent))
	{
		if(!parent.startsWith("/"))
			curFiles = FileUtil.getFileList(FileUtil.replWebToFilePath(parent));
		//System.out.println(FileUtil.replWebToFilePath(parent) + " " + parent);
		else 
			curFiles = FileUtil.getFileList(parent);
		String[] tmp = parent.split("/");
		if(tmp.length>1)
		{
			for(int i=0;i<tmp.length-1;i++)
				top += tmp[i]+"/";
		}
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
	<script type="text/javascript">
	function showFolderSize(folder)
	{
		window.showModalDialog("<%=webRoot%>folderSize.jsp?parent="+folder,window,"dialogWidth:25;dialogHeight:12;status:no;help:no");
	}
	function showReName(folder)
	{
		window.open("<%=webRoot%>rename.jsp?parent="+folder,"","width=400px,height=180,top=200,left=300,status=no,help=no");
	}
	function showCreateFolder(folder)
	{
		window.open("<%=webRoot%>newfolder.jsp?parent="+folder,"","width=400px,height=160,top=200,left=300,status=no,help=no");
	}
	function showUpload(folder)
	{
		window.open("<%=webRoot%>upload.jsp?parent="+folder,"","width=400px,height=160,top=200,left=300,status=no,help=no");
	}
	function showEdit(file)
	{
		location.href = "<%=webRoot%>/edit.jsp?file="+file;
	}
	</script>
	</head>
	<body class="htmlbody">
	<br/>
	<p align=center><font size="3"><b>文件管理系统　File Explorer V1.1</b></font></p>
	<table class="table1" cellspacing="1" cellpadding="3" align="center" border="0">
		<tr>
			<td class="tableline linetitle" width="200" align="left" nowrap="nowrap">
			<form action="" target=_self>
				更改盘符:<select name="parent">
				<%
				for(int i=0;i<roots.length;i++)
				{
				%>
					<option value="<%=FileUtil.replFileToWebPath(roots[i].getPath())%>"><%=roots[i].getPath()%></option>
				<%
				}
				%>
				</select>
				&nbsp;<input type="submit" class="button" value=" 进 入 "/>
			</form>
			</td>
			<td class="tableline" width="*" align="right">
				当前路径：<font size=2 color=blue><%=FileUtil.replWebToFilePath(parent)%></font>&nbsp;&nbsp;
				<input type=button value=" 向 上 " class="button" <%=Tool.isEmp(top)?"disabled":""%> onclick="location.href='<%=pageRoot%>?parent=<%=top%>'"/>
				&nbsp;&nbsp;［<input type=button value="新文件夹" class="button" <%=Tool.isEmp(parent)?"disabled":""%> onclick="showCreateFolder('<%=parent%>')"/>&nbsp;
				<input type=button value="上传文件" class="button" <%=Tool.isEmp(parent)?"disabled":""%> onclick="showUpload('<%=parent%>')"/>］
			</td>
		</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="3" cellspacing="1" class="tableborder">
	<tr>
		<th width="25%">文件名称</th>
		<th width="8%" nowrap="nowrap">类型</th>
		<th width="8%" nowrap="nowrap">属性</th>
		<th width="8%" nowrap="nowrap">大小</th>
		<th width="14%" nowrap="nowrap">修改日期</th>
		<th width="28%" nowrap="nowrap">操作</th>
	</tr>
	<%
	if(curFiles!=null&&curFiles.length>0)
	{
		int folderNum = 0;
		int fileNum = 0;
		long fileSize = 0;
		String lineBg = "";
		String ext = "";
		for(int i=0;i<curFiles.length;i++)
		{
			boolean canEdit = false;
			if(curFiles[i].isDirectory())
				folderNum ++;
			else
			{
				fileNum ++;
				fileSize += curFiles[i].length();
			}
			ext = FileUtil.getFileExt(curFiles[i].getName());
			if(".txt".equalsIgnoreCase(ext)||".html".equalsIgnoreCase(ext)||".htm".equalsIgnoreCase(ext)||".css".equalsIgnoreCase(ext)||".jsp".equalsIgnoreCase(ext)||".js".equalsIgnoreCase(ext))
		    	canEdit = true;
		    if(i%2==0)
		    	lineBg = "tablerow2";
		    else
		    	lineBg = "tablerow1";
	%>
	<tr align="center">
		<td class="<%=lineBg%>" align="left">&nbsp;
		<%
		if(curFiles[i].isDirectory())
		{
			//System.out.println(webRoot);
		%>
			<a href="<%=pageRoot%>?parent=<%=parent+curFiles[i].getName()+(curFiles[i].isDirectory()?"/":"")%>">
				<%=curFiles[i].getName()%>
			</a>
		<%
		}
		else
		{
		%>
			<a href="<%=webRoot%>down.jsp?file=<%=parent+curFiles[i].getName()%>">
				<%=curFiles[i].getName()%>
			</a>
		<%
		}
		%>
		</td>
		<td class="<%=lineBg%>" nowrap="nowrap"><%=curFiles[i].isDirectory()?"<font color=orange>文件夹</font>":ext+" 文件"%></td>
		<td class="<%=lineBg%>" nowrap="nowrap">
		<%
			out.println("<input type=checkbox "+(!curFiles[i].canWrite()?"checked":"")+" disabled>[只读]</checkbox>");
			out.println("<input type=checkbox "+(curFiles[i].isHidden()?"checked":"")+" disabled>[隐藏]</checkbox>");
		%>
		</td>
		<td class="<%=lineBg%>" nowrap="nowrap"><%=!curFiles[i].isDirectory()?FileUtil.formatSize(curFiles[i].length()):"未知"%></td>
		<td class="<%=lineBg%>" nowrap="nowrap"><%=Tool.parseDateFromLong(curFiles[i].lastModified())%></td>
		<td class="<%=lineBg%>" nowrap="nowrap">
			<input type=button value="重命名" class="button" onclick="showReName('<%=parent+curFiles[i].getName()%>')"/>&nbsp;
			<input type=button value="编辑文件" class="button" <%=canEdit?"":"disabled" %> onclick="showEdit('<%=parent+curFiles[i].getName()%>')"/>&nbsp;
			<input type=button value="文件夹大小" class="button" <%=!curFiles[i].isDirectory()?"disabled":""%> onclick="showFolderSize('<%=parent+curFiles[i].getName()+(curFiles[i].isDirectory()?"/":"")%>')"/>&nbsp;
		    <input type="button"  value="删 除" class="button" onclick="if(confirm('真的要删除此文件吗？'))location.href='<%=pageRoot%>?parent=<%=parent%>&action=delete&file=<%=parent+curFiles[i].getName()+(curFiles[i].isDirectory()?"&t=0":"&t=1") %>'"/>
		</td>
	</tr>
	<%
		}
	%>
	<tr align="center">
		<td colspan="6" align=right><b>共有文件夹：<font color=red><%=folderNum%></font> 个，文件：<font color=red><%=fileNum %></font> 个，大小：<font color=red><%=FileUtil.formatSize(fileSize)%></font></b></td>
	</tr>
	<%
	}
	else
	{
	%>
	<tr align="center">
		<td colspan="6" height=35><font color=red>没有任何文件或文件夹!</font></td>
	</tr>
	<%
	}
	%>
</table>
</body>
</html>