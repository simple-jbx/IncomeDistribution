<%@ page language="java" contentType="text/html; charset=UTF-8" import="bean.YH"
	pageEncoding="UTF-8"%>
<%
	String basePath = (String)session.getAttribute("basePath");
	if(basePath == null || basePath.isEmpty()) {
		//request.getServerName()	服务器名称
		String path = request.getContextPath();//项目路径
		int port = request.getServerPort();
		if(port==80){
			basePath = request.getScheme()+"://"+request.getServerName()+path;
		}else{
			basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
		}
		//basePath 项目的绝对路径
		session.setAttribute("basePath", basePath);	
		//System.out.println(basePath);
	}
%>