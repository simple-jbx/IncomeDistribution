<%@ page language="java"
	import="java.util.*,service.XZGLRYService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	if(StringUtils.isEmpty(op)) {
		XZGLRYService xzglryService = new XZGLRYService();
		List<Map<String, Object> > list = xzglryService.getData();
		//System.out.println(list);
		String json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		//System.out.println(row);
		XZGLRY xzglry = JSON.parseObject(row, XZGLRY.class);
		//System.out.print(bdwjcjffzbb);
		XZGLRYService xzglryService = new XZGLRYService();
		xzglryService.updateData(xzglry);
		//System.out.println(row);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的ID
		XZGLRYService xzglryService = new XZGLRYService();
		xzglryService.deleteByID(ID);
		out.print("1");//删除成功
	}
%>