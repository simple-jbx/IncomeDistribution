<%@ page language="java" pageEncoding="UTF-8" import="bean.YH"%>
<%@include file="../common/taglib.jsp"%>
<%@include file="../common/header.jsp"%>
<html>
<!-- 项目-->
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
<link rel="shortcut icon" href="../static/img/snnu.ico" type="image/x-icon" />

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
<title>项目</title>
</head>
<body>
	<div id="toolbar" class="btn-group">
		<button id="btn_add" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
		</button>
	</div>
	<table id="table"></table>
	<div class="htmleaf-container" id="upLoad">
		<div class="container kv-main" align="right">
			<!-- <div class="page-header">  
           <h2>单张上传 <small></h2>  
           </div> -->
			<!-- <form enctype="multipart/form-data" id="uploadForm"  method = "post"> -->
			<input id="fileUpload" class="file" type="file" name="fileUpload"
				multiple data-show-preview="true">
			<!-- </form> -->
		</div>
	</div>
	<script>
		$("#btn_add").click(function () {
			 var index = $('#table').bootstrapTable().length;
					$('#table').bootstrapTable('insertRow', {
		            index: index,
		            row: {xh:'',rydm:'',xm:'',bmmc:'',yfnzj:'0',grtzje:'0',nzjhj:'0',nzjks:'0',nzjsf:'0',sfzhm:'0',yhkh:'0',
		            	dhhm:'0',bz:'',qzqr:''
		            }
		        })
		})
	</script>
	<script>  
    $("#fileUpload").fileinput({  
        language : "zh",//设置语言  
        uploadUrl: "${pageContext.request.contextPath}/upLoadServlet?tableName=xm",//上传地址  
        uploadAsync: true,//同步还是异步  
        showCaption:false,//是否显示标题  
        showUpload: true,//是否显示上传按钮  
        browseClass: "btn btn-primary", //按钮样式   
        allowedFileExtensions : ['xls','xlsx'],//接收的文件后缀  
        //allowedFileTypes: ['Excel','Microsoft Excel'],//接收的文件类型
        maxFileCount: 1,//最大上传文件数限制  
        overwriteInitial: false,  
        maxFileSize: 1000,   
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",  
        previewFileIcon: '<i class="glyphicon glyphicon-file"></i>',   
        enctype: 'multipart/form-data',  
        /* allowedPreviewTypes: null, */  
        previewFileIconSettings: {  
               'docx': '<i class="glyphicon glyphicon-file"></i>',  
               'xlsx': '<i class="glyphicon glyphicon-file"></i>',  
               'pptx': '<i class="glyphicon glyphicon-file"></i>',  
               'jpg': '<i class="glyphicon glyphicon-picture"></i>',  
               'pdf': '<i class="glyphicon glyphicon-file"></i>',  
               'zip': '<i class="glyphicon glyphicon-file"></i>' ,
               'xls': '<i class="glyphicon glyphicon-file"></i>',
           }  
    });  
	</script>
	<script>
		function actionFormatter(value, row, index) {
        	var result = "";
        	result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"deleteByRydm('" + row.id + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
        	return result;
    	}
		function deleteByRydm(id) {
			if(window.confirm("是否确认删除?")) {
			$.ajax({
				type:"post",//请求方式
				data:{"Id":id},
				url:"../controller/XMController.jsp?op=delete",//请求地址
				error:function(){//如果出错了，将事件重新绑定
					alert("请求失败，请重试！")
				},
				success:function(data){ //返回成功执行回调函数。
					if(data == 1) {
						alert("删除成功")
						window.location.reload(); 
						}
					else {
						alert("修改错误，请重试！")
					}
					}
		});
	}
	}
	</script>

	<script>
	//操作栏的格式化 
	$(function(){
		$('#table').bootstrapTable({
		ajax : function (request) {
	        $.ajax({
	            type : "GET",
	            url : "../controller/XMController.jsp",
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
			sortName: 'xh',
			sortOrder: "desc",
			pageSize: 10,
			pageNumber: 1,
			pageList: "[10, 15, 25, 50, All]",
			showToggle: true,
			showRefresh: true,
			showColumns: true, //是否显示内容下拉框
			showPaginationSwitch: true,//显示数据条数选择框 
			search: true, //搜索框
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
				title: 'Id',
				switchable: true,
				visible: false
			},{
				field: 'xmmc',
				title: '项目名称',
				switchable: true,
				sortable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline',
                    validate: function (value) {  
                        if ($.trim(value) == '') {  
                            return '项目名称不能为空!';  
                        }  
                    } 
				}
			},{
				field: 'fzr',
				title: '负责人',
				switchable: true,
				sortable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline',
                    validate: function (value) {  
                        if ($.trim(value) == '') {  
                            return '负责人不能为空!';  
                        }  
                    } 
				}
			}, {
				field: 'xmcy',
				title: '项目成员',
				switchable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline'
				}
			}, {
				field: 'zzsx',
				title: '作者属性',
				switchable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline',
                    }  
			}, {
				field: 'zzpx',
				title: '作者排序',
				switchable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline',
				}
			}, {
				field: 'xmxz',
				title: '项目性质',
				switchable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline',
				}
			}, {
				field: 'xmfl',
				title: '项目分类',
				switchable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline',
				}
			}, {
				field: 'xmjb',
				title: '项目级别',
				switchable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline',
				}
			}, {
				field: 'lxrq',
				title: '立项日期',
				switchable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline',
				}
			}, {
				field: 'htjf',
				title: '合同经费',
				switchable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline',
				}
			}, {
				field: 'xmly',
				title: '项目来源',
				switchable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline',
				}
			}, {
				field: 'sftj',
				title: '是否统计',
				switchable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline',
				}
			}, {
				field: 'shzt',
				title: '审核状态',
				switchable: true,
				editable: {  
                    type: 'text', 
                    mode: 'inline',
				}
			},{
				field: 'cz',
				title: '操作',
				formatter:actionFormatter,
				visible: true
			}],
			 onEditableSave: function (field, row, oldValue, $el) {
				 //alert(row.gh);
	                $.ajax({
	                    type: "post",
	                    url: "../controller/XMController.jsp?op=update",
	                    data: {"row": JSON.stringify(row)},
	                    dataType: 'JSON',
	                    success: function (data, status) {
	                        if (status == "success") {
	                            alert('修改成功');
	                            window.location.reload();
	                        }
	                    },
	                    error: function () {
	                        alert('编辑失败');
	                        window.location.reload();
	                    },
	                });
	            },
	});
	})
	</script>
</body>
</html>