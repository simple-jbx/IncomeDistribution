<%@ page language="java" pageEncoding="UTF-8" import="bean.YH,service.YHService,java.util.Calendar,java.util.List,
java.util.Map"%>

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
	  	<option value="All"  selected>"<%=year-4%>-<%=year%>年"</option>	
	    </select>
	</div>