<%@ page language="java"
	import="java.util.*,service.ELYLBZXCGService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	if(StringUtils.isEmpty(op)) {
		ELYLBZXCGService elylbzxcgService = new ELYLBZXCGService();
		List<Map<String, Object> > list = elylbzxcgService.getData();
		//System.out.println(list);
		String json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		//System.out.println(row);
		ELYLBZXCG elylbzxcg = JSON.parseObject(row, ELYLBZXCG.class);
		//System.out.print(bdwjcjffzbb);
		ELYLBZXCGService elylbzxcgService = new ELYLBZXCGService();
		elylbzxcgService.updateData(elylbzxcg);
		//System.out.println(row);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的ID
		ELYLBZXCGService elylbzxcgService = new ELYLBZXCGService();
		elylbzxcgService.deleteByID(ID);
		out.print("1");//删除成功
	}
%>