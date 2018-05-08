<%@ page language="java"
	import="service.XZGLRYService,service.commonService,utils.StringUtils,
	bean.YH,bean.XZGLRY,java.util.List,java.util.Map,utils.List2JsonUtils,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	YH yh = (YH)session.getAttribute("yh");
	if(yh != null) {
		if(StringUtils.isEmpty(op)) {
			response.sendRedirect("../index.jsp");
		}else if(op.equals("personal")) {
			XZGLRY getObject = commonService.getDataByRydm(XZGLRY.class, yh.getGH());
			if(getObject != null) {
				out.print(getObject.toJson());
			}else {
				out.print("0");//没有数据
			}
		}else if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1) {
			XZGLRYService serviceObj = new XZGLRYService();
			String jsonOfObj = "";
			List<Map<String, Object> > listOfObj;
			if(op.equals("update")) {
				String row = request.getParameter("row");
				//System.out.println(StringUtils.isEmpty(row));
				if(StringUtils.isEmpty(row)) {
					out.print("-1");//请求数据为空
				}else {
					XZGLRY parseObj = JSON.parseObject(row, XZGLRY.class);
					serviceObj.updateData(parseObj);
					out.println("1");
				}
				
			}else if(op.equals("delete")) {
				String iD = request.getParameter("ID");//获得从前端传来的工号
				if(StringUtils.isEmpty(iD)) {
					out.print("-1");//请求数据为空
				}else {
					commonService.deleteByID(XZGLRY.class, iD);
					out.print("1");					
				}
			}else if(op.equals("getAll")) {
				listOfObj = commonService.getAllData(XZGLRY.class);
				if(listOfObj == null) {
					out.print("0");//没有数据
				}else {
					jsonOfObj = List2JsonUtils.list2Json2String(listOfObj);
					out.print(jsonOfObj);
				}
			}else {
				response.sendRedirect("../index.jsp");
			}
		}
	}else {
		response.sendRedirect("../login.jsp");
	}
%>