<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%  
 //注销
	session.removeAttribute("yh");
	session.invalidate();
%>
