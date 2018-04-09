<%@ page language="java"
	import="java.util.*,service.ZJHDBTSJKService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	ZJHDBTSJKService zjhdbtsjkService = new ZJHDBTSJKService();
	List<Map<String, Object> > list;
	String json;
	if(StringUtils.isEmpty(op)) {
		 list = zjhdbtsjkService.getData();
		//System.out.println(list);
		json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		//System.out.println(row);
		ZJHDBTSJK zjhdbtsjk = JSON.parseObject(row, ZJHDBTSJK.class);
		//System.out.print(bdwjcjffzbb);
		zjhdbtsjkService.updateData(zjhdbtsjk);
		//System.out.println(row);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的工号
		zjhdbtsjkService.deleteByID(ID);
		out.print("1");
	}
%>