<%@ page language="java" pageEncoding="UTF-8" import="bean.YH,java.util.Calendar"%>
<html>
 <head>
  <title>在岗时间系数数据</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <link href="../static/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="../static/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="../static/assets/css/page-min.css" rel="stylesheet" type="text/css" />   
 </head>


 <body>     
  <div class="container">
    <div class="detail-page">
      <h2>在岗信息</h2>
      <div class="detail-section">  
        <div class="row detail-row">
          <div class="span8">
            <label>在岗月数：</label><span id="zgys" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>在岗系数：</label><span id="zgxs" class="detail-text"></span>
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
        <div class="row detail-row">
          <div class="span8">
            <label>在岗情况说明：</label><span id="zgqksm" class="detail-text"></span>
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
		 url : '${basePath}/controller/ZGSJXSController.jsp',
		 data : {
		 "op" : "personal",
		 "year" : year
		 },
		 dataType:"json",
		 success : function(jsonData) {
			$("#zgys").text(jsonData[0].zgys);
			$("#zgxs").text(jsonData[0].zgxs);
			$("#zgqksm").text(jsonData[0].zgqksm);
		 },
		 error:function(msg){
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