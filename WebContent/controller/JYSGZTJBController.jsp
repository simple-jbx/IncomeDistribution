<%@ page language="java"
	import="service.JYSGZTJBService,service.commonService,utils.StringUtils,
	bean.YH,bean.JYSGZTJB,java.util.List,java.util.Map,utils.List2JsonUtils,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	YH yh = (YH)session.getAttribute("yh");
	if(yh != null) {
		if(StringUtils.isEmpty(op)) {
			response.sendRedirect("../index.jsp");
		}else if(op.equals("personal")) {
			JYSGZTJB jysgztjb = commonService.getDataByRydm(JYSGZTJB.class, yh.getGH());
			if(jysgztjb != null) {
				out.print(jysgztjb.toJson());
			}else {
				out.print("0");//没有数据
			}
		}else if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1) {
			JYSGZTJBService jysgztjbService = new JYSGZTJBService();
			String json = "";
			List<Map<String, Object> > list;
			if(op.equals("update")) {
				String row = request.getParameter("row");
				if(StringUtils.isEmpty(row)) {
					out.print("-1");//请求数据为空
				}else {
					JYSGZTJB jysgztjb = JSON.parseObject(row, JYSGZTJB.class);
					jysgztjbService.updateData(jysgztjb);
					out.println("1");
				}
				
			}else if(op.equals("delete")) {
				String iD = request.getParameter("ID");//获得从前端传来的工号
				if(StringUtils.isEmpty(iD)) {
					out.print("-1");//请求数据为空
				}else {
					commonService.deleteByID(JYSGZTJB.class, iD);
					out.print("1");					
				}
			}else if(op.equals("getAll")) {
				list = commonService.getAllData(JYSGZTJB.class);
				if(list == null) {
					out.print("0");//没有数据
				}else {
					json = List2JsonUtils.list2Json2String(list);
					out.print(json);
				}
			}else {
				response.sendRedirect("../index.jsp");
			}
		}
	}else {
		response.sendRedirect("../login.jsp");
	}
%>