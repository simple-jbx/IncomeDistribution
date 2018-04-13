<%@ page language="java"
	import="java.util.*,service.JTHDKQSJKService,utils.StringUtils,bean.YH,bean.JTHDKQSJK,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	service.commonService, com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");//获取url参数
	YH yh = (YH)session.getAttribute("yh");
	if(yh != null) {	
		if(StringUtils.isEmpty(op)){
			//如果参数为空直接跳转至index页面
			response.sendRedirect("../index.jsp");
		}else if(op.equals("personal")) {
			
			JTHDKQSJK jthdkqsjk = (JTHDKQSJK)commonService.getDataByRydm(JTHDKQSJK.class, yh.getGH());
			if(jthdkqsjk == null) {
				out.println("1");
			}else {
				out.print(jthdkqsjk.toJson());
			}
		}else if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1){
			JTHDKQSJKService jthdkqsjkService = new JTHDKQSJKService();
			if(op.equals("getAll")) {
				//获取所有数据
				List<Map<String, Object> > list = commonService.getAllData(JTHDKQSJK.class);
				String json = List2JsonUtils.list2Json2String(list);
				out.println(json);				
			}else if(op.equals("update")) {
				String row = request.getParameter("row");
				if(StringUtils.isEmpty(row)) {
					out.println("-1");//错误的访问方式
				}else {
					JTHDKQSJK jthdkqsjk = JSON.parseObject(row, JTHDKQSJK.class);
					jthdkqsjkService.updateData(jthdkqsjk);
					out.print("0");//修改成功			
				}
			}else if(op.equals("delete")) {
				String iD = request.getParameter("ID");//获得从前端传来的ID
				if(StringUtils.isEmpty(iD)) {
					out.println("-1");//错误的访问方式
				}else {
					commonService.deleteByID(JTHDKQSJK.class, iD);
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