<%@ page language="java" pageEncoding="UTF-8" import="bean.YH,java.util.Calendar"%>
<html>
 <head>
  <title>集体活动考勤</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <link href="../static/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="../static/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="../static/assets/css/page-min.css" rel="stylesheet" type="text/css" />   
 </head>


 <body>     
  <div class="container">
    <div class="detail-page">
      <h2>集体活动考勤信息</h2>
      <div class="detail-section">
      	<h3>个人基本信息</h3>  
        <div class="row detail-row">
          <div class="span8">
            <label>工号：</label><span class="detail-text">${yh.getGH()}</span>
          </div>
          <div class="span8">
            <label>姓名：</label><span class="detail-text">${yh.getXM()}</span>
          </div>
           <div class="span8">
            <label>职称：</label><span class="detail-text">${yh.getZC()}</span>
          </div>
        </div>
      </div>
      
      <div class="detail-section">  
      	<h3>考勤信息</h3>  
        <div class="row detail-row">
          <div class="span8">
            <label>无故未到：</label><span id="gh" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>个人事假：</label><span id="grsj" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>年度：</label><span class="detail-text"><select id="selectYear">
  			<% 
	  			Calendar date = Calendar.getInstance();
	       		int year = date.get(Calendar.YEAR);
	  			for(int i = year-4; i < year; i++) {
	 		%>
	 		 <option value="<%=i%>"><%=i%>年</option>
	 		<% 
	  			}
	  		%>
	  		<option value="<%=year%>"  selected><%=year%>年</option>	
		 	</select></span>
          </div>
        </div>
      </div>
      
       <div class="detail-section">
      	<h3>相关金额</h3>  
        <div class="row detail-row">
          <div class="span8">
            <label>金额1：</label><span id="jey" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>金额2：</label><span id="jee" class="detail-text"></span>
          </div>
           <div class="span8">
            <label>合计金额：</label><span id="hjje" class="detail-text"></span>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script type="text/javascript" src="../static/assets/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript" src="../static/assets/js/bui-min.js"></script>
  <script type="text/javascript" src="../static/assets/js/config-min.js"></script>
  <script type="text/javascript" src="../static/assets/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript">
    BUI.use('common/page');
  </script>
  <script type="text/javascript">
  function getDataByYear(year) {
	 $.ajax({
		 type : "post",
		 url : '../controller/JTHDKQSJKController.jsp',
		 data : {
		 "op" : "personal",
		 "year" : year
		 },
		 dataType:"json",
		 success : function(jsonData) {
			$("#gh").text(jsonData[0].wgwd);
			$("#grsj").text(jsonData[0].grsj);
			$("#jey").text(jsonData[0].jey);
			$("#jee").text(jsonData[0].jee);
			$("#hjje").text(jsonData[0].hjje);
		 },
		 error:function(){
		 	 alert("获取数据出错出错");
	 	 }
	 });
  }
  getDataByYear(<%=year%>);
  $(document).ready(function () {
    $("#selectYear").bind("change",function(){
    	getDataByYear($(this).val());
    	});
  });
 </script>

<body>
</html>  
