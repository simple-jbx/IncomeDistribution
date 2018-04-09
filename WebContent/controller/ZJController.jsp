<%@ page language="java"
	import="java.util.*,service.ZJService,utils.StringUtils,bean.ZJ,bean.YH,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	YH yh = (YH)session.getAttribute("yh");
	ZJService zjService = new ZJService();
	List<Map<String, Object> > list = null;
	String json = "";
	if(yh != null) {
		if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1) {
			if(StringUtils.isEmpty(op)) {
				response.sendRedirect("../index.jsp");
			}else if(op.equals("getAll")) {
				list = zjService.getData();
				json = List2JsonUtils.list2Json2String(list);
				out.println(json);	
			}else if(op.equalsIgnoreCase("update")) {
				String row = request.getParameter("row");
				ZJ zj = JSON.parseObject(row, ZJ.class);
				zjService.updateData(zj);
				list = zjService.getData();
				json = List2JsonUtils.list2Json2String(list);
				out.println(json);	
			}else if(op.equalsIgnoreCase("delete")) {
				String ID = request.getParameter("ID");//获得从前端传来的ID
				zjService.deleteByID(ID);
				list = zjService.getData();
				json = List2JsonUtils.list2Json2String(list);
				out.println(json);	
			}
		}else {
			//非权限用户
			response.sendRedirect("../index.jsp");
		}
	}else {
		//未登录用户
		response.sendRedirect("../login.jsp");
	}
	
%>