<%@ page language="java"
	import="java.util.*,service.HJService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	if(StringUtils.isEmpty(op)) {
		HJService hjService = new HJService();
		List<Map<String, Object> > list = hjService.getData();
		//System.out.println(list);
		String json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		//System.out.println(row);
		HJ hj = JSON.parseObject(row, HJ.class);
		//System.out.print(bdwjcjffzbb);
		HJService hjService = new HJService();
		hjService.updateData(hj);
		//System.out.println(row);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的ID
		HJService hjService = new HJService();
		hjService.deleteByID(ID);
		out.print("1");//删除成功
	}
%>