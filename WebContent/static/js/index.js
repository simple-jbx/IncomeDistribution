	
	 BUI.use('common/main',function(){
    	$.ajax({
    		type:'post',
    		url:ajaxURL,
    		cache:false,
    		dataType:"json",
    		success:function(config){
    			new PageUtil.MainPage({
    		        modulesConfig : config
    		    });
    		}
    	});
    });
	
	function logout() {
		if(window.confirm("是否确认退出?")) {
			$.ajax({
				type:"post",//请求方式
					url:basePath+"/logoutController.do",//请求地址
					error:function(){//如果出错了，将事件重新绑定
						window.location.href = "login.jsp";
					},
					success:function(){ //返回成功执行回调函数。
						window.location.href = "login.jsp";
					}
			})
		}
	}

	var winopen;
	var timer;
	var status;
	
	function IfWindowClosed() {
        if (winopen.closed == true)          
        {
      	 var status = JSON.parse(localStorage.getItem('status'));
      	 if(status != null ) {
      		 if(status.isChange == 1) {
      			 $.ajax({
      				 type:"post",//请求方式
      				 url:basePath+"/logoutController.do",//请求地址
      				 error:function(){//如果出错了，将事件重新绑定
      					 window.location.href = "login.jsp";
      				 },
      				 success:function(){ //返回成功执行回调函数。
      					 window.location.href = "login.jsp";
      				 }
      			 })
      		 }else if(status.isChange == -2) {
      			 window.location.href = "login.jsp";
      		 }
      		 localStorage.removeItem('status');      		 
      	 }
         //关闭监听器
         window.clearInterval(timer);
        }
   }
   
   function changePassword() {
  	winopen = window.open(basePath+"/common/changePassword.jsp","","width=450px,height=200,top=200,left=300,status=no,help=no");
  	timer = window.setInterval("IfWindowClosed()", 200);
   }