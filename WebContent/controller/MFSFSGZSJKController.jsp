<%@ page language="java"
	import="java.util.*,service.MFSFSGZSJKService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	MFSFSGZSJKService mfsfsgzsjkService = new MFSFSGZSJKService();
	List<Map<String, Object> > list;
	String json;
	if(StringUtils.isEmpty(op)) {
		list = mfsfsgzsjkService.getData();
		json = List2JsonUtils.list2Json2String(list);
		out.println(json);	
	}else if(op.equalsIgnoreCase("update")) {
		String row = request.getParameter("row");
		MFSFSGZSJK mfsfsgzsjk = JSON.parseObject(row, MFSFSGZSJK.class);
		mfsfsgzsjkService.updateData(mfsfsgzsjk);
		out.print("0");//修改成功
	}else if(op.equalsIgnoreCase("delete")) {
		String ID = request.getParameter("ID");//获得从前端传来的工号
		mfsfsgzsjkService.deleteByID(ID);
		out.print("1");
	}
%>