	/**
	 * 集体活动考勤
	 */
	//新增数据按钮点击事件
	$("#btn_add").click(function () {
		var defaultValue = "-";
		$('#table').bootstrapTable('insertRow', {
		    index: 0,
		    row: {rydm:defaultValue,xm:defaultValue,wgwd:defaultValue,grsj:defaultValue,
		      	jey:defaultValue,jee:defaultValue,hjje:defaultValue,nd:defaultValue
            }
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
							   for(var i in jsonListYH) {
							   	   if(jsonListYH[i].rydm == value) {
							   			flag = 1;
							   	   }
		                       }
		                       for(var i in jsonData) {
							   	   if(jsonData[i].rydm == value) {
							   			flag = 2;
							   	   }
		                       }
							   if(flag == 0) {
								   return '用户不存在';
							   }else if(flag == 2) {
								   return '该用户已存在';
							   }
							}	
					  	}
					},{
						field: 'xm',
						title: '姓名'
					},{
						field: 'wgwd',
						title: '无故未到',
						switchable: true,
						editable: {  
		                    type: 'text', 
		                    mode: 'inline',
		                    validate: function (value) {
		                       var rex = /^(([1-9][0-9])|([0-9]))((\.\d{0,}))$/;
		                       if(!value) {
		                    	   return '该项不能为空';
		                       }
	                      	   var valueInt = parseInt(value);
		                       if (isNaN(value) || valueInt < 0 || rex.test(value)) {
		                          return '该项必须是正整数或0';
		                       }
		                    }
						}
					},{
						field: 'grsj',
						title: '个人事假',
						switchable: true,
						editable: {  
		                    type: 'text', 
		                    mode: 'inline',
		                    validate: function (value) {
		                       var rex = /^(([1-9][0-9])|([0-9]))((\.\d{0,}))$/;
		                       if(!value) {
		                    	   return '该项不能为空';
		                       }
	                      	   var valueInt = parseInt(value);
		                       if (isNaN(value) || valueInt < 0 || rex.test(value)) {
		                          return '该项必须是正整数或0';
		                       }
		                    }
						}
					},{
						field: 'jey',
						title: '金额1'
					},{
						field: 'jee',
						title: '金额2',
					},{
						field: 'hjje',
						title: '合计金额',
					},{
						field: 'nd',
						title: '年度',
						editable: {  
		                    type: 'text', 
		                    mode: 'inline',
		                    validate: function (value) {
		                       var rex = /^(([1-9][0-9])|([0-9]))((\.\d{0,}))$/;
		                       if(!value) {
		                    	   return '该项不能为空';
		                       }
	                      	   var valueInt = parseInt(value);
		                       if (isNaN(value) || valueInt < 2017 || rex.test(value)) {
		                          return '请填写正确的年份';
		                       }
		                    }
						}
					},{
						field: 'cz',
						title: '操作',
						width: 100,
						visible: true,
						formatter: function (value, row, index) {  
							var s='<button id="save" type="button" class="save btn btn-sm"><span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>保存</button>&nbsp';
				            var b='<button id="delete" type="button" class="delete btn btn-sm"><span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>删除</button>'
				            return s + b;  
		                },  
				        events: 'operateEvents' 
					}],
					onEditableSave: function (field, row, oldValue, $el) {
						if(field == "rydm") {
							for(var i in jsonListYH) {
								if(jsonListYH[i].rydm == row.rydm) {
									row.xm = jsonListYH[i].xm;
								 	break;
								}
								row.xm = "-";
							}
						 }else if(field == "wgwd"){
							row.jey = Number(row.wgwd) * Number(jsonWGWD.je);
							row.hjje = Number(row.jey) + Number(row.jee);
						}else if(field == "grsj") {

								
							row.jee = Number(row.grsj) * Number(jsonGRSJ.je);
							row.hjje = Number(row.jey) + Number(row.jee);
						}
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
					if(row.rydm == "-" || row.xm == "-") {
						alert("该用户不存在");
					}else {
						if(isNaN(row.wgwd)) {
							row.wgwd = "0";
							row.jey = "0";
							row.hjje =  Number(row.jey) +  Number(row.jee);
						}
						
						if(isNaN(row.grsj)) {
							row.grsj = "0";
							row.jee = "0";
							row.hjje =  Number(row.jey) +  Number(row.jee);
						}
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
					}
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
					editable: {
						type: 'text',
						mode: 'inline'	
					}		
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
				}, {
					field: 'hjje',
					title: '合计金额'
				}, {
					field: 'nd',
					title: '年度',
				}]
			})
		}					
	});
	
	
	
	//获取无故未到一次金额
	$.ajax({
		type: "post",
		url: basePath+"/controller/QTGZController.jsp",
		data:{
			"op" : "single",
			"field" : "wgwd"
		},
		dataType : "json",
		success: function (data, status) {
			if (status == "success") {
				jsonWGWD = data[0];
				if(isNaN(jsonWGWD.je)) {
					jsonWGWD.je = "0";
				}
			}
		},
		error: function () {
		    alert('获取无故未到规则失败');
		}
	});
	
	//获取个人事假一次金额
	$.ajax({
       type: "post",
       url: basePath+"/controller/QTGZController.jsp",
       dataType : "json",
       data : {
    	 "op" : "single",
    	 "field" : "grsj"
       },
       success: function (data, status) {
	   		if (status == "success") {
	           jsonGRSJ = data[0]; 
	           if(isNaN(jsonGRSJ.je)) {
	        	   jsonGRSJ.je = "0";
	           }
	        }
       },
       error: function () {
            alert('获取个人事假规则失败');
       }
   });
