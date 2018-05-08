<%@ page language="java"
	import="service.ZGSJXSService,service.commonService,utils.StringUtils,
	bean.YH,bean.ZGSJXS,java.util.List,java.util.Map,utils.List2JsonUtils,
	com.alibaba.fastjson.JSON,service.AuthorityIdentify"
	pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<%
	String paraOp  = request.getParameter("op");
	YH paraYh = (YH)session.getAttribute("currentYH");
	String paraYear = request.getParameter("year");
	String basePath = (String)session.getAttribute("basePath");
	String personalRefererURL = basePath + "/personal/ZGSJXS.jsp";
	String mamagerReffererURL = basePath + "/backstage/ZGSJXS.jsp";
	if(request.getHeader("Referer") == null || (!request.getHeader("Referer").equals(personalRefererURL)
			&& !request.getHeader("Referer").equals(mamagerReffererURL))) {
		response.sendError(405);//非法访问
		return;
	}
	if(StringUtils.isEmpty(paraOp)) {
		response.sendError(400);//请求语法不正确
		return;
	}else if(paraOp.equals("personal")) {
		ZGSJXS outObject = commonService.getDataByRydm(ZGSJXS.class, paraYh.getRYDM(), paraYear);
		if(outObject == null)
			outObject = new ZGSJXS();
		out.print(outObject.toJSON());
		return;
	}else {
		 int authority = AuthorityIdentify.authIdentify(paraYh, "ZGSJXS");
		 if(paraOp.equals("getAll") && authority > 0) {
			 String outJSON = "0";
				List<Map<String, Object> > dataList = commonService.getAllData(ZGSJXS.class);
				if(dataList != null) 
					outJSON = List2JsonUtils.list2Json2String(dataList);
				out.print(outJSON);
		 }else if(authority == 1) {
			ZGSJXSService objectService = new ZGSJXSService();
			if(paraOp.equals("update")) {
				String row = request.getParameter("row");
				if(StringUtils.isEmpty(row)) {
					out.print("-1");//请求数据为空
				}else {
					ZGSJXS JSON2Object = JSON.parseObject(row, ZGSJXS.class);
					objectService.updateData(JSON2Object);
					out.println("1");
				}	
			}else if(paraOp.equals("delete")) {
				String paraID = request.getParameter("ID");
				if(StringUtils.isEmpty(paraID)) {
					out.print("-1");//请求数据为空
				}else {
					commonService.deleteByID(ZGSJXS.class, paraID);
					out.print("1");					
				}
			}else {
				response.sendError(405);//非法访问
			}
		}else {
			response.sendError(405);//非法访问
		}
	}
%>