<%@ page language="java" contentType="text/html; charset=UTF-8" import="bean.YH"
	pageEncoding="UTF-8"%>
<%
	String baseURL = (String)session.getAttribute("basePath");
	if(baseURL == null || baseURL.isEmpty()) {
		String path = request.getContextPath();//项目路径
		int port = request.getServerPort();
		if(port==80){
			baseURL = request.getScheme()+"://"+request.getServerName()+path;
		}else{
			baseURL = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
		}
		session.setAttribute("basePath", baseURL);	
	}
%>