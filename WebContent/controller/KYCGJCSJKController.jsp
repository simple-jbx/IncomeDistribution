<%@ page language="java"
	import="java.util.*,service.KYFSTJBService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	KYFSTJBService kyfstjbService = new KYFSTJBService();
	String json = "";
	List<Map<String, Object> > list;
	if(StringUtils.isEmpty(op)) {
		list = kyfstjbService.getData();
		json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		KYFSTJB kyfstjb = JSON.parseObject(row, KYFSTJB.class);
		kyfstjbService.updateData(kyfstjb);
		list = kyfstjbService.getData();
		json = List2JsonUtils.list2Json2String(list);
		out.println(json);
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的工号
		kyfstjbService.deleteByID(ID);
		list = kyfstjbService.getData();
		json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}
%>