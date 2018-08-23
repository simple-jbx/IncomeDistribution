<%@ page language="java" import="service.XXPYSJKService,service.commonService,utils.StringUtils,
	bean.YH,bean.XXPYSJK,java.util.List,java.util.Map,utils.List2JsonUtils,com.alibaba.fastjson.JSON,
	service.AuthorityIdentify,net.sf.json.JSONArray"
	pageEncoding="UTF-8"%>
<%
	//请求响应编码
	request.setCharacterEncoding("utf-8");      
	response.setCharacterEncoding("utf-8");
	
	//公共参数
	String paraOp  = request.getParameter("op");
	YH paraYH = (YH)session.getAttribute("currentYH");
	String paraYear = request.getParameter("year");
	
	//只允许网站内部访问
	String basePath = (String)session.getAttribute("basePath");
	String personalRefererURL = basePath + "/personal/XXPYSJK.jsp";
	String mamagerReffererURL = basePath + "/backstage/basicmanage/XXPYSJK.jsp";
	
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
	}else if(paraOp.equals("personal")) {//个人数据
		XXPYSJK outObject = commonService.getDataByRydm(XXPYSJK.class, paraYH.getRYDM(), paraYear);
		if(outObject == null)
			outObject = new XXPYSJK();
		out.print(outObject.toJSON());
		return;
	}else {//所有数据的相关操作
		 int authority = AuthorityIdentify.authIdentify(paraYH, "XXPYSJK");
		 if(paraOp.equals("getAll") && authority > 0) {
			String outJSON = "0";
			List<Map<String, Object> > dataList = commonService.getAllData(XXPYSJK.class, paraYear);
			if(dataList != null) 
				outJSON = List2JsonUtils.list2Json2String(dataList);
			out.print(outJSON);
		 }else if(authority == 1) {
			String field = request.getParameter("field");
			if(paraOp.equals("single")) {
				if(field.equals("update")) {
					String row = request.getParameter("row");
					if(StringUtils.isEmpty(row)) {
						out.print("-1");//请求数据为空
						response.sendError(4002);//参数为空
					}else {
						XXPYSJK JSON2Object = JSON.parseObject(row, XXPYSJK.class);
						XXPYSJKService.updateData(JSON2Object);
						out.println("1");
					}		
				}else if(field.equals("delete")) {
					String paraID = JSON.parseObject(request.getParameter("ID"), String.class);
					if(StringUtils.isEmpty(paraID)) {
						out.print("-1");//请求数据为空
						response.sendError(4002);//参数为空
					}else {
						commonService.deleteByID(XXPYSJK.class, paraID);
						out.print("1");					
					}
				}
			}else if(paraOp.equals("list")) {
				if(field.equals("delete")) {
					JSONArray jsonDeleteArray = JSONArray.fromObject((String)request.getParameter("list_rows_id"));
					commonService.deleteByIDList(XXPYSJK.class, jsonDeleteArray);
					out.print("1");
				}else if(field.equals("update")) {
					List<XXPYSJK> updateList = JSON.parseArray((String)request.getParameter("list_rows"), XXPYSJK.class);
					XXPYSJKService.updateData(updateList);
					out.println("1");
				}
			}else {
				response.sendError(4003);//参数无对应动作
			}
		}else {
			response.sendError(4004);//没有权限操作
		}
	}
%>