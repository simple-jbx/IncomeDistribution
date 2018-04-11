<%@ page language="java"
	import="java.util.*,service.XXPYSJKService,utils.StringUtils,bean.XXPYSJK,bean.YH,
	java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	YH yh = (YH)session.getAttribute("yh");
	if(yh != null) {
		if(StringUtils.isEmpty(op)) {
			//非法访问
			response.sendRedirect("../index.jsp");
		}else if(op.equals("personal")) {
			XXPYSJK xxpysjk = XXPYSJKService.getData(yh.getGH());
			if(xxpysjk != null) {
				out.print(xxpysjk.toJson());
			}else {
				out.print("0");
			}
		}else if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1) {
			XXPYSJKService xxpysjkService = new XXPYSJKService();
			if(op.equals("getAll")) {
				List<Map<String, Object> > list = xxpysjkService.getData();
				if(list != null) {
					String json = List2JsonUtils.list2Json2String(list);
					out.print(json);
				}else {
					out.print("0");
				}
			}else if(op.equalsIgnoreCase("update")) {
				String row = request.getParameter("row");
				if(StringUtils.isEmpty(row)) {
					out.print("-1");
				}else {
					XXPYSJK xxpysjk = JSON.parseObject(row, XXPYSJK.class);
					xxpysjkService.updateData(xxpysjk);
					out.println("1");
				}
			}else if(op.equalsIgnoreCase("delete")) {
				String ID = request.getParameter("ID");//获得从前端传来的工号
				if(StringUtils.isEmpty(ID)) {
					out.print("-1");
				}else {
					xxpysjkService.deleteByID(ID);
					out.println("1");						
				}
			}
		}	
	}else {
		//非登录用户
		response.sendRedirect("../login.jsp");
	}
%>