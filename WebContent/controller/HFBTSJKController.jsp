<%@ page language="java"
	import="service.HFBTSJKService,service.commonService,utils.StringUtils,
	bean.YH,bean.HFBTSJK,java.util.List,java.util.Map,utils.List2JsonUtils,
	com.alibaba.fastjson.JSON,service.AuthorityIdentify"
	pageEncoding="UTF-8"%>
<%
	String paraOp  = request.getParameter("op");
	YH paraYH = (YH)session.getAttribute("currentYH");
	String paraYear = request.getParameter("year");
	String basePath = (String)session.getAttribute("basePath");
	String personalRefererURL = basePath + "/personal/HFBTSJK.jsp";
	String mamagerReffererURL = basePath + "/backstage/basicmanage/HFBTSJK.jsp";
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
		HFBTSJK outObject = commonService.getDataByRydm(HFBTSJK.class, paraYH.getRYDM(), paraYear);
		if(outObject == null)
			outObject = new HFBTSJK();
		out.print(outObject.toJSON());
		return;
	}else {
		 int authority = AuthorityIdentify.authIdentify(paraYH, "HFBTSJK");
		 if(paraOp.equals("getAll") && authority > 0) {
			 String outJSON = "0";
				List<Map<String, Object> > dataList = commonService.getAllData(HFBTSJK.class, paraYear);
				if(dataList != null) 
					outJSON = List2JsonUtils.list2Json2String(dataList);
				out.print(outJSON);
		 }else if(authority == 1) {
			if(paraOp.equals("update")) {
				String row = request.getParameter("row");
				if(StringUtils.isEmpty(row)) {
					out.print("-1");//请求数据为空
				}else {
					HFBTSJK JSON2Object = JSON.parseObject(row, HFBTSJK.class);
					HFBTSJKService.updateData(JSON2Object);
					out.println("1");
				}	
			}else if(paraOp.equals("delete")) {
				String paraID = JSON.parseObject(request.getParameter("ID"), String.class);
				if(StringUtils.isEmpty(paraID)) {
					out.print("-1");//请求数据为空
				}else {
					commonService.deleteByID(HFBTSJK.class, paraID);
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