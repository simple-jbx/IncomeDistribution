<%@ page language="java"
	import="java.util.*,service.YJSGZSJService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	if(StringUtils.isEmpty(op)) {
		YJSGZSJService yjsgzsjService = new YJSGZSJService();
		List<Map<String, Object> > list = yjsgzsjService.getData();
		//System.out.println(list);
		String json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		//System.out.println(row);
		YJSGZSJ yjsgzsj = JSON.parseObject(row, YJSGZSJ.class);
		//System.out.print(bdwjcjffzbb);
		YJSGZSJService yjsgzsjService = new YJSGZSJService();
		yjsgzsjService.updateData(yjsgzsj);
		//System.out.println(row);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的工号
		YJSGZSJService yjsgzsjService = new YJSGZSJService();
		yjsgzsjService.deleteByID(ID);
		out.print("1");
	}
%>