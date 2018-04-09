<%@ page language="java"
	import="java.util.*,service.LWService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	if(StringUtils.isEmpty(op)) {
		LWService bdwcjffzbbService = new LWService();
		List<Map<String, Object> > list = bdwcjffzbbService.getData();
		//System.out.println(list);
		String json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		//System.out.println(row);
		LW lw = JSON.parseObject(row, LW.class);
		//System.out.print(bdwjcjffzbb);
		LWService lwService = new LWService();
		lwService.updateData(lw);
		//System.out.println(row);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String Rydm = request.getParameter("Rydm");//获得从前端传来的工号
		LWService bdwcjffzbbService = new LWService();
		bdwcjffzbbService.deleteByRydm(Rydm);
		out.print("1");
	}
%>