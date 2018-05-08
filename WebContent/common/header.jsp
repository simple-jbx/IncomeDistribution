<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="taglib.jsp"%>
<c:if test="${empty sessionScope.currentYH}">
	<script>
		alert("请重新登陆！");
		window.location.href = "login.jsp";
	</script>
</c:if>

