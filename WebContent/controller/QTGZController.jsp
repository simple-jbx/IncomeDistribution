<%@ page language="java"
	import="service.commonService,service.QTGZService,utils.StringUtils,bean.YH,bean.QTGZ,java.util.List,
	java.util.Map,utils.List2JsonUtils,
	com.alibaba.fastjson.JSON,bean.QTGZ"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	if(StringUtils.isEmpty(op)) {
		List<Map<String, Object> > dataList = commonService.getAllData(QTGZ.class);
		String outJSON = List2JsonUtils.list2Json2String(dataList);
		out.print(outJSON);	
	}else if(op.equalsIgnoreCase("update")) {
		String paraRow = request.getParameter("row");
		//System.out.print(row);
		QTGZ JSON2Object = JSON.parseObject(paraRow, QTGZ.class);
		QTGZService.updateData(JSON2Object);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String paraID = request.getParameter("ID");//获得从前端传来的ID
		commonService.deleteByID(QTGZ.class,paraID);
		out.print("1");//删除成功
	}else if(op.equals("single")){
		//获取要查询的单条数据并输出，如没有则输出默认数据
		String paraField = request.getParameter("field");
		QTGZService objectService = new QTGZService();
		QTGZ outObject = objectService.getDataForBean(paraField);
		if(outObject == null) {
			outObject = new QTGZ();
		}
		out.print(outObject.toJSON());
	}
%>