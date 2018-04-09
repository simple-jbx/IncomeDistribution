<%@ page language="java"
	import="java.util.*,service.DBBTSJKService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	DBBTSJKService dbbtsjkService = new DBBTSJKService();
	String json = "";
	List<Map<String, Object> > list;
	if(StringUtils.isEmpty(op)) {
		list = dbbtsjkService.getData();
		json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		DBBTSJK dbbtsjk = JSON.parseObject(row, DBBTSJK.class);
		dbbtsjkService.updateData(dbbtsjk);
		out.println("1");
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的工号
		dbbtsjkService.deleteByID(ID);
		out.println("1");	
	}
%>