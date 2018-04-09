<%@ page language="java"
	import="java.util.*,service.ZBTXBTSJKService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	ZBTXBTSJKService zbtxbtsjkService = new ZBTXBTSJKService();
	String json = "";
	List<Map<String, Object> > list;
	if(StringUtils.isEmpty(op)) {
		list = zbtxbtsjkService.getData();
		json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		ZBTXBTSJK zbtxbtsjk = JSON.parseObject(row, ZBTXBTSJK.class);
		zbtxbtsjkService.updateData(zbtxbtsjk);
		out.println("1");
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的工号
		zbtxbtsjkService.deleteByID(ID);
		out.println("1");	
	}
%>