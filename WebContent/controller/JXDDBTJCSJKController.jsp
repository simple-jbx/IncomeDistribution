<%@ page language="java"
	import="java.util.*,service.JXDDBTJCSJKService,utils.StringUtils,bean.YH,bean.JXDDBTJCSJK,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");//获取url参数
	YH yh = (YH)session.getAttribute("yh");
	if(yh != null) {	
		if(StringUtils.isEmpty(op)){
			//如果参数为空直接跳转至index页面
			response.sendRedirect("../index.jsp");
		}else if(op.equals("personal")) {
			JXDDBTJCSJK jxddbtjcsjk = JXDDBTJCSJKService.getData(yh.getGH());
			if(jxddbtjcsjk == null) {
				out.println("0");
			}else {
				out.print(jxddbtjcsjk.toJson());
			}
		}else if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1){
			JXDDBTJCSJKService jxddbtjcsjkService = new JXDDBTJCSJKService();
			if(op.equals("getAll")) {
				//获取所有数据
				List<Map<String, Object> > list = jxddbtjcsjkService.getData();
				String json = List2JsonUtils.list2Json2String(list);
				out.println(json);				
			}else if(op.equals("update")) {
				String row = request.getParameter("row");
				if(StringUtils.isEmpty(row)) {
					out.println("-1");//错误的访问方式
				}else {
					JXDDBTJCSJK jxddbtjcsjk = JSON.parseObject(row, JXDDBTJCSJK.class);
					jxddbtjcsjkService.updateData(jxddbtjcsjk);
					out.print("1");//修改成功			
				}
			}else if(op.equals("delete")) {
				String ID = request.getParameter("ID");//获得从前端传来的ID
				if(StringUtils.isEmpty(ID)) {
					out.println("-1");//错误的访问方式
				}else {
					jxddbtjcsjkService.deleteByID(ID);
					out.print("1");
				}	
			}		
		}else {
			response.sendRedirect("../index.jsp");
		}
	}else {
		response.sendRedirect("../login.jsp");
	}
%>