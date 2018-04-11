<%@ page language="java"
	import="java.util.*,service.KYCGJCSJKService,utils.StringUtils,bean.YH,bean.KYCGJCSJK,
	java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	YH yh = (YH)session.getAttribute("yh");
	if(yh != null) {
		if(StringUtils.isEmpty(op)) {
			response.sendRedirect("../index.jsp");
		}else if(op.equals("personal")) {
			KYCGJCSJK kycgjcsjk = KYCGJCSJKService.getData(yh.getGH());
			if(kycgjcsjk != null) {
				out.print(kycgjcsjk.toJson());
			}else {
				out.print("0");//没有数据
			}
		}else if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1) {
			KYCGJCSJKService kycgjcsjkService = new KYCGJCSJKService();
			String json = "";
			List<Map<String, Object> > list;
			if(op.equals("update")) {
				String row = request.getParameter("row");
				if(StringUtils.isEmpty(row)) {
					out.print("-1");//请求数据为空
				}else {
					KYCGJCSJK kycgjcsjk = JSON.parseObject(row, KYCGJCSJK.class);
					kycgjcsjkService.updateData(kycgjcsjk);
					out.println("1");
				}
				
			}else if(op.equals("delete")) {
				String ID = request.getParameter("ID");//获得从前端传来的工号
				if(StringUtils.isEmpty(ID)) {
					out.print("-1");//请求数据为空
				}else {
					kycgjcsjkService.deleteByID(ID);
					out.print("1");					
				}
			}else if(op.equals("getAll")) {
				list = kycgjcsjkService.getData();
				if(list == null) {
					out.print("0");//没有数据
				}else {
					json = List2JsonUtils.list2Json2String(list);
					out.print(json);
				}
			}
		}
	}else {
		response.sendRedirect("../login.jsp");
	}

%>