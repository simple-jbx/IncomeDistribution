<%@page import="utils.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../static/js/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<script src="../static/js/jQuery.js"></script>
<script src="../static/js/bootstrap/js/bootstrap.min.js"></script>
<script src="../static/js/bootstrap/js/bootstrap-table.min.js"></script>

<link href="../static/js/bootstrap/css/bootstrap-fileinput.min.css"
	rel="stylesheet" type="text/css">
<script src="../static/js/bootstrap/js/bootstrap-editable.js"></script>
<script src="../static/js/bootstrap/js/bootstrap-fileinput.min.js"></script>
<script src="../static/js/bootstrap/js/bootstarp-fileinout-zh-CN.js"></script>

<title>上传页面</title>
</head>
<body>
<!-- 上传区域  -->
		<br>
		<br>
		<div class="htmleaf-container" id="upLoad">
			<div class="container kv-main" align="right">
					<input id="fileUpload" class="file" type="file" name="fileUpload">
			</div>
		</div>
		
		<script>  
		  <%
			String tableName = request.getParameter("from");
		    String timeStamp = request.getParameter("t");
			if(StringUtils.isEmpty(tableName))
				tableName = "";
		  %>
		  $("#fileUpload").fileinput({  
		     language : "zh",//设置语言  
		     uploadUrl: "${pageContext.request.contextPath}/upLoadServlet?tableName="+"<%=tableName%>&timeStamp="
		    		 +"<%=timeStamp%>",//上传地址  
		     textEncoding: 'UTF-8',
		     uploadAsync: true,//同步还是异步  
		     showCaption: true,//是否显示标题  
		     showUpload: true,//是否显示上传按钮  
		     showClose: false,//是否显示右上角的x
		     showPreview: false,//是否显示预览区域
		     dropZoneEnabled: true,
		     browseClass: "btn btn-default", //按钮样式   
		     allowedFileExtensions : ['xls','xlsx'],//接收的文件后缀  
		     //allowedFileTypes: ['Excel','Microsoft Excel'],//接收的文件类型
		     maxFileCount: 10,//最大上传文件数限制  
		     overwriteInitial: false,  
		     maxFileSize: 10000,   
		     gmsFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
		     previewFileIcon: '<i class="glyphicon glyphicon-file"></i>',   
		     enctype: 'multipart/form-data',  
		     /* allowedPreviewTypes: null, */  
		     previewFileIconSettings: {  
		           'docx': '<i class="glyphicon glyphicon-file"></i>',  
		           'xlsx': '<i class="glyphicon glyphicon-file"></i>',  
		           'pptx': '<i class="glyphicon glyphicon-file"></i>',  
		           'jpg': '<i class="glyphicon glyphicon-picture"></i>',  
		               'pdf': '<i class="glyphicon glyphicon-file"></i>',  
		               'zip': '<i class="glyphicon glyphicon-file"></i>' ,
		               'xls': '<i class="glyphicon glyphicon-file"></i>',
		     },
		     success : function (msg) {	
				alert("上传成功！");
				window.close();
		     },
			 error:function(){
				alert("上传失败！"); 
			 }
		    });
		</script>	
</body>
</html>