<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="conf.jsp"%>
<%
//文件管理系统 V1.1
//2018-04-19
//simple
	request.setCharacterEncoding("utf-8");
	String file = new String(request.getParameter("file").getBytes("utf-8"),"UTF-8");
	String curName = "";
	if(!Tool.isEmp(file))
	{
		String[] tmp = file.split("/");
		if(tmp.length>1)
		{
			curName = tmp[tmp.length-1];
		}
	}
	OutputStream o = response.getOutputStream();
	File fileLoad = new File(file);
	response.reset();
	response.setContentType("application/x-msdownload;charset=utf-8;");
	response.setHeader("content-disposition","attachment;filename="+new String(curName.getBytes("UTF-8"),"utf-8"));
	long fileLength = fileLoad.length();
	String length1 = String.valueOf(fileLength);
	response.setHeader("Content_Length", length1);
	FileInputStream in = new FileInputStream(fileLoad);
	int n;
	byte[] b = new byte[(int)fileLength];
	while ((n = in.read(b)) != -1)
	{
		o.write(b, 0, n);
	}
	in.close();
	o.close();
%>