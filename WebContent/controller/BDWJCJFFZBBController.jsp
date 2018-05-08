<%@ page language="java"
	import="service.BDWJCJFFZBBService,service.commonService,utils.StringUtils,
	bean.YH,bean.BDWJCJFFZBB,java.util.List,java.util.Map,utils.List2JsonUtils,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	YH yh = (YH)session.getAttribute("yh");
	if(yh != null) {
		if(StringUtils.isEmpty(op)) {
			response.sendRedirect("../index.jsp");
		}else if(op.equals("personal")) {
			BDWJCJFFZBB bdwjcjffzbb = commonService.getDataByRydm(BDWJCJFFZBB.class, yh.getGH());
			if(bdwjcjffzbb != null) {
				out.print(bdwjcjffzbb.toJson());
			}else {
				out.print("0");//没有数据
			}
		}else if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1) {
			BDWJCJFFZBBService bdwjcjffzbbService = new BDWJCJFFZBBService();
			String json = "";
			List<Map<String, Object> > list;
			if(op.equals("update")) {
				String row = request.getParameter("row");
				//System.out.println(StringUtils.isEmpty(row));
				if(StringUtils.isEmpty(row)) {
					out.print("-1");//请求数据为空
				}else {
					BDWJCJFFZBB bdwjcjffzbb = JSON.parseObject(row, BDWJCJFFZBB.class);
					bdwjcjffzbbService.updateData(bdwjcjffzbb);
					out.println("1");
				}
				
			}else if(op.equals("delete")) {
				String iD = request.getParameter("ID");//获得从前端传来的工号
				if(StringUtils.isEmpty(iD)) {
					out.print("-1");//请求数据为空
				}else {
					commonService.deleteByID(BDWJCJFFZBB.class, iD);
					out.print("1");					
				}
			}else if(op.equals("getAll")) {
				list = commonService.getAllData(BDWJCJFFZBB.class);
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