<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:if test="${empty sessionScope.yh}">
<%
	//request.getServerName()	服务器名称
	String path = request.getContextPath();//项目路径
	int port = request.getServerPort();
	String basePath  = null;
	if(port==80){
		basePath = request.getScheme()+"://"+request.getServerName()+path;
	}else{
		basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	}
	//basePath 项目的绝对路径
	request.setAttribute("basePath", basePath);
%>
	<script>
		window.location.href = "${basePath}/login.jsp";
	</script>
</c:if>
