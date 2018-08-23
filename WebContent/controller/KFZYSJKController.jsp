<%@ page language="java"
	import="service.KFZYSJKService,service.commonService,utils.StringUtils,
	bean.YH,bean.KFZYSJK,java.util.List,java.util.Map,utils.List2JsonUtils,
	com.alibaba.fastjson.JSON,service.AuthorityIdentify"
	pageEncoding="UTF-8"%>
<%
	String paraOp  = request.getParameter("op");
	YH paraYH = (YH)session.getAttribute("currentYH");
	String paraYear = request.getParameter("year");
	String basePath = (String)session.getAttribute("basePath");
	String personalRefererURL = basePath + "/personal/KFZYSJK.jsp";
	String mamagerReffererURL = basePath + "/backstage/KFZYSJK.jsp";
	if(paraYH == null) {
		response.sendError(4000);//无用户
		return;
	}
	if(request.getHeader("Referer") == null || (!request.getHeader("Referer").equals(personalRefererURL)
			&& !request.getHeader("Referer").equals(mamagerReffererURL))) {
		response.sendError(4001);//非法访问
		return;
	}
	if(StringUtils.isEmpty(paraOp)) {
		response.sendError(4002);//参数为空
		return;
	}else if(paraOp.equals("personal")) {
		KFZYSJK outObject = commonService.getDataByRydm(KFZYSJK.class, paraYH.getRYDM(), paraYear);
		if(outObject == null)
			outObject = new KFZYSJK();
		out.print(outObject.toJSON());
		return;
	}else {
		 int authority = AuthorityIdentify.authIdentify(paraYH, "KFZYSJK");
		 if(paraOp.equals("getAll") && authority > 0) {
			 String outJSON = "0";
				List<Map<String, Object> > dataList = commonService.getAllData(KFZYSJK.class, paraYear);
				if(dataList != null) 
					outJSON = List2JsonUtils.list2Json2String(dataList);
				out.print(outJSON);
		 }else if(authority == 1) {
			if(paraOp.equals("update")) {
				String row = request.getParameter("row");
				if(StringUtils.isEmpty(row)) {
					out.print("-1");//请求数据为空
				}else {
					KFZYSJK JSON2Object = JSON.parseObject(row, KFZYSJK.class);
					KFZYSJKService.updateData(JSON2Object);
					out.println("1");
				}	
			}else if(paraOp.equals("delete")) {
				String paraID = JSON.parseObject(request.getParameter("ID"), String.class);
				if(StringUtils.isEmpty(paraID)) {
					out.print("-1");//请求数据为空
				}else {
					commonService.deleteByID(KFZYSJK.class, paraID);
					out.print("1");					
				}
			}else {
				response.sendError(4003);//参数无对应动作
			}
		}else {
			response.sendError(4004);//没有权限操作
		}
	}
%>