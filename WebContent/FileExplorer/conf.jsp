<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="cn.gh.util.*,java.io.*"%>
	<%
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
	//System.out.println(path);
	String webRoot = path+"/FileExplorer/";
	String pageRoot = webRoot+"index.jsp";
	out.clear();
	%>