<%@ page language="java"
	import="service.SBXXFFBSJKService,service.commonService,utils.StringUtils,
	bean.YH,bean.SBXXFFBSJK,java.util.List,java.util.Map,utils.List2JsonUtils,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	YH yh = (YH)session.getAttribute("yh");
	if(yh != null) {
		if(StringUtils.isEmpty(op)) {
			response.sendRedirect("../index.jsp");
		}else if(op.equals("personal")) {
			SBXXFFBSJK sbxxffbsjk = commonService.getDataByRydm(SBXXFFBSJK.class, yh.getGH());
			if(sbxxffbsjk != null) {
				out.print(sbxxffbsjk.toJson());
			}else {
				out.print("0");//没有数据
			}
		}else if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1) {
			SBXXFFBSJKService sbxxffbsjkService = new SBXXFFBSJKService();
			String json = "";
			List<Map<String, Object> > list;
			if(op.equals("update")) {
				String row = request.getParameter("row");
				if(StringUtils.isEmpty(row)) {
					out.print("-1");//请求数据为空
				}else {
					SBXXFFBSJK sbxxffbsjk = JSON.parseObject(row, SBXXFFBSJK.class);
					sbxxffbsjkService.updateData(sbxxffbsjk);
					out.println("1");
				}
				
			}else if(op.equals("delete")) {
				String iD = request.getParameter("ID");//获得从前端传来的工号
				if(StringUtils.isEmpty(iD)) {
					out.print("-1");//请求数据为空
				}else {
					commonService.deleteByID(SBXXFFBSJK.class, iD);
					out.print("1");					
				}
			}else if(op.equals("getAll")) {
				list = commonService.getAllData(SBXXFFBSJK.class);
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