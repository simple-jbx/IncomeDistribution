<%@ page language="java"
	import="java.util.*,service.JYSHDJFSJKService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	JYSHDJFSJKService jyshdjfsjkService = new JYSHDJFSJKService();
	String json = "";
	List<Map<String, Object> > list;
	if(StringUtils.isEmpty(op)) {
		list = jyshdjfsjkService.getData();
		json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		JYSHDJFSJK jyshdjfsjk = JSON.parseObject(row, JYSHDJFSJK.class);
		jyshdjfsjkService.updateData(jyshdjfsjk);
		out.println("1");
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的工号
		jyshdjfsjkService.deleteByID(ID);
		out.println("1");	
	}
%>