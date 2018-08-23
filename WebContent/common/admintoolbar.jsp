<%@ page language="java" pageEncoding="UTF-8" import="java.util.Calendar"%>

	<div id="toolbar" class="btn-group">
		<select class="btn btn-default" id="selectYear">
	   		<% 
	 			Calendar date = Calendar.getInstance();
	       		int year = date.get(Calendar.YEAR);
	  			for(int i = year-4; i <= year; i++) {
			%>
	 	<option value="<%=i%>"><%=i%>年</option>
	 		<% 
	  			}
	  		%>
		<option value="All"  selected><%=year-4%>-<%=year%>年</option>	
	    </select>
	  		
		<button id="btn_add" type="button" class="btn btn-default hidden">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
		</button>
		<button id="btn_upload" type="button" class="btn btn-default hidden">
			<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>上传		
		</button>
		<button id="btn_list_save" type="button" class="btn btn-default hidden">
			<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>批量保存	
		</button>
		<button id="btn_list_delete" type="button" class="btn btn-default hidden">
			<span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>批量删除		
		</button>
		<button id="btn_edit" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>编辑
		</button>
	</div>