<%@ page language="java"
	import="java.util.*,service.XYPYSJKService,utils.StringUtils,bean.XYPYSJK,bean.YH,
	java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	YH yh = (YH)session.getAttribute("yh");
	XYPYSJKService xypysjkService = new XYPYSJKService();
	String json = "";
	List<Map<String, Object> > list;
	if(yh != null) {
		if(StringUtils.isEmpty(op)) {
			//非法访问
			response.sendRedirect("../index.jsp");
		}else if(op.equals("personal")) {
			XYPYSJK xypysjk = XYPYSJKService.getData(yh.getGH());
			if(xypysjk != null) {
				out.print(xypysjk.toJson());
			}else {
				//无数据
				out.print("0");
			}
		}else if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1) {
			if(op.equals("getAll")) {
				list = xypysjkService.getData();
				json = List2JsonUtils.list2Json2String(list);
				out.println(json);	
			}else if(op.equalsIgnoreCase("update")) {
				String row = request.getParameter("row");
				XYPYSJK xypysjk = JSON.parseObject(row, XYPYSJK.class);
				xypysjkService.updateData(xypysjk);
				out.println("1");
			}else if(op.equalsIgnoreCase("delete")) {
				String ID = request.getParameter("ID");//获得从前端传来的工号
				xypysjkService.deleteByID(ID);
				out.println("1");	
			}					
		}
	}else {
		//未登录用户
		response.sendRedirect("../login.jsp");
	}
%>