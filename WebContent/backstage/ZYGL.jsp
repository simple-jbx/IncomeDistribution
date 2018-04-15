<%@ page language="java" pageEncoding="UTF-8" import="bean.YH"%>
<%@include file="../common/header.jsp"%>
<html>
<!-- 资源管理   -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../static/js/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="../static/js/bootstrap/css/bootstrap-table.min.css"
	rel="stylesheet" type="text/css">
<script src="../static/js/jQuery.js"></script>
<script src="../static/js/bootstrap/js/bootstrap.min.js"></script>
<script src="../static/js/bootstrap/js/bootstrap-table.min.js"></script>
<script src="../static/js/bootstrap/js/bootstrap-table-zh-CN.js"></script>
<script>
		<%
		    String url = "";
			String op = request.getParameter("op");
			if(op == null || op == ""){
				op = "getAll";				
				url = "../controller/ZYGLController.jsp?op=getAll";
			}
			else if(op.equals("personal"))
				url = "../controller/ZYGLController.jsp?op=personal";
			//System.out.println(url);
			pageContext.setAttribute("op", op);
		%>
</script>

<c:if test= "${!empty sessionScope.yh}">   
   <c:if test="${op == 'getAll'}">           
   <c:if test="${yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1}">  
    <link href="../static/js/bootstrap/css/bootstrap-editable.css"
	rel="stylesheet" type="text/css">
	<link href="../static/js/bootstrap/css/bootstrap-fileinput.min.css"
	rel="stylesheet" type="text/css">
	<script src="../static/js/bootstrap/js/bootstrap-editable.js"></script>
	<script src="../static/js/bootstrap/js/bootstrap-table-editable.js"></script>
	<script src="../static/js/bootstrap/js/bootstrap-fileinput.min.js"></script>
	<script src="../static/js/bootstrap/js/bootstarp-fileinout-zh-CN.js"></script>
	<script src="../static/js/bootstrap/js/bootstrap-table-export.js"></script>
	<script src="../static/js/tableExport/libs/FileSaver/FileSaver.min.js"></script>
	<script src="../static/js/tableExport/libs/js-xlsx/xlsx.core.min.js"></script>
	<script src="../static/js/tableExport/tableExport.js"></script>
   </c:if>
   </c:if>
</c:if>
<title>资源管理</title>
</head>
<body>

	<!-- bootstrap table -->
	<table id="table"></table>
	
	<c:if test= "${!empty sessionScope.yh}">        
	<c:if test="${op=='getAll'}">      
    <c:if test="${yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1}">  
		<!-- 新增按钮 -->
		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
		</div>
		
		<!-- 新增按钮动作 -->
		<script>
			$("#btn_add").click(function () {
				 var index = $('#table').bootstrapTable().length;
						$('#table').bootstrapTable('insertRow', {
			            index: 0,
			            row: {zyname:'',zynote:'',zygroup:''}
			        })
			})
		</script>
	</c:if>
	</c:if>
	</c:if>
	<c:if test= "${!empty sessionScope.yh}">
	<c:choose>
	<c:when test="${op=='getAll'}">           
	<c:if test="${yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1}">
	<script>
	//操作栏的格式化 
	$(function(){
		$('#table').bootstrapTable({
		ajax : function (request) {
	        $.ajax({
	            type : "post",
	            url : '<%=url%>',
				contentType: "application/json;charset=utf-8",
				dataType:"json",
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
			sortName: 'zyid',
			sortOrder: "asc",
			pageSize: 10,
			pageNumber: 1,
			pageList: "[10, 15, 25, 50]",
			undefinedText: '-',
			showToggle: true,
			showRefresh: true,
			showColumns: true, //是否显示内容下拉框
			showPaginationSwitch: true,//显示数据条数选择框 
			search: true, //搜索框
			pagination:true, //底部显示分页条
			strictSearch: false, //模糊搜索
			uniqueId: "zyid", //每一行的唯一标识,一般为主键列
			striped: true,  
            cache: false,
            showExport: true,  //是否显示导出按钮  
            buttonsAlign:"right",  //按钮位置  
            exportDataType:'all',
            exportTypes:['excel', 'xlsx'],  //导出文件类型
			columns: [{
				field: "state",
				checkbox:true,
			},{
				field: 'rowid',
				title: '序号',
				formatter: function(value, row, index) {
					row.rowid = index;
					return index+1;
				}			
			},{
				field: 'zyname',
				title: '资源名称',
				editable: {
					type: 'text',
					mode: 'inline',		
				}		
			},{
				field: 'zynote',
				title: '资源注释',
				switchable: true,
				editable: {
					type: 'text',
					mode: 'inline',		
				}
			},{
				field: 'zygroup',
				title: '资源组别',
				switchable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline', 
				}
			},{
				field: 'cz',
				title: '操作',
				width: 100,
				formatter: function (value, row, index) {  
		                   var s = '<button class = "save" href="javascript:void(0)">保存</button>&nbsp&nbsp';  
		                   var b = '<button class = "delete" href="javascript:void(0)">删除</button>';
		                   return s + b;  
                },  
		        events: 'operateEvents' 
			}],
			 onEditableSave: function (field, row, oldValue, $el) {
			 }
		});
			
			window.operateEvents = {
					 'click .save': function (e, value, row, index) {
						 //alert(row);
						 $.ajax({
			                    type: "post",
			                    url: "../controller/ZYGLController.jsp?op=update",
			                    data: {"row": JSON.stringify(row)},
			                    dataType: 'JSON',
			                    success: function (data, status) {
			                        if (status == "success") {
			                            alert('保存成功');
			                            $('#table').bootstrapTable('updateRow',{
				                            index:row.rowid,
				                            row:row
				                      })	
			                        }
			                    },
			                    error: function () {
			                        alert('保存失败');
			                        window.location.reload();
			                    },
			                });
					 },
			 
			 'click .delete': function (e, value, row, index) {
				 if(window.confirm("确定删除?")) {
				 $.ajax({
	                   type: "post",
	                   url: "../controller/ZYGLController.jsp?op=delete",
	                   data: {"ID": row.id},
	                   dataType: 'JSON',
	                   success: function (data, status) {
	                       if (status == "success") {
	                           alert('删除成功');
	                           $('table').bootstrapTable('remove', {
	                               field: 'id',
	                               values: [row.id]
	                             });
	                       }
	                   },
	                   error: function () {
	                       alert('删除失败');
	                       window.location.reload();
	                   },
	               });
					 
				 }
			 }
		}
		})
	</script>
	</c:if>
	</c:when>
	</c:choose>
	</c:if>
</body>
</html>