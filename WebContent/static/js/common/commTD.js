	function getDataByYear(year) {
		$.ajax({
			type : "post",
			url : getURL,
			data : {
			"op" : "getAll",
			"year" : year
			},
			dataType:"json",
			success : function (msg) {								
				jsonData = msg;
			    $('#table').bootstrapTable('load', msg);
			},
			error:function(){
				alert("载入出错");
			}
		});
	}
	
	getDataByYear(dataYear);
	
	$(document).ready(function () {
	    $("#selectYear").bind("change",function(){
	    	getDataByYear($(this).val());
	    	});
	  });