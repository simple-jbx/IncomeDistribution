<%@ page language="java" import="service.ZYGLService,utils.StringUtils,bean.YH,bean.ZY,
	java.util.List,java.util.Map,utils.List2JsonUtils,com.alibaba.fastjson.JSON,service.commonService"
	pageEncoding="UTF-8"%>
<%
	String op  = request.getParameter("op");
	ZYGLService zyglService = new ZYGLService();
	YH yh = (YH)session.getAttribute("yh");
	List<Map<String, Object> > list;
	String json;
	if(yh != null) {		
		if(StringUtils.isEmpty(op)) {
			//url参数为空直接跳转至主页
			response.sendRedirect("../index.jsp");	
		}else if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1) {			
			if(op.equals("update")) {
				String row = request.getParameter("row");
				//System.out.print(row);
				if(StringUtils.isEmpty(row)) {
					out.println("-1");//错误的访问方式
				}else {
					ZY zygl= JSON.parseObject(row, ZY.class);
					zyglService.updateData(zygl);
					out.print("1");//修改成功				
				}
			}else if(op.equals("delete")) {
				String ID = request.getParameter("ID");//获得从前端传来的id
				if(StringUtils.isEmpty(ID)) {
					out.print("-1");//错误的访问方式
				}else {
					commonService.deleteByID(YH.class, ID);
					out.print("1");				
				}
			}else if(op.equals("getAll")){
				list = commonService.getAllData(ZY.class);
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