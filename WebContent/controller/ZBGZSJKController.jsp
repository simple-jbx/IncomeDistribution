<%@ page language="java"
	import="service.ZBGZSJKService,service.QTGZService,utils.StringUtils,bean.YH,
	bean.ZBGZSJK, bean.QTGZ, java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	YH yh = (YH)session.getAttribute("yh");
	
	if(yh != null) {
		if(StringUtils.isEmpty(op)) {
			//out.print("-2");
			response.sendRedirect("../index.jsp");
		}else if(op.equals("personal")){
			ZBGZSJK zbgzsjk = ZBGZSJKService.getData(yh.getGH());
			if(zbgzsjk != null) {
				out.print(zbgzsjk.toJson());
			}else {
				out.print("0");//无数据
			}
		}else if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1) {
			ZBGZSJKService zbgzsjkService = new ZBGZSJKService();
			List<Map<String, Object> > list;
			String json;
			if(op.equals("getAll")) {
				 list = zbgzsjkService.getData();
				 if(list != null) {
					 json = List2JsonUtils.list2Json2String(list);
					 out.println(json);	
				 }else {
					 out.print("0");
				 }
			}else if(op.equals("update")) {
				String row = request.getParameter("row");
				if(StringUtils.isEmpty(row)) {
					out.print("-1");
				}else {
					ZBGZSJK zbgzsjk = JSON.parseObject(row, ZBGZSJK.class);
					zbgzsjkService.updateData(zbgzsjk);
					out.print("1");//修改成功	
				}
			}else if(op.equals("delete")) {
				String ID = request.getParameter("ID");//获得从前端传来的工号
				if(StringUtils.isEmpty(ID)) {
					out.print("-1");//请求数据为空
				}else {
				zbgzsjkService.deleteByID(ID);
				out.print("1");					
				}
			}else{
				QTGZService qtgzService = new QTGZService();
				QTGZ qtgz = qtgzService.getDataForBean(op);
				if(qtgz != null) {
					BigDecimal JE = qtgz.getJE();
					out.print(JE);					
				}else {
					out.print("0.00");
				}
			}
		}
	}else {
		response.sendRedirect("../login.jsp");
	}	
%>