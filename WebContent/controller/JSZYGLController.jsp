<%@ page language="java"
	import="java.util.*,service.JSZYService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	JSZYService yhjsService = new JSZYService();
	List<Map<String, Object> > list = null;
	String json = "";
	if(StringUtils.isEmpty(op)) {
		
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		JSZY jszy = JSON.parseObject(row, JSZY.class);
		yhjsService.updateData(jszy);
		out.println("1");	
	}else if(op.equalsIgnoreCase("delete")) {
		String Jszyid = request.getParameter("Jszyid");//获得从前端传来的ID
		yhjsService.deleteByJszyid(Jszyid);
		out.print("1");//删除成功
	}else if(op.equalsIgnoreCase("getAll")) {
		//个人查询，返回单条数据
		list = yhjsService.getAllJSZY();
		json = List2JsonUtils.list2Json2String(list);
		out.print(json);
		//System.out.println(json);
	}
%>