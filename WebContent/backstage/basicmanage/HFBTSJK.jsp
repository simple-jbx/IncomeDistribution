<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:include page="/common/header.jsp" flush="true"/>
<%@ include file="/common/adminheader.jsp"%>
<%@ include file="/common/admintoolbar.jsp"%>
<html>
<body>
	<table id="table"></table> 

	<script type="text/javascript">
		var basePath = "${basePath}";
		var jsonData = null;
		var jsonListYH = "${jsonListYH}";
		var dataYear = 'All';
		var getURL = basePath + '/controller/HFBTSJKController.jsp'
		var upTableName='hfbtsjk';
	</script>	
	<script type="text/javascript" charset="UTF-8" src="${basePath}/static/js/backstage/other/HFBTSJK.js?v=2018082001"></script>
	<script type="text/javascript" charset="UTF-8" src="${basePath}/static/js/common/commTD.js?v=2018082001"></script>
	<script type="text/javascript" charset="UTF-8" src="${basePath}/static/js/common/commTDadmin.js?v=2018082101"></script>
	<script type="text/javascript" charset="UTF-8" src="${basePath}/static/js/backstage/admin/HFBTSJKadmin.js?v=2018081901"></script>
</body>
</html>