<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<html>
<!-- 在岗时间系数数据-->
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

<c:if test= "${!empty sessionScope.yh}">        
   <c:if test="${yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1}">  
    <link href="../static/js/bootstrap/css/bootstrap-editable.css"
	rel="stylesheet" type="text/css">
	<script src="../static/js/bootstrap/js/bootstrap-editable.js"></script>
	<script src="../static/js/bootstrap/js/bootstrap-table-editable.js"></script>
   </c:if>
</c:if>
<title>在岗时间系数数据</title>
</head>
<body>

	<!-- bootstarp table -->
	<table id="table"></table>
	
	<c:if test= "${!empty sessionScope.yh}">        
    	<c:if test="${yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1}">  
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
    	</c:if>
    </c:if>
    
	<c:if test= "${!empty sessionScope.yh}">
	<c:choose>
	<c:when test="${yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1}">
	<script>
	//操作栏的格式化 
	$(function(){		
		$('#table').bootstrapTable({
		ajax : function (request) {
	        $.ajax({
	            type : "POST",
	            url : "../controller/YHJSGLController.jsp?op=get",
				contentType: "application/json;charset=utf-8",
				dataType:"json",
				data:'',
				jsonp:'callback',
	            success : function (msg) {	
	            	jsonSJ = msg;
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
			sortName: 'yhjsid',
			sortOrder: "asc",
			pageSize: 10,
			pageNumber: 1,
			pageList: "[10, 15, 20, 50]",
			//showPaginationSwitch: true,//选择是否显示底部分页条 
			search: true, //搜索框
			pagination:true, //底部显示分页条
			strictSearch: false, //模糊搜索
			uniqueId: "yhjsid", //每一行的唯一标识，一般为主键列
			striped: true,  
            cache: false,
            buttonsAlign:"right",  //按钮位置  
          	columns: [{
				field: "state",
				checkbox:true,
				visible: true
			},{
				field: 'rowid',
				title: '序号',
				formatter: function(value, row, index) {
					row.rowid = index;
					return index+1;
				}
			},{
				field: 'gh',
				title: '工号',
				switchable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline'
               }
			},{
				field: 'xm',
				title: '姓名',
				switchable: true,
			},{
				field: 'jsid',
				title: '角色',
				switchable: true,
				//sortable: true,
				editable: {  
                    type: 'select', 
                    mode: 'inline',
                    source:[
						{value:"13f8db3e2fb14c8bb92ba6fb738293b9", text:"工勤人员"},
						{value:"1f17abe5a5204e22a3102471f5ec462d", text:"退休人员"},
						{value:"28ea454ed7cd4b23ab1543f32f286fb8", text:"实践为主型专任教师"},
						{value:"298b3cd8217d4e4b85044ceae64fc97b", text:"教学科研型专任教师"},
						{value:"2b71adf11579413eab7f5c9feb2bf641", text:"行政管理人员"},
						{value:"38aafa98d1034605a2f45748a46c1eaa", text:"科研秘书"},
						{value:"3ac81597fe9947af85a8a0945a4c5dae", text:"竞赛秘书"},
						{value:"41c802a59e17497fae6e81c0e897cf13", text:"管理员"},
						{value:"545aec22ffde441a96e0479226765d40", text:"教学秘书"},
						{value:"689aca3ddec14da0a1617f04f4e9a817", text:"科研为主型专任教师"},
						{value:"93d66fa79d174cd180c439c61c08e2d5", text:"教学为主型专任教师"},
						{value:"9840eff4e34f41019ffaf72afb14749e", text:"系统管理员"},
						{value:"9e8e0adb1f34485c8021d8b9b87e5d6b", text:"其他人员"},
						{value:"da029b24df704d749415770e4b64f807", text:"行政秘书"},
						{value:"e343620a4e594cdc9a2b4e051bac96dc", text:"主管领导"},
                    ]
				}
			}, {
				field: 'cz',
				title: '操作',
				//formatter:actionFormatter,
				width: 100,
				visible: true,
				formatter: function (value, row, index) {  
		                   var s = '<button class = "save" href="javascript:void(0)">保存</button>&nbsp&nbsp';  
		                   var b = '<button class = "delete" href="javascript:void(0)">删除</button>';
		                   return s + b;  
                },  
		        events: 'operateEvents' 
			}],
			 onEditableSave: function (field, row, oldValue, $el) {
				if(field == "gh") {
					 var jsonYH = ${jsonYH};
					 for(var i in jsonYH) {
						 if(jsonYH[i].gh == row.gh) {
							 row.xm = jsonYH[i].xm;
							 row.yhid = jsonYH[i].id;
							 break;
						 }
						 row.xm = "-";
					 }
					 $.ajax({
							url: '',
			                success: function (data, status) {
			                    if (status == "success") {
			                    	 $('#table').bootstrapTable('updateRow',{
				                            index:row.rowid,
				                            row:row
				                            }
				                        );
			                    }
			                },
			                error: function () {
			                    alert("修改错误");
			                    window.location.reload();
			                },
			            });
				 }else if(field == "jsid") {
					 if(row.jsid == "9840eff4e34f41019ffaf72afb14749e") {
						 row.jsgroup = 0;
					 }else if(row.jsid == "41c802a59e17497fae6e81c0e897cf13") {
						 row.jsgroup = 1;
					 }else if(row.jsid == "13f8db3e2fb14c8bb92ba6fb738293b9") {
						 row.jsgroup = 9;
					 }else if(row.jsid == "1f17abe5a5204e22a3102471f5ec462d") {
						 row.jsgroup = 10;
					 }else if(row.jsid == "28ea454ed7cd4b23ab1543f32f286fb8") {
						 row.jsgroup = 11;
					 }else if(row.jsid == "298b3cd8217d4e4b85044ceae64fc97b") {
						 row.jsgroup = 12;
					 }else if(row.jsid == "2b71adf11579413eab7f5c9feb2bf641") {
						 row.jsgroup = 8;
					 }else if(row.jsid == "38aafa98d1034605a2f45748a46c1eaa") {
						 row.jsgroup = 7;
					 }else if(row.jsid == "3ac81597fe9947af85a8a0945a4c5dae") {
						 row.jsgroup = 6;
					 }else if(row.jsid == "545aec22ffde441a96e0479226765d40") {
						 row.jsgroup = 5;
					 }else if(row.jsid == "689aca3ddec14da0a1617f04f4e9a817") {
						 row.jsgroup = 13;
					 }else if(row.jsid == "93d66fa79d174cd180c439c61c08e2d5") {
						 row.jsgroup = 14;
					 }else if(row.jsid == "9e8e0adb1f34485c8021d8b9b87e5d6b") {
						 row.jsgroup = 2;
					 }else if(row.jsid == "da029b24df704d749415770e4b64f807") {
						 row.jsgroup = 4;
					 }else if(row.jsid == "e343620a4e594cdc9a2b4e051bac96dc") {
						 row.jsgroup = 3;
					 }
				 }
			}
	});
		 window.operateEvents = {
			'click .save': function (e, value, row, index) {
				 $.ajax({
		                 type: "post",
		                 url: "../controller/YHJSGLController.jsp?op=update",
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
			if(window.confirm("确定删除?")){
				$.ajax({
                    type: "post",
                    url: "../controller/YHJSGLController.jsp?op=delete",
                    data: {"Yhjsid": row.yhjsid,"Yhid": row.yhid},
                    dataType: 'JSON',
                    success: function (data, status) {
                        if (status == "success") {
                            alert('删除成功');
                            $('table').bootstrapTable('remove', {
	                               field: 'yhjsid',
	                               values: [row.yhjsid]
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
	</c:when>
	<c:otherwise>
    </c:otherwise>
	</c:choose>
	</c:if>
</body>
</html>