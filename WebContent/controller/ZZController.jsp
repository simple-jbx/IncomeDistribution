<%@ page language="java"
	import="java.util.*,service.ZZService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	if(StringUtils.isEmpty(op)) {
		ZZService zzService = new ZZService();
		List<Map<String, Object> > list = zzService.getData();
		//System.out.println(list);
		String json = List2JsonUtils.list2Json2String(list);//将list对象转化为json格式的String字符串
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		ZZ zz = JSON.parseObject(row, ZZ.class);//将json对象转化指定的java bean对象
		ZZService zzService = new ZZService();
		zzService.updateData(zz);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的ID
		ZZService zzService = new ZZService();
		zzService.deleteByID(ID);
		out.print("1");//删除成功
	}
%>