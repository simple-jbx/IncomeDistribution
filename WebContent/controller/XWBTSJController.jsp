<%@ page language="java"
	import="java.util.*,service.XWBTSJService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	if(StringUtils.isEmpty(op)) {
		XWBTSJService xwbtsjService = new XWBTSJService();
		List<Map<String, Object> > list = xwbtsjService.getData();
		//System.out.println(list);
		String json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		//System.out.println(row);
		XWBTSJ xwbtsj = JSON.parseObject(row, XWBTSJ.class);
		//System.out.print(bdwjcjffzbb);
		XWBTSJService xwbtsjService = new XWBTSJService();
		xwbtsjService.updateData(xwbtsj);
		//System.out.println(row);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的工号
		XWBTSJService xwbtsjService = new XWBTSJService();
		xwbtsjService.deleteByRydm(ID);
		out.print("1");
	}
%>