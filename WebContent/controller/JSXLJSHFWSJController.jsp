<%@ page language="java"
	import="java.util.*,service.JSXLJSHFWSJService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	String json = "";
	JSXLJSHFWSJ jsxljshfwsj;
	JSXLJSHFWSJService jsxljshfwsjService = new JSXLJSHFWSJService();
	//System.out.println(op);
	if(StringUtils.isEmpty(op)) {
		List<Map<String, Object> > list = jsxljshfwsjService.getData();
		json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		jsxljshfwsj = JSON.parseObject(row, JSXLJSHFWSJ.class);
		jsxljshfwsjService.updateData(jsxljshfwsj);
		out.println("1");
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的ID
		jsxljshfwsjService.deleteByID(ID);
		out.println("1");
	}	
%>