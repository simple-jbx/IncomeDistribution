<%@ page language="java" import="java.util.*,bean.YH,service.YHJSService,service.JSZYService" 
pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="common/header.jsp"%>
<html>
 <head>
  <title>陕西师范大学体育学院 年终收入分配系统</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link href="static/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
   <link href="static/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
   <link href="static/assets/css/main-min.css" rel="stylesheet" type="text/css" />
   <script type="text/javascript" src="static/assets/js/jquery-1.8.1.min.js"></script>
   <script type="text/javascript" src="static/assets/js/bui-min.js"></script>
   <script type="text/javascript" src="static/assets/js/config.js"></script>
 </head>
    
 <body>
 <script>
   <%
    YH yh = (YH)session.getAttribute("yh");
    if(yh != null){
	    YHJSService yhjsService = new YHJSService();
	    JSZYService jszyService = new JSZYService();
	    List<Map<String, Object> > listYHJS;
	    List<Map<String, Object> > listZY = new ArrayList<Map<String, Object> >();
		listYHJS = yhjsService.getJSID(yh.getID());
			for(Map<String, Object> m : listYHJS) {
				listZY.addAll(jszyService.getAllZY(m.get("jsid").toString()));
			pageContext.setAttribute("listZY", listZY);     	
    		}
	}
	%>
</script>

  <div class="header">  
      <div class="dl-title">
        <a href="http://tyxy.snnu.edu.cn/" title="陕西师范大学体育学院" target="_blank">
          <span class="lp-title-port">陕西师范大学</span><span class="dl-title-text">体育学院</span>
        </a>
        <a href="">年终收入分配管理系统</a>
      </div>

    <div class="dl-log">当前用户:${yh.getGH()}(${yh.getXM()})<span class="dl-log-user"></span><a href="javascript:logout()" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
  </div>
   <div class="content">
    <div class="dl-main-nav">
      <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
      <ul id="J_Nav"  class="nav-list ks-clear">
        <!--  <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">我需留意</div></li>-->
        <li class="nav-item"><div class="nav-item-inner nav-supplier">个人管理</div></li>
        <c:if test="${yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1}">
        	<li class="nav-item"><div class="nav-item-inner nav-order">后台管理</div></li>
      	</c:if>
      </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
   </div>

  <script>
  
    BUI.use('common/main',function(){
      var config = [{
          //id:'main', 
          //homePage : 'gl',
          //menu:[{
              //text:'我需留意',
              //items:[
                //{id:'gl',text:'概览',href:'main/code.html',closeable : false},
                //{id:'main-menu',text:'查看消息',href:'backstage/BGHZ.jsp'},
              //]
            //}]
          //},{
            id:'form',
            homePage : '',
            menu:[//{
               // text:'信息管理',
                //items:[
                  //{id:'code',text:'基本信息',href:''},
                  //]
              //},{
               {
                text:'年终收入分配信息',
                items:[
                	<c:forEach items="${listZY}" var="item">
                	  <c:if test="${item.zygroup == 1}">
               			 {id:"${item.zyid}",text:"${item.zynote}",href:'backstage/'+'${item.zyname}'+"?op=personal"},
               	  	  </c:if>
				    </c:forEach>  
                ]
              }
      		]
          },
          {
          <c:if test= "${!empty sessionScope.yh}">        
          <c:if test="${yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1}">  
            id:'htgl',
            menu:[{
                text:'通知管理',
                items:[
                	
                ]
              },{
                  text:'用户管理',
                  items:[
                	  <c:forEach items="${listZY}" var="item">
                  	  <c:if test="${item.zygroup == 2}">
                 			 {id:"${item.zyid}",text:"${item.zynote}",href:'backstage/'+'${item.zyname}'},
                 	  </c:if>
  				      </c:forEach>  	
                  ]
                },{
                text:'分配规则管理',
                items:[
                    <c:forEach items="${listZY}" var="item">
                    	<c:if test="${item.zygroup == 0}">
                   			 {id:"${item.zyid}",text:"${item.zynote}",href:'backstage/'+'${item.zyname}'},
                   		</c:if>
					</c:forEach>	
                ]
              },{
                  text:'基础数据管理',
                  items:[
                      <c:forEach items="${listZY}" var="item">
                      	<c:if test="${item.zygroup == 1}">
                     			 {id:"${item.zyid}",text:"${item.zynote}",href:'backstage/'+'${item.zyname}'},
                     	</c:if>
  					</c:forEach>	
                  ]
                }
               
            ]
          </c:if>
          </c:if>
          }
          ];
      new PageUtil.MainPage({
        modulesConfig : config
      });
    });
  </script>

   <script>
  	function logout() {
	  if(window.confirm("是否确认退出?")) {
		  $.ajax({
				type:"post",//请求方式
				url:"controller/logoutController.jsp",//请求地址
				error:function(){//如果出错了，将事件重新绑定
					alert("Error!");
				},
		 		success:function(){ //返回成功执行回调函数。
		 			window.location.href = "login.jsp";
		 		}
		  })
  	}
  }
  </script>
 </body>

</html>
