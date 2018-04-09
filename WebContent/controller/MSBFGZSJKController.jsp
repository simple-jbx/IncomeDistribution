<%@ page language="java"
	import="java.util.*,service.MSBFGZSJKService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	MSBFGZSJKService msbfgzsjkService = new MSBFGZSJKService();
	List<Map<String, Object> > list;
	String json;
	if(StringUtils.isEmpty(op)) {
		 list = msbfgzsjkService.getData();
		//System.out.println(list);
		json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		//System.out.println(row);
		MSBFGZSJK msbfgzsjk = JSON.parseObject(row, MSBFGZSJK.class);
		//System.out.print(bdwjcjffzbb);
		msbfgzsjkService.updateData(msbfgzsjk);
		//System.out.println(row);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的工号
		msbfgzsjkService.deleteByID(ID);
		out.print("1");
	}
%>