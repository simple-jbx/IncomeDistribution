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
			field: 'db',
			title: '读博'			
		},{
			field: 'hj',
			title: '合计'
		},{
			field: 'nd',
			title: '年度'
		}]
	})
})