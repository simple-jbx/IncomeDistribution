<%@ page language="java"
	import="java.util.*,service.XYZHGLYFZPJFPJGBService,utils.StringUtils,bean.YH,bean.XYZHGLYFZPJFPJGB,
	java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	YH yh = (YH)session.getAttribute("yh");
	XYZHGLYFZPJFPJGBService xyzhglyfzpjfpjgbService = new XYZHGLYFZPJFPJGBService();
	List<Map<String, Object> > list = null;
	String json = "";
	if(yh != null) {
		if(op.equals("getAll")) {
			list = xyzhglyfzpjfpjgbService.getData();
			json = List2JsonUtils.list2Json2String(list);
			out.println(json);	
		}else if(op.equalsIgnoreCase("update")) {
			String row = request.getParameter("row");
			XYZHGLYFZPJFPJGB xyzhglyfzpjfpjgb = JSON.parseObject(row, XYZHGLYFZPJFPJGB.class);
			xyzhglyfzpjfpjgbService.updateData(xyzhglyfzpjfpjgb);
			list = xyzhglyfzpjfpjgbService.getData();
			json = List2JsonUtils.list2Json2String(list);
			out.println(json);	
		}else if(op.equalsIgnoreCase("delete")) {
			String ID = request.getParameter("ID");//获得从前端传来的ID
			xyzhglyfzpjfpjgbService.deleteByID(ID);
			list = xyzhglyfzpjfpjgbService.getData();
			json = List2JsonUtils.list2Json2String(list);
			out.println(json);
		}else if(StringUtils.isEmpty(op)) {
			response.sendRedirect("..index.jsp");
		}	
	}else {
		response.sendRedirect("..login.jsp");
	}
%>