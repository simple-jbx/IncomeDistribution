	/**
	 * 用户管理
	 */

	//操作栏的格式化 
	$(function(){
		$('#table').bootstrapTable({
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
			field: 'zc',
			title: '职称'			
		}]
	})
	})

	//新增数据按钮点击事件
	$("#btn_add").click(function () {
		var index = $('#table').bootstrapTable().length;
		//console.log(index);
		var defaultValue = "-";
		$('#table').bootstrapTable('insertRow', {
		    index: 0,
		    row: {rydm:defaultValue,xm:defaultValue,zc:defaultValue}
		})
	});
	
	//编辑按钮点击事件
	$("#btn_edit").click(function () {
		var edit = $('#table').bootstrapTable('getOptions','editable');
		edit = edit.editable;
		if(edit == false){
			$("#btn_add").removeClass("hidden");
			$("#btn_upload").removeClass("hidden");
			$("#fileUpload").removeClass("hidden");
			$("#btn_list_save").removeClass("hidden");
			$("#btn_list_delete").removeClass("hidden");
			$('#table').bootstrapTable('refreshOptions', {
				editable: !edit,
				showColumns: true, //是否显示内容下拉框
				columns: [
					{
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
						field: 'rydm',
						title: '人员代码',
						editable: {
							type: 'text',
							mode: 'inline',	
							validate: function (value) {
		                       if (!value) {
		                    	   return '该项不能为空';  
		                       } 
		                       var flag = 0;
							  
					  	}
					}
					},{
						field: 'xm',
						title: '姓名',
						editable: {
							type: 'text',
							mode: 'inline',	
						}
					},{
						field: 'zc',
						title: '职称',
						editable: {
							type: 'text',
							mode: 'inline',	
						}
					},{
						field: 'cz',
						title: '操作',
						width: 100,
						visible: true,
						formatter: function (value, row, index) {  
							var s = '<button id="save" type="button" class="save btn btn-sm">'
								+ '<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>保存</button>&nbsp';
				            var b = '<button id="delete" type="button" class="delete btn btn-sm">'
				            	+'<span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>删除</button>';
				            var r = '<button id="reset" type="button" class="reset btn btn-sm">'
				            	+'<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>密码重置</button>'
				            return s + b + r;  
		                },  
				        events: 'operateEvents' 
					}],
					onEditableSave: function (field, row, oldValue, $el) {
						$.ajax({
			               type: "post",
			               success: function (data, status) {
			                if (status == "success") {
				               	$('#table').bootstrapTable('updateRow',{
					            	index:row.rowid,
					            	row:row
					            })	
			               	}
			               },
			               error: function () {
			                  alert('编辑失败');
			                  window.location.reload();
			               },
			          });
				 }
			});
				
			window.operateEvents = {
				'click .save': function (e, value, row, index) {
						$.ajax({
						       type: "post",
						       url: getURL,
						       data: {
						    	   "op":"single",
						    	   "field":"update",
						    	   "row": JSON.stringify(row)
						       },
						       dataType: 'JSON',
						       success: function (data, status) {
						    	   console.log(status);
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
		                url: getURL,
		                data: {
		                	"op":"single",
		                	"field":"delete",
		                	"ID": JSON.stringify(row.id)
		                },
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
				},
				
				'click .reset': function (e, value, row, index) {
					if(window.confirm("确定重置此用户密码?")) {
						$.ajax({
						       type: "post",
						       url:getURL,
						       data: {
						    	   "op":"single",
						    	   "field":"reset",
						    	   "changeyh": JSON.stringify(row)
						       },
						       dataType: 'JSON',
						       success: function (data, status) {
							        if (status == "success") {
							        	alert('重置成功！');						      	
							        }
						       },
						       error: function () {
						           alert('系统异常！');
						           window.location.reload();
						       },
						  });
					}
				}
			}
		}else{
			$("#btn_add").addClass("hidden");
			$("#btn_upload").addClass("hidden");
			$("#fileUpload").addClass("hidden");
			$("#btn_list_save").addClass("hidden");
			$("#btn_list_delete").addClass("hidden");

			$('#table').bootstrapTable('refreshOptions', {
				editable: !edit,
				columns: [{
					field: 'rowid',
					title: '序号',
					formatter: function(value, row, index) {
						row.rowid = index;
						return index+1;
					}			
				},{
					field: 'rydm',
					title: '人员代码',
						
				},{
					field: 'xm',
					title: '姓名',										
				},{
					field: 'zc',
					title: '职称'
				}]
			})
		}					
	});