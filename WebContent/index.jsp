<%@ page language="java" import="java.util.*,bean.YH,service.YHJSService,service.JSZYService" 
pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/common/header.jsp"%>
<html lang="zh-CN">
 <head>
 <meta charset="UTF-8">
  <title>个人年终收入分配系统</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link href="${basePath}/static/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
   <link href="${basePath}/static/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
   <link href="${basePath}/static/assets/css/main-min.css" rel="stylesheet" type="text/css" />
   <script type="text/javascript" src="${basePath}/static/assets/js/jquery-1.8.1.min.js"></script>
   <script type="text/javascript" src="${basePath}/static/assets/js/bui-min.js"></script>
   <script type="text/javascript" src="${basePath}/static/assets/js/config.js"></script>
 </head>
    
 <body>
	<%
    YH currentYH = (YH)session.getAttribute("currentYH");
    String basePath = (String)session.getAttribute("basePath");
    Boolean backstage = false;
    String defaultMenuURL = basePath+"/common/menuJSON/default.json";
    String getMenuURL = basePath+"/common/menuJSON/";
    if(currentYH != null){
    	List<Map<String, Object> > jsList = YHJSService.getAllJSByRYDM(currentYH);
		for(Map<String, Object> obj : jsList) {
			if(obj.get("jsid").equals("41c802a59e17497fae6e81c0e897cf13") || 
					obj.get("jsid").equals("9840eff4e34f41019ffaf72afb14749e")) {
				backstage = true;
				getMenuURL += "9840eff4e34f41019ffaf72afb14749e.json";
				break;
			}
		}
		if(!getMenuURL.endsWith("json"))
			getMenuURL = defaultMenuURL;
    }else {
    	currentYH = new YH();
    }
%>

  <div class="header">  
      <div class="dl-title">
        <a href="">年终收入分配管理系统 V1.0</a>
      </div>

    <div class="dl-log">当前用户:<span class="dl-log-user"><%=currentYH.getRYDM()%>(<%=currentYH.getXM()%>)</span>
    <span class="dl-log-user"><a href="javascript:changePassword()" title="修改密码" class="dl-log-quit">[修改密码]</a></span>
    <span class="dl-log-user"> <a href="javascript:logout()" title="退出系统" class="dl-log-quit">[退出]</a></span>
    </div>
  </div>
   <div class="content">
    <div class="dl-main-nav">
      <!-- 顶部导航栏 -->
      <ul id="J_Nav"  class="nav-list ks-clear">
        <li class="nav-item"><div class="nav-item-inner nav-supplier">个人管理</div></li>
        <li class="nav-item"><div class="nav-item-inner nav-order">后台管理</div></li>
      </ul>
    </div>
    
    <!-- 左侧菜单 -->
    <ul id="J_NavContent" class="dl-tab-conten">
    </ul>
   </div>

  <script>
  
    BUI.use('common/main',function(){
    	$.ajax({
    		type:'post',
    		url:"<%=getMenuURL%>?208081202",
    		cache:false,
    		dataType:"json",
    		success:function(config){
    			new PageUtil.MainPage({
    		        modulesConfig : config
    		    });
    		}
    	});
    });
  </script>

   <script>
  	function logout() {
	  if(window.confirm("是否确认退出?")) {
		  $.ajax({
				type:"post",//请求方式
				url:"${basePath}/logoutController.do",//请求地址
				error:function(){//如果出错了，将事件重新绑定
		 			window.location.href = "login.jsp";
				},
		 		success:function(){ //返回成功执行回调函数。
		 			window.location.href = "login.jsp";
		 		}
		  })
  	}
  }
  </script>
  
   <script>
  	function changePassword() {
  		window.open("${basePath}/common/changePassword.jsp","","width=400px,height=180,top=200,left=300,status=no,help=no");
  }
  </script>
 </body>

</html>
