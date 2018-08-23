	$.ajaxSetup({
		contentType: "application/x-www-form-urlencoded;charset=utf-8",
		complete: function(XMLHttpRequest, textStatus) {
		},
		statusCode: {
			4000: function() {
				alert('登陆已失效，请重新登陆！');
			},
			
			4001: function() {
				alert('非法访问！');
			},
			
			4002: function() {
				alert('请求有误，请重试！');
			},
			
			4003: function() {
				alert('请求无效，请重试！');
			},
			
			4004: function() {
				alert('您没有权限操作，请联系系统管理员解决！');
			},
			      
			500: function() {
				alert('服务器有误');
			}
		}
	});