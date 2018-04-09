<%@ page language="java"
	import="java.util.*,service.XXPYSJKService,utils.StringUtils,bean.XXPYSJK,bean.YH,
	java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	YH yh = (YH)session.getAttribute("yh");
	String json = "";
	List<Map<String, Object> > list;
	if(yh != null) {
		if(StringUtils.isEmpty(op)) {
			//非法访问
			response.sendRedirect("../index.jsp");
		}else if(op.equals("personal")) {
			
		}else if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1) {
			XXPYSJKService xxpysjkService = new XXPYSJKService();
			if(op.equals("getAll")) {
				list = xxpysjkService.getData();
				json = List2JsonUtils.list2Json2String(list);
				out.println(json);	
			}else if(op.equalsIgnoreCase("update")) {
				String row = request.getParameter("row");
				XXPYSJK xxpysjk = JSON.parseObject(row, XXPYSJK.class);
				xxpysjkService.updateData(xxpysjk);
				out.println("1");
			}else if(op.equalsIgnoreCase("delete")) {
				String ID = request.getParameter("ID");//获得从前端传来的工号
				xxpysjkService.deleteByID(ID);
				out.println("1");	
			}
		}	
	}else {
		//非登录用户
		response.sendRedirect("../login.jsp");
	}
%>