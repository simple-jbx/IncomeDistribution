<%@ page language="java" pageEncoding="UTF-8" import="bean.YH,java.util.Calendar"%>
<html>
 <head>
  <title>标志性成果数据</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <link href="../static/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="../static/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="../static/assets/css/page-min.css" rel="stylesheet" type="text/css" />   
 </head>


 <body>     
  <div class="container">
    <div class="detail-page">
      <h2>标志性成果信息</h2>
      <div class="detail-section">  
        <div class="row detail-row">
          <div class="span8">
            <label>第一作者：</label><span id="dyzz" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>作者排序：</label><span id="zzpx" class="detail-text"></span>
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
            <label>成果来源：</label><span id="cgly" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>级别：</label><span id="jb" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>分配排序：</label><span id="fppx" class="detail-text"></span>
          </div>
        </div>
      </div>
      
      <div class="detail-section">  
        <div class="row detail-row">
          <div class="span8">
            <label>分配排序比例：</label><span id="fppxbl" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>奖励金额标准：</label><span id="jljebz" class="detail-text"></span>
          </div>
          <div class="span8">
            <label>个人奖励金额：</label><span id="grjlje" class="detail-text"></span>
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
		 url : '../controller/BZXCGSJKController.jsp',
		 data : {
		 "op" : "personal",
		 "year" : year
		 },
		 dataType:"json",
		 success : function(jsonData) {
			$("#dyzz").text(jsonData[0].dyzz);
			$("#zzpx").text(jsonData[0].zzpx);
			$("#cgly").text(jsonData[0].cgly);
			$("#jb").text(jsonData[0].jb);
			$("#fppx").text(jsonData[0].fppx);
			$("#fppxbl").text(jsonData[0].fppxbl);
			$("#jljebz").text(jsonData[0].jljebz);
			$("#grjlje").text(jsonData[0].grjlje);
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
