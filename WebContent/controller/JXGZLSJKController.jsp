<%@ page language="java" import="service.JXGZLSJKService,utils.StringUtils,bean.YH,bean.JXGZLSJK,
	java.util.List,java.util.Map,utils.List2JsonUtils,com.alibaba.fastjson.JSON, service.commonService"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	JXGZLSJKService jxgzlsjkService = new JXGZLSJKService();
	YH yh = (YH)session.getAttribute("yh");
	List<Map<String, Object> > list;
	String json;
	if(yh != null) {		
		if(StringUtils.isEmpty(op)) {
			//url参数为空直接跳转至主页
			response.sendRedirect("../index.jsp");	
		}else if(op.equals("personal")) {
			JXGZLSJK jxgzlsjk = commonService.getDataByRydm(JXGZLSJK.class, yh.getGH());
			if(jxgzlsjk == null) {
				out.print("0");//没有数据
			}else {
				out.print(jxgzlsjk.toJson());
			}
		}else if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1) {			
			if(op.equals("update")) {
				String row = request.getParameter("row");
				if(StringUtils.isEmpty(row)) {
					out.println("-1");//错误的访问方式
				}else {
					JXGZLSJK jxgzlsjk = JSON.parseObject(row, JXGZLSJK.class);
					jxgzlsjkService.updateData(jxgzlsjk);
					out.print("1");//修改成功				
				}
			}else if(op.equals("delete")) {
				String ID = request.getParameter("ID");//获得从前端传来的id
				if(StringUtils.isEmpty(ID)) {
					out.print("-1");//错误的访问方式
				}else {
					commonService.deleteByID(JXGZLSJK.class, ID);
					out.print("1");				
				}
			}else if(op.equals("getAll")){
				list = commonService.getAllData(JXGZLSJK.class);
				if(list == null) {
					out.print("0");//没有数据
				}else {
					json = List2JsonUtils.list2Json2String(list);
					out.print(json);
				}
			}
		}else {
			response.sendRedirect("../index.jsp");//登录用户非法访问，直接跳转至主页
		}
	}else {
		response.sendRedirect("../login.jsp");//非登录用户非法访问，跳转至登录页面
	}
%>