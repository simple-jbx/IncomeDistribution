<%@ page language="java"
	import="java.util.*,service.XYQTRYService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	if(StringUtils.isEmpty(op)) {
		XYQTRYService xyqtryService = new XYQTRYService();
		List<Map<String, Object> > list = xyqtryService.getData();
		//System.out.println(list);
		String json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		//System.out.println(row);
		XYQTRY xyqtry = JSON.parseObject(row, XYQTRY.class);
		//System.out.print(bdwjcjffzbb);
		XYQTRYService xyqtryService = new XYQTRYService();
		xyqtryService.updateData(xyqtry);
		//System.out.println(row);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的ID
		XYQTRYService xyqtryService = new XYQTRYService();
		xyqtryService.deleteByID(ID);
		out.print("1");//删除成功
	}
%>