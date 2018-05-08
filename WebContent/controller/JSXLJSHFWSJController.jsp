<%@ page language="java"
	import="service.JSXLJSHFWSJService,service.commonService,utils.StringUtils,
	bean.YH,bean.JSXLJSHFWSJ,java.util.List,java.util.Map,utils.List2JsonUtils,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String paraOp  = request.getParameter("op");
	YH paraYh = (YH)session.getAttribute("yh");
	String paraYear = request.getParameter("year");
	if(paraYh != null) {
		if(StringUtils.isEmpty(paraOp)) {
			response.sendRedirect("../index.jsp");
		}else if(paraOp.equals("personal")) {
			JSXLJSHFWSJ outObject = commonService.getDataByRydm(JSXLJSHFWSJ.class, paraYh.getGH(), paraYear);
			if(outObject == null)
				outObject = new JSXLJSHFWSJ();
			out.print(outObject.toJSON());
		}else if(paraYh.getYHGROUP() == 0 || paraYh.getYHGROUP() == 1) {
			JSXLJSHFWSJService objectService = new JSXLJSHFWSJService();
			if(paraOp.equals("update")) {
				String row = request.getParameter("row");
				if(StringUtils.isEmpty(row)) {
					out.print("-1");//请求数据为空
				}else {
					JSXLJSHFWSJ JSON2Object = JSON.parseObject(row, JSXLJSHFWSJ.class);
					objectService.updateData(JSON2Object);
					out.println("1");
				}
				
			}else if(paraOp.equals("delete")) {
				String paraID = request.getParameter("ID");
				if(StringUtils.isEmpty(paraID)) {
					out.print("-1");//请求数据为空
				}else {
					commonService.deleteByID(JSXLJSHFWSJ.class, paraID);
					out.print("1");					
				}
			}else if(paraOp.equals("getAll")) {
				String outJSON = "0";
				List<Map<String, Object> > dataList = commonService.getAllData(JSXLJSHFWSJ.class);
				if(dataList != null) 
					outJSON = List2JsonUtils.list2Json2String(dataList);
				out.print(outJSON);
			}else {
				response.sendRedirect("../index.jsp");
			}
		}
	}else {
		response.sendRedirect("../login.jsp");
	}
%>