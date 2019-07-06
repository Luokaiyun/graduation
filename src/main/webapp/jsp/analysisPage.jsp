<%@page language="java" contentType="text/html; charset=UTF-8"  import="java.util.*"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
     	<title>在线学习系统</title>
        <meta charset="utf-8">
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
    		var ansInfo=${ansInfo};
    		var popContent='';
    		for(var i=0;i<ansInfo.length;i++){
    			var id=i+1;
    			if(ansInfo[i].ansJudge==true){
    				popContent=popContent+'<div class="card-header bg-primary">第'+id+'题：正确答案为'+ansInfo[i].ans+'</div><div class="card-body bg-primary">'+
    				ansInfo[i].ansContent+'</div><br/>';
    			}
    			else{
    				popContent=popContent+'<div class="card-header bg-danger">第'+id+'题：正确答案为'+ansInfo[i].ans+'</div><div class="card-body bg-danger">'+
    				ansInfo[i].ansContent+'</div><br/>';
    			}
    		}
    		document.getElementById('show').innerHTML=popContent;
    	});
    	function getHistoryFunction(){
    		url='${pageContext.request.contextPath}/getExamHistory?userName='+sessionStorage.getItem("userName");
    		location.href=url;
    	}
    	</script>
</head>
<body>
<div class="panel-body" style="padding-bottom:0px;">
	<div>
	<button class="btn btn-primary" onclick="getHistoryFunction()">做题历史</button><br/>
	</div>
	<div id="show"></div>
     
</div>
</body>
</html>
