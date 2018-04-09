<%@ page language="java"
	import="java.util.*,service.YHJSService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	YHJSService yhjsService = new YHJSService();
	List<Map<String, Object> > list = null;
	String json = "";
	if(StringUtils.isEmpty(op)) {
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		YHJS yhjs = JSON.parseObject(row, YHJS.class);
		JS js = JSON.parseObject(row, JS.class);
		//System.out.println(row);
		yhjsService.updateData(yhjs, js);
		out.println("1");	
	}else if(op.equalsIgnoreCase("delete")) {
		String Yhjsid = request.getParameter("Yhjsid");//获得从前端传来的ID
		String Yhid = request.getParameter("Yhid");//获得从前端传来的ID
		yhjsService.deleteByYhjsid(Yhjsid, Yhid);
		out.print("1");//删除成功
	}else if(op.equalsIgnoreCase("get")) {
		//个人查询，返回单条数据
		list = yhjsService.getAllYHJS();
		json = List2JsonUtils.list2Json2String(list);
		out.print(json);
		//System.out.println(json);
	}
%>