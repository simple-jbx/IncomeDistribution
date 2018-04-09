<%@ page language="java"
	import="java.util.*,service.KYFSTJBService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	if(StringUtils.isEmpty(op)) {
		KYFSTJBService kyfstjbService = new KYFSTJBService();
		List<Map<String, Object> > list = kyfstjbService.getData();
		//System.out.println(list);
		String json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		//System.out.println(row);
		KYFSTJB kyfstjb = JSON.parseObject(row, KYFSTJB.class);
		//System.out.print(bdwjcjffzbb);
		KYFSTJBService kyfstjbService = new KYFSTJBService();
		kyfstjbService.updateData(kyfstjb);
		//System.out.println(row);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的工号
		KYFSTJBService bdwcjffzbbService = new KYFSTJBService();
		bdwcjffzbbService.deleteByID(ID);
		out.print("1");
	}
%>