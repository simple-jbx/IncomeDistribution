<%@ page language="java" pageEncoding="UTF-8" import="bean.YH,java.util.Calendar"%>
<html>
 <head>
  <title>教学工作量数据</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <link href="../static/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="../static/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="../static/assets/css/page-min.css" rel="stylesheet" type="text/css" />   
 </head>


 <body>     
  <div class="container">
    <div class="detail-page">
      <h2>教学工作量信息</h2>
      <div class="detail-section">  
        <div class="row detail-row">
          <div class="span8">
            <label>兼任职情况：</label><span id="jrzqk" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>职务工作量：</label><span id="zwgzl" class="detail-text"></span>
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
            <label>本科1：</label><span id="bky" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>本科其他1：</label><span id="bkqty" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>本科2：</label><span id="bke" class="detail-text"></span>
          </div>
        </div>
      </div>
      
      <div class="detail-section">  
        <div class="row detail-row">
          <div class="span8">
            <label>本科其他2：</label><span id="bkqte" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>本科听课：</label><span id="bktk" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>研究生教学工作量1：</label><span id="yjsjxgzl1" class="detail-text"></span>
          </div>
        </div>
      </div>
      
      <div class="detail-section">  
        <div class="row detail-row">
          <div class="span8">
            <label>研究生教学工作量2：</label><span id="yjsjxgzle" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>研究生指导工作量2：</label><span id="yjszdgzle" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>工作量合计：</label><span id="gzlhj" class="detail-text"></span>
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
		 url : '../controller/JXGZLSJKController.jsp',
		 data : {
		 "op" : "personal",
		 "year" : year
		 },
		 dataType:"json",
		 success : function(jsonData) {
			$("#jrzqk").text(jsonData[0].jrzqk);
			$("#zwgzl").text(jsonData[0].zwgzl);
			$("#bky").text(jsonData[0].bky);
			$("#bkqty").text(jsonData[0].bkqty);
			$("#bke").text(jsonData[0].bke);
			$("#bkqte").text(jsonData[0].bkqte);
			$("#bktk").text(jsonData[0].bktk);
			$("#yjsjxgzly").text(jsonData[0].yjsjxgzly);
			$("#yjszdgzly").text(jsonData[0].yjszdgzly);
			$("#yjsjxgzle").text(jsonData[0].yjsjxgzle);
			$("#yjsjxzdgzle").text(jsonData[0].yjsjxzdgzle);
			$("#gzlhj").text(jsonData[0].gzlhj);
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
