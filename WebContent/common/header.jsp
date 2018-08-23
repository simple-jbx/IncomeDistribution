<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="taglib.jsp"%>
<%@include file="basePath.jsp"%>
<c:if test="${empty sessionScope.currentYH}">
	<script>
		window.location.href='${basePath}/login.jsp';
	</script>
</c:if>

