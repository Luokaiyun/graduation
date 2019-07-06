<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
		<title>课程学习</title>
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
			var popContent='';
			var json=${problems};
			if(json==0){
				popContent=popContent+'这里空空如也~';
			}
			else{
				json=${problems};
				for(var i in json){
					popContent=popContent+'<div class="card"><div class="card-header border border-top-0 border-right-0 border-left-0">'+json[i].problemAuthor+'</div><div class="card-body">'+json[i].problemContent+'<button class="btn btn-link" onclick="Gofunction('+i+')">……详情</button></div></div>';
				}
			}
			document.getElementById('show').innerHTML=popContent;
		});
    	function Gofunction(parameter){
    		var problem=${problems};
    		sessionStorage.setItem('problemContent',problem[parameter].problemContent);
    		sessionStorage.setItem('problemId',problem[parameter].problemId);
    		var url='${pageContext.request.contextPath}/getDetailAns?problemId='+problem[parameter].problemId;
    		location.href=url;
		}
    	function GoQuesfunction(){
    		var url='${pageContext.request.contextPath}/jsp/problem.jsp';
		    location.href=url;
    	}
    	</script>
</head>
<body>
<div class="panel-body" style="padding-bottom:0px;" >
	<button class="btn btn-primary" onclick="GoQuesfunction()">
	提问
	</button>
	<div id="show">
	</div>

</div>
</body>
</html>