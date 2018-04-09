<%@ page language="java"
	import="service.ZLService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	if(StringUtils.isEmpty(op)) {
		ZLService zlService = new ZLService();
		List<Map<String, Object> > list = zlService.getData();
		//System.out.println(list);
		String json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		//System.out.println(row);
		ZL zl = JSON.parseObject(row, ZL.class);
		//System.out.print(bdwjcjffzbb);
		ZLService zlService = new ZLService();
		zlService.updateData(zl);
		//System.out.println(row);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的工号
		ZLService zlService = new ZLService();
		zlService.deleteByRydm(ID);
		out.print("1");
	}
%>