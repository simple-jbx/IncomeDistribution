<%@ page language="java"
	import="java.util.*,service.YHService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	if(StringUtils.isEmpty(op)) {
		YHService yhService = new YHService();
		List<Map<String, Object> > list = yhService.getData();
		//System.out.println(list);
		String json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		//System.out.println(row);
		YH yh = JSON.parseObject(row, YH.class);
		//System.out.print(yh);
		YHService yhService = new YHService();
		yhService.updateData(yh);
		//System.out.println(row);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的ID
		YHService zgsjxsService = new YHService();
		zgsjxsService.deleteByID(ID);
		out.print("1");//删除成功
	}
%>