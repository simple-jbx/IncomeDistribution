<%@ page language="java"
	import="java.util.*,service.XYHBTSJKService,utils.StringUtils,bean.YH,bean.XYHBTSJK,
	java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,service.commonService,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	//System.out.println(op);
	YH yh = (YH)session.getAttribute("yh");
	if(yh != null) {
		if(StringUtils.isEmpty(op)) {
			response.sendRedirect("../index.jsp");
		}else if(op.equals("personal")) {
			XYHBTSJK xyhbtsjk = commonService.getDataByRydm(XYHBTSJK.class, yh.getGH());
			if(xyhbtsjk != null) {
				out.print(xyhbtsjk.toJson());
			}else {
				out.print("0");
			}
		}else if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1) {
			XYHBTSJKService xyhbtsjkService = new XYHBTSJKService();
			if(op.equals("getAll")) {
				List<Map<String, Object> > list = xyhbtsjkService.getData();
				if(list != null) {
					String json = List2JsonUtils.list2Json2String(list);
					out.print(json);
				}else {
					out.print("0");
				}
					
			}else if(op.equals("update")) {
				String row = request.getParameter("row");
				if(row != null) {
					XYHBTSJK xyhbtsjk = JSON.parseObject(row, XYHBTSJK.class);
					//System.out.print(bdwjcjffzbb);
					xyhbtsjkService.updateData(xyhbtsjk);
					out.print("1");//修改成功
				}else {
					out.print("-1");
				}				
			}else if(op.equals("delete")) {
				String iD = request.getParameter("ID");//获得从前端传来的工号
				commonService.deleteByID(XYHBTSJK.class, iD);
				out.print("1");
			}
		}else {
			response.sendRedirect("../index.jsp");
		}
	}else {
		response.sendRedirect("../login.jsp");
	}
%>