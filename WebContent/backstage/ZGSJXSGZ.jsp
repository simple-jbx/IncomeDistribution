<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>

<html>
<!-- 在岗时间系数规则-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../static/js/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="../static/js/bootstrap/css/bootstrap-table.min.css"
	rel="stylesheet" type="text/css">
<link href="../static/js/bootstrap/css/bootstrap-table.css"
	rel="stylesheet" type="text/css">
<link href="../static/js/bootstrap/css/bootstrap-editable.css"
	rel="stylesheet" type="text/css">
<link href="../static/js/bootstrap/css/bootstrap-fileinput.min.css"
	rel="stylesheet" type="text/css">
<script src="../static/js/jQuery.js"></script>
<script src="../static/js/table.js"></script>
<script src="../static/js/bootstrap/js/bootstrap.min.js"></script>
<script src="../static/js/bootstrap/js/bootstrap-table.min.js"></script>
<script src="../static/js/bootstrap/js/bootstrap-table-zh-CN.js"></script>
<script src="../static/js/bootstrap/js/bootstrap-editable.js"></script>
<script src="../static/js/bootstrap/js/bootstrap-table-editable.js"></script>
<script src="../static/js/bootstrap/js/bootstrap-fileinput.min.js"></script>
<script src="../static/js/bootstrap/js/bootstarp-fileinout-zh-CN.js"></script>
<script src="../static/js/bootstrap/js/bootstrap-table-export.js"></script>
<script src="../static/js/tableExport/libs/FileSaver/FileSaver.min.js"></script>
<script src="../static/js/tableExport/libs/jsPDF/jspdf.min.js"></script>
<script
	src="../static/js/tableExport/libs/jsPDF-AutoTable/jspdf.plugin.autotable.js"></script>
<script src="../static/js/tableExport/libs/pdfmake/pdfmake.min.js"></script>
<script src="../static/js/tableExport/libs/js-xlsx/xlsx.core.min.js"></script>
<script src="../static/js/tableExport/libs/pdfmake/mirza_fonts.js"></script>
<script src="../static/js/tableExport/libs/pdfmake/vfs_fonts.js"></script>
<script src="../static/js/tableExport/tableExport.js"></script>
<title>在岗时间系数规则</title>
</head>
<body>
	<div id="toolbar" class="btn-group">
		
	</div>
	<table id="table">
	</table>
	<script>
	//操作栏的格式化 
	$(function(){
		$('#table').bootstrapTable({
		ajax : function (request) {
	        $.ajax({
	            type : "GET",
	            url : "../controller/ZGSJXSGZController.jsp",
				contentType: "application/json;charset=utf-8",
				dataType:"json",
				data:'',
				jsonp:'callback',
	            success : function (msg) {	
					request.success({
	                    row : msg
	                });
	                $('#table').bootstrapTable('load', msg);
	            },
				error:function(){
					alert("载入出错");
				}
	        });
		},
	
			
			toolbar:'#toolbar',
			singleSelect:true,
			clickToSelect:true,	
			editable: true,
			sortable: true, 
			sortName: 'zgys',
			sortOrder: "asc",
			pageSize: 10,
			pageNumber: 1,
			//pageList: "[10, 15, 20, 50]",
			//showToggle: true,
			showRefresh: true,
			//showColumns: true, //是否显示内容下拉框
			//showPaginationSwitch: true,//显示数据条数选择框 
			//search: true, //搜索框
			pagination:true, //底部显示分页条
			strictSearch: false, //模糊搜索
			uniqueId: "id", //每一行的唯一标识，一般为主键列
			striped: true,  
            cache: false,
            showExport: true,  //是否显示导出按钮  
            buttonsAlign:"right",  //按钮位置  
            exportDataType:'all',
            exportTypes:['excel', 'xlsx'],  //导出文件类型
			columns: [{
				field: "state",
				checkbox:true,
				visible: false
			},{
				field: 'id',
				visible: false
			},{
				field: 'zgys',
				title: '在岗月数',
				switchable: true,
				sortable: true,
			}, {
				field: 'zgxs',
				title: '在岗系数',
				switchable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline',
                    validate: function (value) {  
                        if ($.trim(value) == '') {  
                            return '在岗系数不能为空!';  
                        }  
                    } 
				}
			}, {
				field: 'cz',
				title: '操作',
				//formatter:actionFormatter,
				width: 100,
				visible: true,
				formatter: function (value, row, index) {  
		              	   var s = '<button class = "save" href="javascript:void(0)">保存</button>';  
		                   return s;  
		        },  
		        events: 'operateEvents' 
			}]
	});
		 window.operateEvents = {
				 'click .save': function (e, value, row, index) {
					 $.ajax({
		                    type: "post",
		                    url: "../controller/ZGSJXSGZController.jsp?op=update",
		                    data: {"row": JSON.stringify(row)},
		                    dataType: 'JSON',
		                    success: function (data, status) {
		                        if (status == "success") {
		                            alert('修改成功');
		                            $('#table').bootstrapTable('load', data);
		                        }
		                    },
		                    error: function () {
		                        alert('修改失败');
		                        window.location.reload();
		                    },
		                });
				 }
	}
	})
	</script>
</body>
</html>