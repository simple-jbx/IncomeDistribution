<%@ page language="java" pageEncoding="UTF-8" import="bean.YH,java.util.Calendar"%>
<html>
 <head>
  <title>科研数据</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <link href="../static/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="../static/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="../static/assets/css/page-min.css" rel="stylesheet" type="text/css" />   
 </head>


 <body>     
  <div class="container">
    <div class="detail-page">
      <h2>科研信息</h2>
      <div class="detail-section">  
        <div class="row detail-row">
          <div class="span8">
            <label>论文得分：</label><span id="lwdf" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>项目得分：</label><span id="xmdf" class="detail-text"></span>
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
            <label>著作得分：</label><span id="zzdf" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>专利得分：</label><span id="zldf" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>得分合计：</label><span id="dfhj" class="detail-text"></span>
          </div>
        </div>
      </div>
      
      <div class="detail-section">  
        <div class="row detail-row">
          <div class="span8">
            <label>标准分：</label><span id="bzf" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>超额分值：</label><span id="cefz" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>科研基础分数：</label><span id="kyjcfs" class="detail-text"></span>
          </div>
        </div>
      </div>
      
      <div class="detail-section">  
        <div class="row detail-row">
          <div class="span8">
            <label>超额绝对分：</label><span id="cejdf" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>科研基础奖金：</label><span id="kyjcjj" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>科研超额奖金：</label><span id="kycejj" class="detail-text"></span>
          </div>
        </div>
      </div>
      
      <div class="detail-section">  
        <div class="row detail-row">
          <div class="span8">
            <label>科研奖励合计：</label><span id="kyjlhj" class="detail-text"></span>
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
		 url : '../controller/KYSJKController.jsp',
		 data : {
		 "op" : "personal",
		 "year" : year
		 },
		 dataType:"json",
		 success : function(jsonData) {
			$("#lwdf").text(jsonData[0].lwdf);
			$("#xmdf").text(jsonData[0].xmdf);
			$("#zzdf").text(jsonData[0].zzdf);
			$("#zldf").text(jsonData[0].zldf);
			$("#dfhj").text(jsonData[0].dfhj);
			$("#bzf").text(jsonData[0].bzf);
			$("#cefz").text(jsonData[0].cefz);
			$("#kyjcfs").text(jsonData[0].kyjcfs);
			$("#cejdf").text(jsonData[0].cejdf);
			$("#kyjcjj").text(jsonData[0].kyjcjj);
			$("#kycejj").text(jsonData[0].kycejj);
			$("#kyjlhj").text(jsonData[0].kyjlhj);
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
