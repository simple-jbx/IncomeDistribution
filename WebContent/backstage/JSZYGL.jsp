<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<html>
<!-- 角色资源管理-->
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
<title>角色资源管理</title>
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
	            url : "../controller/JSZYGLController.jsp?op=getAll",
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
			sortName: 'jsid',
			sortOrder: "asc",
			pageSize: 10,
			pageNumber: 1,
			pageList: "[10, 15, 20, 50]",
			//showPaginationSwitch: true,//选择是否显示底部分页条 
			//search: true, //搜索框
			pagination:true, //底部显示分页条
			//strictSearch: false, //模糊搜索
			uniqueId: "yhjsid", //每一行的唯一标识，一般为主键列
			striped: true,  
            cache: false,
            buttonsAlign:"right",  //按钮位置  
          	columns: [{
				field: "state",
				checkbox:true,
				visible: true
			},{
				field: 'jszyid',
				visible: false
			},{
				field: 'rowid',
				title: '序号',
				formatter: function(value, row, index) {
					row.rowid = index;
					return index+1;
				}
			},{
				field: 'isdel',
				visible: false
			},{
				field: 'jsid',
				title: '角色',
				switchable: true,
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
			},{
				field: 'zyid',
				title: '资源',
				switchable: true,
				//sortable: true,
				editable: {  
                    type: 'select', 
                    mode: 'inline',
                    source:[
						{value:"0064df16cf0f42deb52a130c04b72d68", text:"教学督导补贴数据"},
						{value:"0f880d7ba2c348b7a5c0c68065d85e68", text:"本单位奖酬金发放总报表"},
						{value:"10df9df59de54041ad4bd8b23492b8d9", text:"职称与科研标准分"},
						{value:"164f5799ab85438c9a5d26831440447e", text:"职务与职务系数"},
						{value:"22679d1e29fd4f45b404c24f5fa36346", text:"行政管理人员"},
						{value:"2feccfb4cf1845248493758fe00de879", text:"指标体系补贴"},
						{value:"3a1a210008d54940aaa763c1718c695d", text:"场馆负责人补贴"},
						{value:"3f746a2b34014ce792b389e42408f61b", text:"在岗时间系数数据"},
						{value:"56502c1c2d9741eeb3d3b700fbcf1697", text:"教研室活动经费"},
						{value:"5bf92b242a3b40208ee090e0fd538ca4", text:"校运会补贴数据"},
						{value:"5fc6f2817cb34a6580dc3d58095f10c4", text:"话费补贴数据"},
						{value:"671e411a9a6d41a59c0424b457e22bab", text:"学院综合管理与发展评价分配结果表"},
						{value:"6dfddaa363b043578752c9fdbef3c7ba", text:"免费师范生工作"},
						{value:"7290a33a14e94f248d9ba2fd093d9ccc", text:"新闻稿件补贴"},
						{value:"81b12a1507ac489dbd881be0f91c812c", text:"读博补贴数据"},
						{value:"81fafa52c1524af2bef6fba0a6d5f984", text:"学院评优数据"},
						{value:"88267c297a96475bafb14da1cdc39748", text:"监考工作基础数据"},
						{value:"b0203c4374ec43b48cb6205748dc1cc2", text:"竞赛训练及社会服务数据"},
						{value:"b09bc275dce641d1b7a4d83a9937c10a", text:"免师补发工作数据"},
						{value:"bebdcf3222e6446c99e9191770721319", text:"科研成果基础数据"},
						{value:"bb59475490ea4e98beee9c8534dd90ba", text:"综合管理指标时效"},
						{value:"e3f9e43b7ea741219a4b60038f1e0f76", text:"值班工作基础数据"},
						{value:"ed4815dc38474928882d58a3c8361c2d", text:"学校评优数据"},
						{value:"eecd0ee917224c72a4556732af58c563", text:"职级与职级系数"},
						{value:"efe9348f6cfd4267b848e701eebb1907", text:"照金活动补贴数据"},
						{value:"adb0a530e43247fba772f6836f8702ce", text:"在岗时间系数规则"},
						{value:"076c099c975745fc903692075b9d8c2e", text:"其他规则"},
						{value:"32ac533ac98a4d488e21dbcb8e3c1196", text:"集体活动考勤"}		
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
				 }
			}
	});
		 window.operateEvents = {
			'click .save': function (e, value, row, index) {
				 $.ajax({
		                 type: "post",
		                 url: "../controller/JSZYGLController.jsp?op=update",
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
                    url: "../controller/JSZYGLController.jsp?op=delete",
                    data: {"Jszyid": row.jszyid},
                    dataType: 'JSON',
                    success: function (data, status) {
                        if (status == "success") {
                            alert('删除成功');
                            $('table').bootstrapTable('remove', {
	                               field: 'jszyid',
	                               values: [row.jszyid]
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