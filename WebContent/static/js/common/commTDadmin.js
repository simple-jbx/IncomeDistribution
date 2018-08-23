//上传按钮点击事件
	$("#btn_upload").click(function () {
		var timeStamp = Date.parse(new Date());
		window.open(basePath+"/FileContro/upload.jsp?from="+upTableName+"&t="+timeStamp,"","width=450,height=150,top=50%,left=50%," +
				"resizable=no,location=no,status=no,help=no,dependent=yes");
	})
	
	//点击批量删除事件
	$("#btn_list_delete").click(function () {
		var rows = $("#table").bootstrapTable('getSelections');
		if(rows.length == 0) {
			alert("请先选择要删除的记录！");
			return;
		}
		var list_rows_id = new Array();
		for(var k=0; k<rows.length; k++) {
			list_rows_id.push(rows[k].id);
		}
		if(window.confirm("确定删除?")) {
			$.ajax({
                type: "post",
                url: getURL,
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
		if(rows.length == 0) {
			alert("请先选择要保存的记录！");
			return;
		}
		
		$.ajax({
            type: "post",
            url: getURL,
            data: {
            	"op":"list",
            	"field":"update",
            	"list_rows": JSON.stringify(rows)
            },
            dataType: 'JSON',
            success: function (data, status) {
               if (status == "success") {
                  for(var k = 0; k < rows.length; k++) {
                	  $('#table').bootstrapTable('updateRow',{
					     	index:rows[k].rowid,
					      	row:rows[k],
					    })	
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