<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/adminheader.jsp"%>
<%@ include file="/common/admintoolbar.jsp"%>
<jsp:include page="/common/header.jsp" flush="true"/>

<html>
<body>
	<table id="table"></table> 
	<script type="text/javascript">
		var basePath = "${basePath}";
		var jsonData = null;
		var jsonListYH = "${jsonListYH}";
		var dataYear = 'All';
		var getURL = basePath+'/controller/ZJHDBTSJKController.jsp';
		var upTableName = 'zjhdbtsjk';
	</script>
	<script type="text/javascript" charset="UTF-8" src="${basePath}/static/js/backstage/other/ZJHDBTSJK.js?v=2018081801"></script>	
	<script type="text/javascript" charset="UTF-8" src="${basePath}/static/js/common/commTD.js?v=2018082001"></script>	
	<script type="text/javascript" charset="UTF-8" src="${basePath}/static/js/common/commTDadmin.js?v=2018082101"></script>	
	<script type="text/javascript" charset="UTF-8" src="${basePath}/static/js/backstage/admin/ZJHDBTSJKadmin.js?v=2018081801"></script>
</body>
</html>