<%@ page language="java" pageEncoding="UTF-8" import="bean.YH"%>
<%@include file="../common/header.jsp"%>

<html>
<!-- 在岗时间系数规则-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../static/js/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="../static/js/bootstrap/css/bootstrap-table.min.css"
	rel="stylesheet" type="text/css">
<link href="../static/js/bootstrap/css/bootstrap-editable.css"
	rel="stylesheet" type="text/css">
<script src="../static/js/jQuery.js"></script>
<script src="../static/js/bootstrap/js/bootstrap.min.js"></script>
<script src="../static/js/bootstrap/js/bootstrap-table.min.js"></script>
<script src="../static/js/bootstrap/js/bootstrap-editable.js"></script>
<script src="../static/js/bootstrap/js/bootstrap-table-editable.js"></script>
<title>在岗时间系数规则</title>
</head>
<body>
	<table id="table"></table>
	
	<!-- 新增按钮 -->
    <div id="toolbar" class="btn-group">
	<button id="btn_add" type="button" class="btn btn-default">
	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
	</button>
	</div>
			
	<!-- 新增按钮点击事件 -->
	<script>
		$("#btn_add").click(function () {
				$('#table').bootstrapTable('insertRow', {
	   	            index: 0,
		            row: {gh:'-',xm:'-'}
				})
		})
	</script>
	
	<script>
	//操作栏的格式化 
	$(function(){
		$('#table').bootstrapTable({
		ajax : function (request) {
	        $.ajax({
	            type : "GET",
	            url : "../controller/QTGZController.jsp",
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
			sortName: 'id',
			sortOrder: "asc",
			pageSize: 10,
			pageNumber: 1,
			uniqueId: "id", //每一行的唯一标识，一般为主键列
			striped: true,  
            cache: false,
            buttonsAlign:"right",  //按钮位置  
			columns: [{
				field: "state",
				checkbox:true,
				visible: true
			},{
				field: 'id',
				visible: false
			},{
				field: 'rowid',
				title: '序号',
				formatter: function(value, row, index) {
					row.rowid = index;
					return index+1;
				}			
			},{
				field: 'xm',
				title: '项目',
				switchable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline'
				}
			}, {
				field: 'je',
				title: '金额',
				switchable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline',
                    validate: function (value) {  
                        if ($.trim(value) == '') {  
                            return '金额不能为空!';  
                        }  
                    } 
				}
			}, {
				field: 'fl',
				title: '分类',
				switchable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline'
				}
			},{
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
		                    url: "../controller/QTGZController.jsp?op=update",
		                    data: {"row": JSON.stringify(row)},
		                    dataType: 'JSON',
		                    success: function (data, status) {
		                        if (status == "success") {
		                            alert('修改成功');
		                            $('#table').bootstrapTable('updateRow',{
			                            index:row.rowid,
			                            row:row
			                            }
			                        )
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