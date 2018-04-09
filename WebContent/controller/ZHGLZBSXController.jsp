<%@ page language="java"
	import="java.util.*,service.ZHGLZBSXService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	ZHGLZBSXService zhglzbsxService = new ZHGLZBSXService();
	List<Map<String, Object> > list = null;
	String json = "";
	if(StringUtils.isEmpty(op)) {
		list = zhglzbsxService.getData();
		json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		ZHGLZBSX zhglzbsx = JSON.parseObject(row, ZHGLZBSX.class);
		zhglzbsxService.updateData(zhglzbsx);
		list = zhglzbsxService.getData();
		json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的ID
		zhglzbsxService.deleteByID(ID);
		list = zhglzbsxService.getData();
		json = List2JsonUtils.list2Json2String(list);
		out.println(json);
	}
%>