<%@ page language="java" import="com.alibaba.fastjson.JSON, bean.YH"
	pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../static/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../static/js/bootstrap/css/bootstrap-table.min.css"
	rel="stylesheet" type="text/css">
<link href="../static/js/bootstrap/css/bootstrap-table.css"
	rel="stylesheet" type="text/css">
<script src="../static/js/table.js"></script>
<script src="../static/js/bootstrap/js/bootstrap.min.js"></script>
<script src="../static/js/bootstrap/js/bootstrap-table.min.js"></script>
<script src="../static/js/bootstrap/js/bootstrap-table-zh-CN.js"></script>
<script src="../static/js/jQuery.js"></script>
<script>
	<%
	YH yh = (YH)session.getAttribute("yh");
	int isNULL = 0;
	if(yh == null)
		isNULL = 1;
	//System.out.println(yh.getGH());
	%>
	if(<%=isNULL%> == 1) {
		alert("请先登录！");
		window.location.href = "../login.jsp";
	}
</script>
<title>表格汇总</title>
</head>
<body>
	<table class="table">
    <thead>
    <tr>
        <th>表格名称</th>
        <th>操作</th>
        <th>分类</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><a href="BDWJCJFFZBB.jsp">本单位奖酬金发放总报表</a> </td>
        <td><a href="BDWJCJFFZBB.jsp">查看</a> </td>
        <td>年终分配</td>
    </tr>
    <tr>
        <td><a href="WDWJCJFFZBB.jsp">外单位奖酬金发放总报表</a></td>
        <td><a href="WDWJCJFFZBB.jsp">查看</a></td>
        <td>年终分配</td>
    </tr>
    <tr>
        <td><a href="ZRJSRY.jsp">专任教师人员 </a></td>
        <td><a href="ZRJSRY.jsp">查看 </a></td>
        <td>年终分配</td>
    </tr>
    <tr>
        <td><a href="XZGLRY.jsp">行政管理人员</a></td>
        <td><a href="XZGLRY.jsp">查看</a> </td>
        <td>年终分配</td>
    </tr>
    <tr>
        <td><a href="GQRY.jsp">工勤人员</a> </td>
        <td><a href="GQRY.jsp">查看</a> </td>
        <td>年终分配</td>
    </tr>
    <tr>
        <td><a href="XYQTRY.jsp">学院其他人员</a></td>
        <td><a href="XYQTRY.jsp">查看</a></td>
        <td>年终分配</td>
    </tr>
    <tr>
        <td><a href="YJSGZSJ.jsp">研究生工作数据 </a></td>
        <td><a href="YJSGZSJ.jsp">查看 </a></td>
        <td>年终分配</td>
    </tr>
    <tr>
        <td><a href="JSXLJSHFWSJ.jsp">竞赛训练及社会服务数据 </a></td>
        <td><a href="JSXLJSHFWSJ.jsp">查看</a></td>
        <td>年终分配</td>
    </tr>
    <tr>
        <td><a href="KYFSTJB.jsp">科研分数统计表</a></td>
        <td><a href="KYFSTJB.jsp">查看</a></td>
        <td>年终分配</td>
    </tr>
    <tr>
        <td><a href="ZHTXGRDFJLXX.jsp">综合体系个人得分奖励信息</a></td>
        <td><a href="ZHTXGRDFJLXX.jsp">查看</a></td>
        <td>年终分配</td>
    </tr>
    <tr>
        <td><a href="GZLJJKXXB.jsp">工作量及监考信息表 </a></td>
        <td><a href="GZLJJKXXB.jsp">查看</a></td>
        <td>年终分配</td>
    </tr>
    <tr>
        <td><a href="XWGJBT.jsp">新闻稿件补贴</a></td>
        <td><a href="XWGJBT.jsp">查看</a></td>
        <td>年终分配</td>
    </tr>
    <tr>
        <td><a href="ELYLXYDHKQ.jsp">2016年学院大会考勤 </a></td>
        <td><a href="ELYLXYDHKQ.jsp">查看</a></td>
        <td>年终分配</td>
    </tr>
    <tr>
        <td><a href="ELYLXYZHGLYFZPJFPJGB.jsp">2016年学院综合管理与发展评价分配结果表 </a></td>
        <td><a href="ELYLXYZHGLYFZPJFPJGB.jsp">查看</a></td>
        <td>年终分配</td>
    </tr>
    <tr>
        <td><a href="ELYLBZXCG.jsp">2016标志性成果</a></td>
        <td><a href="ELYLBZXCG.jsp">查看</a></td>
        <td>年终分配</td>
    </tr>
    <tr>
        <td><a href="XWBTSJ.jsp">新闻补贴数据</a></td>
        <td><a href="XWBTSJ.jsp">查看</a> </td>
        <td>年终分配</td>
    </tr>
    <tr>
        <td><a href="LW.jsp">论文</a> </td>
        <td><a href="LW.jsp">查看 </a></td>
        <td>科研工作基础数据</td>
    </tr>
    <tr>
        <td><a href="XM.jsp">项目 </a></td>
        <td><a href="XM.jsp">查看</a> </td>
        <td>科研工作基础数据</td>
    </tr>
    <tr>
        <td><a href="ZZ.jsp">著作</a></td>
        <td><a href="ZZ.jsp">查看</a></td>
        <td>科研工作基础数据</td>
    </tr>
    <tr>
        <td><a href="HJ.jsp">获奖</a></td>
        <td><a href="HJ.jsp">查看</a> </td>
        <td>科研工作基础数据</td>
    </tr>
    <tr>
        <td><a href="ZL.jsp">专利</a></td>
        <td><a href="ZL.jsp">查看</a></td>
        <td>科研工作基础数据</td>
    </tr>
    </tbody>
</table>
	
</body>
</html>