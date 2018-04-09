<%@ page language="java"
	import="java.util.*,service.ZCService,utils.StringUtils,bean.YH,bean.ZC,java.util.List,
	java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	ZCService zcService = new ZCService();
	YH yh = (YH)session.getAttribute("yh");
	List<Map<String, Object> > list = null;
	String json = "";
	if(yh != null) {	
		if(StringUtils.isEmpty(op)) {
			response.sendRedirect("../index.jsp");
		}else if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1){			
			if(op.equals("getAll")) {
				list = zcService.getData();
				json = List2JsonUtils.list2Json2String(list);
				out.println(json);	
			}else if(op.equals("update")) {
				String row = request.getParameter("row");
				ZC zc = JSON.parseObject(row, ZC.class);
				zcService.updateData(zc);
				list = zcService.getData();
				json = List2JsonUtils.list2Json2String(list);
				out.println(json);	
				//out.print("0");//修改成功
			}else if(op.equals("delete")) {
				String ID = request.getParameter("ID");//获得从前端传来的ID
				zcService.deleteByID(ID);
				out.print("1");//删除成功
			}
		}else {
			//非权限用户访问
			response.sendRedirect("../index.jsp");
		}
	}else {
		response.sendRedirect("../login.jsp");
		//未登录用户非法访问
	}
%>