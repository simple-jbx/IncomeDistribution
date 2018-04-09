<%@ page language="java"
	import="java.util.*,service.QTGZService,utils.StringUtils,bean.YH,bean.QTGZ,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON, bean.QTGZ"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	if(StringUtils.isEmpty(op)) {
		QTGZService qtgzService = new QTGZService();
		List<Map<String, Object> > list = qtgzService.getData();
		String json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		QTGZ qtgz = JSON.parseObject(row, QTGZ.class);
		QTGZService qtgzService = new QTGZService();
		qtgzService.updateData(qtgz);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的ID
		QTGZService qtgzService = new QTGZService();
		qtgzService.deleteByID(ID);
		out.print("1");//删除成功
	}else{
		QTGZService qtgzService = new QTGZService();
		Map<String, Object> map = qtgzService.getDataForBean(op);
		BigDecimal JE = (BigDecimal)map.get("je");
		out.print(JE);
	}
%>