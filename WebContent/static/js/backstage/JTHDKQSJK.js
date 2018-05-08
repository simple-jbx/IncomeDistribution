	/**
	 * 集体活动考勤
	 */

	//下拉按钮点击事件
	function getDataByYear(year) {
		$.ajax({
			type : "post",
			url : basePath+'/controller/JTHDKQSJKController.jsp',
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
	
	  getDataByYear("All");
	  $(document).ready(function () {
	    $("#selectYear").bind("change",function(){
	    	getDataByYear($(this).val());
	    	});
	  });
	
	//新增数据按钮点击事件
	$("#btn_add").click(function () {
		var index = $('#table').bootstrapTable().length;
		//console.log(index);
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
		//console.log(edit);
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
							   	   if(jsonListYH[i].gh == value) {
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
						//formatter:actionFormatter,
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
								if(jsonListYH[i].gh == row.rydm) {
									row.xm = jsonListYH[i].xm;
								 	break;
								}
								row.xm = "-";
							}
						 }else if(field == "wgwd"){
							//console.log(Number(row.wgwd));
							//console.log(row.wgwd);
							row.jey = Number(row.wgwd) * Number(jsonWGWD.je);
							row.hjje = Number(row.jey) + Number(row.jee);
						}else if(field == "grsj") {

								
							row.jee = Number(row.grsj) * Number(jsonGRSJ.je);
							row.hjje = Number(row.jey) + Number(row.jee);
						}
						//console.log(row);
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
					//console.log(row);
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
						       url: basePath+"/controller/JTHDKQSJKController.jsp",
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
		                url: basePath+"/controller/JTHDKQSJKController.jsp",
		                data: {
		                	"op":"single",
		                	"field":"update",
		                	"ID": row.id
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
					title: '无故未到',
					switchable: true,
					editable: {  
			        	type: 'text', 
			        	mode: 'inline'			                  
					}
				},{
					field: 'grsj',
					title: '个人事假',
					editable: {  
			           type: 'text', 
			           mode: 'inline'           
					}
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
	
	//上传按钮点击事件
	$("#btn_upload").click(function () {
		var timeStamp = Date.parse(new Date());
		window.open(basePath+"/FileContro/upload.jsp?from=jthdkqsjk&t="+timeStamp,"","width=450,height=150,top=50%,left=50%," +
				"resizable=no,location=no,status=no,help=no,dependent=yes");
	})
	
	//点击批量删除事件
	$("#btn_list_delete").click(function () {
		var rows = $("#table").bootstrapTable('getSelections');
		//console.log(rows.length);
		if(rows.length == 0) {
			alert("请先选择要删除的记录！");
			return;
		}
		var list_rows_id = new Array();
		for(var k=0; k<rows.length; k++) {
			//console.log(rows[k].id);
			list_rows_id.push(rows[k].id);
		}
		if(window.confirm("确定删除?")) {
			$.ajax({
                type: "post",
                url: basePath+"/controller/JTHDKQSJKController.jsp",
                data: {
                	"op":"list",
                	"field":"delete",
                	"list_rows_id": JSON.stringify(list_rows_id)
                },
                dataType: 'JSON',
                success: function (data, status) {
                   if (status == "success") {
                      alert('删除成功');
                      for(var k=0; k < rows.length; k++) {
                    	  $('table').bootstrapTable('remove', {
                            	field: 'id',
                            	values: [rows[k].id]
                            });
                      }
                   }
               	},
                error: function () {
                   alert('删除失败');
                   window.location.reload();
                },
         	 });
		}
	})
	
	$("#btn_list_save").click(function () {
		var rows = $("#table").bootstrapTable('getSelections');
		//console.log(rows.length);
		if(rows.length == 0) {
			alert("请先选择要保存的记录！");
			return;
		}
		
		var list_rows = new Array();
		list_rows = JSON.stringify(rows)
		//console.log(list_rows);
		$.ajax({
            type: "post",
            url: basePath+"/controller/JTHDKQSJKController.jsp",
            data: {
            	"op":"list",
            	"field":"update",
            	"list_rows": list_rows
            },
            dataType: 'JSON',
            success: function (data, status) {
               if (status == "success") {
                  for(var k=0; k<rows.length; k++) {
                	  $('table').bootstrapTable('updateRow', {
                        	index: 'id',
                        	row: rows[k]
                        });
                  }
                  alert("保存成功");
               }
           	},
            error: function () {
               alert('保存失败');
               window.location.reload();
            },
     	 });
	})
	
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
		    //window.location.reload();
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
    	   	//console.log(data);
	   		if (status == "success") {
	           jsonGRSJ = data[0]; 
	           if(isNaN(jsonGRSJ.je)) {
	        	   jsonGRSJ.je = "0";
	           }
	        }
       },
       error: function () {
            alert('获取个人事假规则失败');
            //window.location.reload();
       }
   });
