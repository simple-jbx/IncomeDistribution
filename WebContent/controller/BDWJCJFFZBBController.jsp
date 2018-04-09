<%@ page language="java"
	import="java.util.*,service.BDWJCJFFZBBService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	if(StringUtils.isEmpty(op)) {
		BDWJCJFFZBBService bdwcjffzbbService = new BDWJCJFFZBBService();
		List<Map<String, Object> > list = bdwcjffzbbService.getData();
		//System.out.println(list);
		String json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		//System.out.println(row);
		BDWJCJFFZBB bdwjcjffzbb = JSON.parseObject(row, BDWJCJFFZBB.class);
		//System.out.print(bdwjcjffzbb);
		BDWJCJFFZBBService bdwcjffzbbService = new BDWJCJFFZBBService();
		bdwcjffzbbService.updateData(bdwjcjffzbb);
		//System.out.println(row);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String Rydm = request.getParameter("Rydm");//获得从前端传来的工号
		BDWJCJFFZBBService bdwcjffzbbService = new BDWJCJFFZBBService();
		bdwcjffzbbService.deleteByRydm(Rydm);
		out.print("1");
	}
%>