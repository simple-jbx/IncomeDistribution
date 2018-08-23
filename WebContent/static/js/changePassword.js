	function hideHint() {
			$("#h").hide();
		}
		
		function showHint() {
			$("#h").show();
		}
	
		function inputOldPassOnblur() {
			var inputOldPass = $('#inputOldPass').val();
			if(!inputOldPass) {
				document.getElementById("hint").innerHTML = "原密码不能为空！";
				setTimeout("hideHint()",5000);
			}		
		}
		
		function inputNewPassOnblur() {
			var myReg = /^[^\u4e00-\u9fa5]+$/;
			var inputNewPass = $('#inputNewPass').val();
			if(!inputNewPass) {
				document.getElementById("hint").innerHTML = "新密码不能为空！";
				showHint();
				setTimeout("hideHint()",5000);
				return;
			}else if(!myReg.test(inputNewPass)){
				document.getElementById("hint").innerHTML = "密码中不能含有中文或特殊字符！";
				showHint();
				setTimeout("hideHint()",5000);
				return;
			}else if(inputNewPass.length < 6 || inputNewPass.length > 20) {
				document.getElementById("hint").innerHTML = "密码长度应为6-20位！";
				showHint();
				setTimeout("hideHint()",5000);
				return;
			}
		}
		
		function inputConfPassOnblur() {
			var inputNewPass = $('#inputNewPass').val();
			var inputConfPass = $('#inputConfPass').val();
			if(!inputConfPass) {
				document.getElementById("hint").innerHTML = "确认密码不能为空！";
				showHint();
				setTimeout("hideHint()",5000);
				return;
			}else if(inputNewPass != inputConfPass) {
				document.getElementById("hint").innerHTML = "两次输入密码不一致！";
				showHint();
				setTimeout("hideHint()",5000);
				return;
			}
		}
		
		function inputOldPassOnfocus() {
		}
		
		function inputNewPassOnfocus() {
		}
		
		function inputConfPassOnfocus() {
		}
		
		function check() {
			var inputOldPass = $('#inputOldPass').val();
			var inputNewPass = $('#inputNewPass').val();
			var inputConfPass = $('#inputConfPass').val();
			var myReg = /^[\u4e00-\u9fa5]+$/;
			if(!inputOldPass) {
				document.getElementById("hint").innerHTML = "原密码不能为空！";
				showHint();
				return false;
			}
			if(!inputNewPass) {
				document.getElementById("hint").innerHTML = "请输入新密码！";
				showHint();
				return false;
			}
			if(!inputConfPass) {
				document.getElementById("hint").innerHTML = "请输入确认密码！";
				showHint();
				return false;
			}
			if(myReg.test(inputNewPass)){
				document.getElementById("hint").innerHTML = "密码中不能含有中文或特殊字符！";
				showHint();
				return false;
			}
			if(inputNewPass.length < 6 || inputNewPass.length > 20) {
				document.getElementById("hint").innerHTML = "密码长度应为6-20位！";
				showHint();
				return false;
			}
			if(inputNewPass != inputConfPass) {
				document.getElementById("hint").innerHTML = "两次输入密码不一致！";
				showHint();
				return false;
			}
			
			var isChange;
			
			$.ajax({
				type:"post",//请求方式
				async:false,
				data:{
					"inputOldPass" : inputOldPass,
					"inputNewPass" : inputNewPass
				},
				url:"/changePassController.do",//请求地址
				success:function(data){ //返回成功执行回调函数。
					isChange = data;
				},
				error:function(){//如果出错了，将事件重新绑定
					alert("系统异常！");
					window.close();
				}
			});	
			
			if(isChange == 1) {
				 localStorage.setItem('status',JSON.stringify({isChange:'1'}));	
				 alert("密码修改成功，请重新登录！");
				window.close();
			} else if(isChange = -1){
				 localStorage.setItem('status',JSON.stringify({isChange:'-1'}));	
				 alert("原密码错误！");
			}
			return;
		}