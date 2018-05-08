<!DOCTYPE HTML>
<%@ page language="java" pageEncoding="UTF-8" import="bean.YH"%>
<html>
 <head>
  <title>个人信息</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <link href="../static/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="../static/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="../static/assets/css/page-min.css" rel="stylesheet" type="text/css" />   
 </head>

 <body>     
  <div class="container">
    <div class="detail-page">
      <h2>基本信息</h2>
      <div class="detail-section">  
        <div class="row detail-row">
          <div class="span8">
            <label>工号：</label><span class="detail-text" id="gh"></span>
          </div>
          <div class="span8">
            <label>姓名：</label><span class="detail-text" id="xm"></span>
          </div>
           <div class="span8">
            <label>职称：</label><span class="detail-text" id="zc"></span>
          </div>
        </div>
        
      </div>
    </div>
  </div>
  <script type="text/javascript" src="../static/assets/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript" src="../static/assets/js/bui-min.js"></script>
  <script type="text/javascript" src="../static/assets/js/config-min.js"></script>
  <script type="text/javascript">
    BUI.use('common/page');
    var currentYH = ${currentYH.toJSON()};
	$("#gh").text(currentYH[0].rydm);
	$("#xm").text(currentYH[0].xm);
	$("#zc").text(currentYH[0].zc);
  </script>

<body>
</html>  
