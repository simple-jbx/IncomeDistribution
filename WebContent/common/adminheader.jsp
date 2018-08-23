<%@ page language="java" pageEncoding="UTF-8" import="service.YHService,java.util.List,
java.util.Map"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${basePath}/static/js/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="${basePath}/static/js/bootstrap/css/bootstrap-table.min.css"
	rel="stylesheet" type="text/css">
<link href="${basePath}/static/js/bootstrap/css/bootstrap-editable.css" rel="stylesheet" type="text/css">
<script src="${basePath}/static/js/jQuery.js"></script>
<script src="${basePath}/static/js/bootstrap/js/bootstrap.min.js"></script>
<script src="${basePath}/static/js/bootstrap/js/bootstrap-table.min.js"></script>
<script src="${basePath}/static/js/bootstrap/js/bootstrap-table-zh-CN.js"></script>  
<script src="${basePath}/static/js/bootstrap/js/bootstrap-editable.js"></script>
<script src="${basePath}/static/js/bootstrap/js/bootstrap-table-editable.js"></script>
<script src="${basePath}/static/js/bootstrap/js/bootstrap-table-export.js"></script>
<script src="${basePath}/static/js/tableExport/libs/js-xlsx/xlsx.core.min.js"></script>
<script src="${basePath}/static/js/tableExport/tableExport.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<% 
	List<Map<String, Object> > yhList = YHService.getALLYH();
	request.setAttribute("jsonListYH", yhList);
%>