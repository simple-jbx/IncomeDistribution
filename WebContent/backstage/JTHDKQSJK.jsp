<%@ page language="java" pageEncoding="UTF-8" import="bean.YH,service.YHService,java.util.Calendar,java.util.List,
java.util.Map"%>
<!-- 动态包含 -->
<jsp:include page="../common/header.jsp" flush="true"/>

<html>
<!-- 集体活动考勤-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${basePath}/static/js/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="${basePath}/static/js/bootstrap/css/bootstrap-table.min.css"
	rel="stylesheet" type="text/css">
<link href="${basePath}/static/js/bootstrap/css/bootstrap-editable.css" rel="stylesheet" type="text/css">

<script src="${basePath}/static/js/jQuery.js"></script>
<script src="${basePath}/static/js/bootstrap/js/bootstrap.min.js"></script>
<script src="${basePath}/static/js/bootstrap/js/bootstrap-table.min.js"></script>
<script src="${basePath}/static/js/bootstrap/js/bootstrap-table-zh-CN.js"></script>  
<script src="${basePath}/static/js/bootstrap/js/bootstrap-editable.js"></script>
<script src="${basePath}/static/js/bootstrap/js/bootstrap-table-editable.js"></script>
<script src="${basePath}/static/js/bootstrap/js/bootstrap-table-export.js"></script>
<script src="${basePath}/static/js/tableExport/libs/js-xlsx/xlsx.core.min.js"></script>
<script src="${basePath}/static/js/tableExport/tableExport.js"></script>
<title>集体活动考勤</title>
</head>
<% 
	List<Map<String, Object> > yhList = YHService.getALLYH();
	request.setAttribute("jsonListYH", yhList);
%>
<body>
	
	<!-- bootstrap table -->
	<table id="table"></table> 
		<!-- 新增按钮 -->
		<div id="toolbar" class="btn-group">
			<select class="btn btn-default" id="selectYear">
	    		<% 
	  			Calendar date = Calendar.getInstance();
	       		int year = date.get(Calendar.YEAR);
	  			for(int i = year-4; i < year; i++) {
	 			%>
	 		<option value="<%=i%>"><%=i%>年</option>
	 			<% 
	  				}
	  			%>
	  		<option value="<%=year%>"  selected><%=year%>年</option>	
	    	</select>
	  		
	  	
			<button id="btn_add" type="button" class="btn btn-default hidden">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_upload" type="button" class="btn btn-default hidden">
				<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>上传		
			</button>
			<button id="btn_list_save" type="button" class="btn btn-default hidden">
				<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>批量保存	
			</button>
			<button id="btn_list_delete" type="button" class="btn btn-default hidden">
				<span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>批量删除		
			</button>
			<button id="btn_edit" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>编辑
			</button>
	  		

		</div>
		<script type="text/javascript">
			var basePath = "${basePath}";
			var jsonData = null;
			var jsonListYH = "${jsonListYH}";
			var jsonWGWD = null;
			var jsonGRSJ = null;
		</script>
		<script type="text/javascript" charset="UTF-8" src="${basePath}/static/js/backstage/JTHDKQSJK.js?v=2018081201"></script>
	
	
	<script>	
	//操作栏的格式化 
	$(function(){
		$('#table').bootstrapTable({
		ajax : function (request) {
	        $.ajax({
	            type : "post",
	            url : '${basePath}/controller/JTHDKQSJKController.jsp',
	            data:{
	            	op : 'getAll',
	            	year : 'All'
	            },
				dataType:"json",
	            success : function (msg) {	
					request.success({
	                    row : msg
	                });
					jsonData = msg;
	                $('#table').bootstrapTable('load', msg);
	            },
				error:function(){
					alert("载入出错");
				}
	        });
		},
	
		toolbar:'#toolbar',
		singleSelect:false,
		clickToSelect:true,	
		editable: false,
		sortable: true, 
		sortName: 'id',
		sortOrder: "asc",
		pageSize: 10,
		pageNumber: 1,
		pageList: "[10, 20, 50, All]",
		showToggle: true,
		search: true, //搜索框
		pagination:true, //底部显示分页条
		escape:true,//转义HTML字符串
		paginationVAlign:"both",
		strictSearch: false, //模糊搜索
		uniqueId: "id", //每一行的唯一标识，一般为主键列
		striped: true,  
        cache: false,
        showExport: true,  //是否显示导出按钮  
        buttonsAlign:"right",  //按钮位置  
        exportDataType:'all',
        exportTypes:['excel', 'xlsx'],  //导出文件类型
		columns: [
		{
			field: 'rowid',
			title: '序号',
			formatter: function(value, row, index) {
				row.rowid = index;
				return index+1;
			}			
		},{
			field: 'rydm',
			title: '人员代码'
		},{
			field: 'xm',
			title: '姓名'
		},{
			field: 'wgwd',
			title: '无故未到'			
		},{
			field: 'grsj',
			title: '个人事假'
		},{
			field: 'jey',
			title: '金额1'
		},{
			field: 'jee',
			title: '金额2'
		},{
			field: 'hjje',
			title: '合计金额'
		},{
			field: 'nd',
			title: '年度'
		}]
	})
	})
	</script>
</body>
</html>