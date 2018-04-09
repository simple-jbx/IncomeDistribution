<%@ page language="java"
	import="java.util.*,service.ZWService,utils.StringUtils,bean.YH,bean.ZW,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	YH yh = (YH)session.getAttribute("yh");
	if(yh != null) {
		if(StringUtils.isEmpty(op)) {
			response.sendRedirect("../index.jsp");
		}else if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1){
			ZWService zwService = new ZWService();
			List<Map<String, Object> > list = null;
			String json = "";
			if(op.equals("getAll")) {
				list = zwService.getData();
				json = List2JsonUtils.list2Json2String(list);
				out.println(json);					
			}
			else if(op.equalsIgnoreCase("update")) {
				String row = request.getParameter("row");
				ZW zw = JSON.parseObject(row, ZW.class);
				zwService.updateData(zw);
				list = zwService.getData();
				json = List2JsonUtils.list2Json2String(list);
				out.println(json);	
			}else if(op.equalsIgnoreCase("delete")) {
				String ID = request.getParameter("ID");//获得从前端传来的ID
				zwService.deleteByID(ID);
				list = zwService.getData();
				json = List2JsonUtils.list2Json2String(list);
				out.println(json);	
			}
		}else {
			//非权限用户
			response.sendRedirect("../index.jsp");
		}
	}else {
		//未登录
		response.sendRedirect("../login.jsp");
	}
%>