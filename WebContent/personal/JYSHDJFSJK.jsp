<%@ page language="java" pageEncoding="UTF-8" import="bean.YH,java.util.Calendar"%>
<html>
 <head>
  <title>免费师范生工作数据</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <link href="../static/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="../static/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="../static/assets/css/page-min.css" rel="stylesheet" type="text/css" />   
 </head>


 <body>     
  <div class="container">
    <div class="detail-page">
      <h2>免费师范生工作信息</h2>
      <div class="detail-section">  
        <div class="row detail-row">
          <div class="span8">
            <label>教研室活动经费：</label><span id="jyshdjf" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>奖惩：</label><span id="jc" class="detail-text"></span>
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
           <label>合计：</label><span id="hj" class="detail-text"></span>
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
		 url : '../controller/JYSHDJFSJKController.jsp',
		 data : {
		 "op" : "personal",
		 "year" : year
		 },
		 dataType:"json",
		 success : function(jsonData) {
			$("#jyshdjf").text(jsonData[0].jyshdjf);
			$("#jc").text(jsonData[0].jc);
			$("#hj").text(jsonData[0].hj);
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
