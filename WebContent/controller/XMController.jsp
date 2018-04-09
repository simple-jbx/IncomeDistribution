<%@ page language="java"
	import="java.util.*,service.XMService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	if(StringUtils.isEmpty(op)) {
		XMService xmService = new XMService();
		List<Map<String, Object> > list = xmService.getData();
		//System.out.println(list);
		String json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		//System.out.println(row);
		XM xm = JSON.parseObject(row, XM.class);
		//System.out.print(bdwjcjffzbb);
		XMService xmService = new XMService();
		xmService.updateData(xm);
		//System.out.println(row);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String Id = request.getParameter("Id");//获得从前端传来的工号
		XMService xmService = new XMService();
		xmService.deleteByRydm(Id);
		out.print("1");
	}
%>