<%@ page language="java"
	import="java.util.*,service.ZGSJXSService,utils.StringUtils,bean.*,java.util.List,java.util.Map,utils.List2JsonUtils, java.math.BigDecimal,
	com.alibaba.fastjson.JSON"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	YH yh = (YH)session.getAttribute("yh");
	//System.out.print(yh);
	List<Map<String, Object> > list = null;
	if(yh != null) {
		if(StringUtils.isEmpty(op)) {
			response.sendRedirect("../index.jsp");
		}else if(op.equals("personal")) {
			ZGSJXS zgsjxs = ZGSJXSService.getData(yh.getGH());
			if(zgsjxs == null) {
				out.print("0");//无数据
			}else {
				out.print(zgsjxs.toJson());
			}
		}else if((yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1)) {
			ZGSJXSService zgsjxsService = new ZGSJXSService();
			if(op.equals("getAll")) {
				list = zgsjxsService.getData();
				if(list == null) {
					out.print("0");//无数据
				}else {
					String json = List2JsonUtils.list2Json2String(list);
					out.print(json);						
				}
			}else if(op.equals("update")) {
				String row = request.getParameter("row");
				if(StringUtils.isEmpty(row)) {
					out.print("0");//
				}else {
					ZGSJXS zgsjxs = JSON.parseObject(row, ZGSJXS.class);
					zgsjxsService.updateData(zgsjxs);
					out.println("1");						
				}
			}else if(op.equals("delete")) {
				String ID = request.getParameter("ID");//获得从前端传来的ID
				if(StringUtils.isEmpty(ID)) {
					out.print("0");
				}else {
					zgsjxsService.deleteByID(ID);
					out.print("1");//删除成功
				}
			}
		}else {
			response.sendRedirect("../index.jsp");
			//已登录用户非法操作
		}			
	}else {
		response.sendRedirect("../login.jsp");
		//未登录用户非法访问
	}
%>