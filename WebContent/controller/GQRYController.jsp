<%@ page language="java"
	import="java.util.*,service.GQRYService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	if(StringUtils.isEmpty(op)) {
		GQRYService gqryService = new GQRYService();
		List<Map<String, Object> > list = gqryService.getData();
		//System.out.println(list);
		String json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		//System.out.println(row);
		GQRY gqry = JSON.parseObject(row, GQRY.class);
		GQRYService gqryService = new GQRYService();
		gqryService.updateData(gqry);
		//System.out.println(row);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String gH = request.getParameter("gH");//获得从前端传来的工号
		GQRYService gqryService = new GQRYService();
		gqryService.deleteByGh(gH);
		out.print("1");
	}
	
%>