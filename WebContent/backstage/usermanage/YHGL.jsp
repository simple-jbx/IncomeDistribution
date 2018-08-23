<%@ page language="java" pageEncoding="UTF-8" import="bean.YH,service.YHService,java.util.Calendar,java.util.List,
java.util.Map"%>
<%@ include file="/common/adminheader.jsp"%>
<jsp:include page="/common/header.jsp" flush="true"/>

<html>
<body>
	<table id="table"></table> 
	
	<div id="toolbar" class="btn-group">
	  		
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
	
	<script type="text/javascript">
		var basePath = "${basePath}";
		var jsonData = null;
		var jsonListYH = "${jsonListYH}";
		var dataYear = 'All';
		var getURL = '${basePath}/controller/YHController.jsp';
		var upTableName = 'yhgl';
	</script>
	<script type="text/javascript" charset="UTF-8" src="${basePath}/static/js/backstage/usermanage/YHGL.js?v=2018081602"></script>
	<script type="text/javascript" charset="UTF-8" src="${basePath}/static/js/common/ajaxStatus.js?v=2018081803"></script>
	<script type="text/javascript" charset="UTF-8" src="${basePath}/static/js/common/commTD.js?v=2018082101"></script>
	<script type="text/javascript" charset="UTF-8" src="${basePath}/static/js/common/commTDadmin.js?v=2018082101"></script>
</body>
</html>