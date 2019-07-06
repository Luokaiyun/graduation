<%@page language="java" contentType="text/html; charset=UTF-8"  import="java.util.*"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    	<script src="js/biang.min.js"></script>
    	<script type="text/javascript" charset="UTF-8">
    	$(function(){
    		var json=${examInfo};
    		var popContent='';
    		for(var i in json){
    			popContent=popContent+'<div><p>'+json[i].quesContent+'<p><form><input type="radio" name="'+json[i].quesId+'" value="1">'+json[i].optionA+'</br><input type="radio" name="'+json[i].quesId
    			+'" value="2">'+json[i].optionB+'</br><input type="radio" name="'+json[i].quesId+'" value="3">'+json[i].optionC+'</br><input type="radio" name="'+json[i].quesId+'" value="4">'+json[i].optionD+
    			'</br></form></div>';
    		}
    		popContent=popContent+'<div style="margin:0 auto;width:200px;"><button class="btn btn-outline-primary" onclick="sumbitAnsFunction()">提交</button></div>'
    		document.getElementById('show').innerHTML=popContent;
    		//nameArr.push();
    	});	
    	function sumbitAnsFunction(){
    		var ansdata=[];
    		var json=${examInfo};
    		for(var i=0;i<json.length;i++){
    			var id=i+1;
    			var j={};
    			var input='input[name="'+id+'"]:checked';
    			j.ans=$(input).val();
    			j.quesId=id;
    			ansdata.push(j);
    		}
   			 $.ajax({
   			 type:'POST',
   			 data:JSON.stringify(ansdata),
   			 contentType:'application/json',
   			 dataType:'json',
   			 url:'${pageContext.request.contextPath}/checkAns',
   			 success:function(data){
   				var info='您的分数是：'+data;
   				biang.confirm(info, function(yes){
   			        if(yes){
   			        	var url='${pageContext.request.contextPath}/ansAnalysis';
   			        	location.href=url;
   			        }else{
   			            
   			        }
   			    }).show();
   				//alert("发送成功");
   				 
   			 },
   			 error:function(e){
   				 alert("发送失败");
   			 }
   		 });
		}
    	</script>
</head>
<body>
<div class="panel-body" style="padding-bottom:0px;" >
	<div style="padding-bottom:50px;padding-left:200px;padding-top:30px" id="show">
	
	</div>
    
</div>
</body>
</html>