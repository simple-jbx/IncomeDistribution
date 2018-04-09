<%@ page language="java"
	import="java.util.*,service.*,utils.StringUtils,bean.YH,utils.List2JsonUtils"
	pageEncoding="UTF-8"%>
<%

	//获取客户端传递过来参数
	String accountNo = request.getParameter("accountNo");
	String password = request.getParameter("password");
	//System.out.println("accountNo " + accountNo);
	//System.out.println(password);
	//如果用户名和密码不为空
	if(StringUtils.isEmpty(accountNo) || StringUtils.isEmpty(password)){
		out.print("-1");//错误码-1 :   用户名和密码不能为空！
	}else{
		//初始化LoginService
		LoginService loginService = new LoginService();
		//接下来判断用户名是否存在
		YH yh = loginService.getYH(accountNo);
		if(yh == null) {
			out.print("-2");//错误码 -2 用户名为空
		}else {
			YHService yhService = new YHService();
			YHJSService yhjsService = new YHJSService();
			ZHGLZBSXService zhglzbsxService = new ZHGLZBSXService();
			List<Map<String, Object> > listJS = yhjsService.getJSByYhid(yh.getID());
			//System.out.println(listJS);
			int jsgroup;
			session.setAttribute("yh", yh);
			//System.out.print(yh);
			out.print("1");//正确返回 1
			for(int i = 0; i < listJS.size(); i++) {
				//System.out.println(listJS.get(i));
				jsgroup = (int)listJS.get(i).get("jsgroup");
				//System.out.println(jsgroup);
				if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1) {
					List<Map<String, Object> > list = yhService.getData();
					String json = List2JsonUtils.list2Json2String(list);
					session.setAttribute("jsonYH", json);
					//System.out.println(json);
					list = zhglzbsxService.getData();
					session.setAttribute("listZHGLZBSX", list);
					break;
				}
			}
		}
	}
	
%>