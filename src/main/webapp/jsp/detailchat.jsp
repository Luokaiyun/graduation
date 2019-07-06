<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			var anslist=${anslist}
			var problemContent=sessionStorage.getItem('problemContent');
			var popContent=' <div class="card text-white border-0"><div class="card-body bg-dark">'+problemContent+'</div></div>';
			if(anslist!=0){
				for(var i in anslist){
					popContent=popContent+'<div class="card"><div class="card-header border border-top-0 border-right-0 border-left-0">'+
					anslist[i].ansAuthor+'</div><div class="card-body">'+anslist[i].ansContent+'</div></div>';
				}
			}
			document.getElementById('show').innerHTML=popContent;
		});
		function saveFunction(){
			var ansContent=document.getElementById("ansContent").value;
			var json={};
			json.ansContent=ansContent;
			json.problemId=sessionStorage.getItem('problemId');
			json.author=sessionStorage.getItem("userName");
			$.ajax({
   			 type:'POST',
   			 data:JSON.stringify(json),
   			 contentType:'application/json',
   			 dataType:'json',
   			 url:'${pageContext.request.contextPath}/insertAns',
   			 success:function(data){
   				location.reload();
   			 },
   			 error:function(e){
   				 alert("发送失败");
   			 }
   		 });    
		}
		</script>
</head>
<body>
<div class="panel-body" style="padding-bottom:0px;">
	<div>
	<button class="btn btn-link" onclick="window.history.back()">返回</button>
	</div>
	<div id="show">
	</div>
	<textarea id="ansContent" rows="10" cols="150" placeholder="写下你的回答吧……"></textarea>
	<button class="btn btn-rounded btn-info" onclick="saveFunction()">发布</button>
</div>
</body>
</html>