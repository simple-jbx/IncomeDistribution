<%@ page language="java"
	import="java.util.*,service.GZLJJKXXBService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	if(StringUtils.isEmpty(op)) {
		GZLJJKXXBService gzljjkxxbService = new GZLJJKXXBService();
		List<Map<String, Object> > list = gzljjkxxbService.getData();
		//System.out.println(list);
		String json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		//System.out.println(row);
		GZLJJKXXB gzljjkxxb = JSON.parseObject(row, GZLJJKXXB.class);
		//System.out.print(bdwjcjffzbb);
		GZLJJKXXBService gzljjkxxbService = new GZLJJKXXBService();
		gzljjkxxbService.updateData(gzljjkxxb);
		//System.out.println(row);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的ID
		GZLJJKXXBService gzljjkxxbService = new GZLJJKXXBService();
		gzljjkxxbService.deleteByID(ID);
		out.print("1");//删除成功
	}
%>