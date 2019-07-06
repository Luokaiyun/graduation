<%@page language="java" contentType="text/html; charset=UTF-8"  import="java.util.*"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
		<title>在线学习系统</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width"/>
        <!-- 引入bootstrap样式 -->
        <link href="https://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <!-- 引入bootstrap-table样式 -->
        <link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
        <link href="css/styles1.css" rel="stylesheet">
        <!-- jquery -->
        <script src="https://cdn.bootcss.com/jquery/2.2.3/jquery.min.js"></script>
    	<script src="https://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    	<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
    	<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
    	<script type="text/javascript" charset="UTF-8">
    	$(function(){
    		var json=${ExamHistorys};
    		var popContent='';
    		if(json!=0){
    			for(var i in json){
    				popContent=popContent+'<div class="card"><div class="card-header border border-top-0 border-right-0 border-left-0">'+json[i].CreateTime+'</div><div class="card-body">'+json[i].ExamName+'<br/>分数：'+json[i].score+'</div></div>';
    			}
    		}
    		else{
    			popContent=popContent+'你还没有练习过哦！';
    		}
    		document.getElementById('show').innerHTML=popContent;
    		
    	});
    	function detailFunction(parameter){
    		var json=${ExamHistorys};
    		if(json!=0){
    			var url='${pageContext.request.contextPath}/examDetails?examId='+json[parameter].ExamId;
    			location.href=url;
    		}
    	}
    	</script>
</head>
<body>
<div class="panel-body" style="padding-bottom:0px;" id="show">

</div>
</body>
</html>