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
        <link href="../css/styles1.css" rel="stylesheet">
        <!-- jquery -->
        <script src="https://cdn.bootcss.com/jquery/2.2.3/jquery.min.js"></script>
    	<script src="https://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    	<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
    	<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
		<script type="text/javascript" charset="UTF-8">
			function saveFunction(){
    		 //var json=[];
    		 var j={};
    		 j.noteTitle=document.getElementById("noteTitle").value;
    		 j.noteContent=document.getElementById("noteContent").value;
    		 j.noteAuthor=sessionStorage.getItem("userName");
    		 //json.push(j);
    		 var data=JSON.stringify(j);
    		 alert(data);
    		 
    		 $.ajax({
    			 type:'POST',
    			 data:data,
    			 contentType:'application/json',
    			 dataType:'json',
    			 url:'../save',
    			 success:function(data){
    				 alert("保存成功");
    				 
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
	<button class="btn btn-rounded btn-info" onclick="saveFunction()">保存</button>
	<div style="padding-top:15px">
	<textarea id="noteTitle" rows="3" cols="150" placeholder="标题" ></textarea>
    <textarea id="noteContent" rows="50" cols="150" placeholder="记笔记…"></textarea>
	</div>
    
</div>
</body>
</html>