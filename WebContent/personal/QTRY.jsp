<%@ page language="java" pageEncoding="UTF-8" import="bean.YH,java.util.Calendar"%>
<html>
 <head>
  <title>其他人员数据</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <link href="../static/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="../static/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="../static/assets/css/page-min.css" rel="stylesheet" type="text/css" />   
 </head>


 <body>     
  <div class="container">
    <div class="detail-page">
      <h2>其他人员信息</h2>
      <div class="detail-section">  
        <div class="row detail-row">
          <div class="span8">
            <label>在岗时间系数：</label><span id="zgsjxs" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>考核工作量：</label><span id="khgzl" class="detail-text"></span>
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
            <label>总工作量合计：</label><span id="zgzlhj" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>超工作量：</label><span id="cgzl" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>超工作量奖酬金：</label><span id="cgzljcj" class="detail-text"></span>
          </div>
        </div>
      </div>
      
      <div class="detail-section">  
        <div class="row detail-row">
          <div class="span8">
            <label>教学督导：</label><span id="jxdd" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>第一批次奖酬金：</label><span id="dypcjcj" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>免师工作补发：</label><span id="msgzbf" class="detail-text"></span>
          </div>
        </div>
      </div>
         
      <div class="detail-section">  
        <div class="row detail-row">
          <div class="span8">
            <label>预留补发或扣除金额：</label><span id="ylbfhkcje" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>第三批次分配合计：</label><span id="dspcfphj" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>实际总奖酬金：</label><span id="sjzjcj" class="detail-text"></span>
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
		 url : '../controller/QTRYController.jsp',
		 data : {
		 "op" : "personal",
		 "year" : year
		 },
		 dataType:"json",
		 success : function(jsonData) {
			$("#zgsjxs").text(jsonData[0].zgsjxs);
			$("#khgzl").text(jsonData[0].khgzl);
			$("#zgzlhj").text(jsonData[0].zgzlhj);
			$("#cgzl").text(jsonData[0].cgzl);
			$("#cgzljcj").text(jsonData[0].cgzljcj);
			$("#jxdd").text(jsonData[0].jxdd);
			$("#dypcjcj").text(jsonData[0].dypcjcj);
			$("#msgzbf").text(jsonData[0].msgzbf);
			$("#ylbfhkcje").text(jsonData[0].ylbfhkcje);
			$("#dspcfphj").text(jsonData[0].dspcfphj);
			$("#sjzjcj").text(jsonData[0].sjzjcj);
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
