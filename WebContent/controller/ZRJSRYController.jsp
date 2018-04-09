<%@ page language="java"
	import="java.util.*,service.ZRJSRYService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	if(StringUtils.isEmpty(op)) {
		ZRJSRYService zrjsryService = new ZRJSRYService();
		List<Map<String, Object> > list = zrjsryService.getData();
		//System.out.println(list);
		String json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		//System.out.println(row);
		ZRJSRY zrjsry = JSON.parseObject(row, ZRJSRY.class);
		//System.out.print(bdwjcjffzbb);
		ZRJSRYService zrjsryService = new ZRJSRYService();
		zrjsryService.updateData(zrjsry);
		//System.out.println(row);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String Id = request.getParameter("Id");//获得从前端传来的工号
		ZRJSRYService zrjsryService = new ZRJSRYService();
		zrjsryService.deleteByRydm(Id);
		out.print("1");
	}
%>