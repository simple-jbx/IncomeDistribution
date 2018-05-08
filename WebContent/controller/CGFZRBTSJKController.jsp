<%@ page language="java"
	import="service.CGFZRBTSJKService,service.commonService,utils.StringUtils,
	bean.YH,bean.CGFZRBTSJK,java.util.List,java.util.Map,utils.List2JsonUtils,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String paraOp  = request.getParameter("op");
	YH paraYh = (YH)session.getAttribute("yh");
	String paraYear = request.getParameter("year");
	if(paraYh != null) {
		if(StringUtils.isEmpty(paraOp)) {
			//response.sendRedirect("../index.jsp");
		}else if(paraOp.equals("personal")) {
			CGFZRBTSJK outObject = commonService.getDataByRydm(CGFZRBTSJK.class, paraYh.getGH(), paraYear);
			if(outObject == null)
				outObject = new CGFZRBTSJK();
			out.print(outObject.toJSON());
		}else if(paraYh.getYHGROUP() == 0 || paraYh.getYHGROUP() == 1) {
			CGFZRBTSJKService objectService = new CGFZRBTSJKService();
			if(paraOp.equals("update")) {
				String paraRow = request.getParameter("row");
				if(StringUtils.isEmpty(paraRow)) {
					out.print("-1");//请求数据为空
				}else {
					CGFZRBTSJK JSON2Object = JSON.parseObject(paraRow, CGFZRBTSJK.class);
					objectService.updateData(JSON2Object);
					out.println("1");
				}
				
			}else if(paraOp.equals("delete")) {
				String paraID = request.getParameter("ID");//获得从前端传来的工号
				if(StringUtils.isEmpty(paraID)) {
					out.print("-1");//请求数据为空
				}else {
					commonService.deleteByID(CGFZRBTSJK.class, paraID);
					out.print("1");					
				}
			}else if(paraOp.equals("getAll")) {
				String outJSON = "0";
				List<Map<String, Object> > dataList = commonService.getAllData(CGFZRBTSJK.class);
				if(dataList != null)
					outJSON = List2JsonUtils.list2Json2String(dataList);
				out.print(outJSON);
			}else {
				//response.sendRedirect("../index.jsp");
			}
		}
	}else {
		//response.sendRedirect("../login.jsp");
	}
%>