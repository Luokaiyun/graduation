<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>在线学习系统</title>

    <meta name="keywords" content="">
    <meta name="description" content="">

    <!--link rel="shortcut icon" href="favicon.ico"-->
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="css/index/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="css/index/animate.css" rel="stylesheet">
    <link href="css/index/style.css?v=4.1.0" rel="stylesheet">
    <link rel="stylesheet" href="vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="vendor/font-awesome/css/fontawesome-all.min.css">
   
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id ="header" style="padding-left:30px;height:75px;width:auto;background-color:	#FFFFFF"><!-- style="padding-left:30px;height:75px;width:auto;background-color:#2f4050" -->
     	<div style="float:left;padding-top:15px;font-size:25px">在线学习系统</div>
 	 	<div style="float:right;padding-top:15px;padding-right:30px">
 	 		<a class="nav-link" href="${pageContext.request.contextPath}/jsp/login.jsp" role="button">
 	 			<img src="./imgs/person.png" style="border-radius:50em;width:36px" alt="logo" >
 	 			<span class="ml-1 d-md-down-none" id="userName">
 	 			 <script type="text/javascript" charset="UTF-8">
    					var user="${userName}";
    					if(user!=""){
    						document.getElementById('userName').innerHTML=user;
    						sessionStorage.setItem('userName',user);
    					}
    					else{
    						document.getElementById('userName').innerHTML="请登录";
    					}
    			</script>
 	 			</span>
 	 		</a>
 	 	</div>
 	 	
 </div>
<!--主体-->

<div id="wrapper">
    <!--div class="dashbard-1" id="title">
        <img src="img/title.png">
    </div-->
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i></div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">&nbsp;</span>
                </li>
                <li>
					<a href="${pageContext.request.contextPath}/jsp/start.jsp"><i class="fas fa-university"></i> <span class="nav-label">首页</span></a>
                <li>
                    <a href="#"><i class="fas fa-book"></i><span class="nav-label"> 课程</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath}/getclass?chapterId=1">第一章</a></li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath}/getclass?chapterId=2">第二章</a></li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath}/getclass?chapterId=3">第三章</a></li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath}/getclass?chapterId=4">第四章</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fas fa-pencil-alt"></i><span class="nav-label">练习</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" id="getexam">智能组卷</a></li>
                        <li><a class="J_menuItem" id="history">做题历史</a></li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath}/jsp/chapterExam.jsp">章节练习</a></li>
                    </ul>
                </li>

                <li>
                    <a href="#"><i class="fas fa-clipboard"></i> <span class="nav-label">笔记</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath}/jsp/writeNote.jsp">记笔记</a></li>
                        <li><a class="J_menuItem" id="shownote">查看笔记</a></li>
                    </ul>
                </li>
                <li>
                    <a class="J_menuItem" href="${pageContext.request.contextPath}/getProblem"><i class="fas fa-comments"></i> <span class="nav-label">在线交流</span></a>
                </li>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row J_mainContent" id="content-main">
            <iframe id="J_iframe" src="" width="100%" height="100%" frameborder="0" data-id=" seamless"></iframe>
        </div>
    </div>
    <!--右侧部分结束-->
    <!--内容
    <div1 id="content">

    </div1>-->
</div>

<!-- 全局js -->
<script src="js/jquery/jquery-3.1.1.min.js?v=2.1.4"></script>

<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="js/index/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="js/index/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="js/index/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="js/index/hAdmin.js?v=4.1.0"></script>
<script type="text/javascript" src="js/index/index.js"></script>

<script type="text/javascript">
    $(function(){
    	var value="${pageContext.request.contextPath}/show?userName="+sessionStorage.getItem("userName");
    	$("#shownote").attr("href",value);
    	var value="${pageContext.request.contextPath}/getExam?userName="+sessionStorage.getItem("userName");
    	$("#getexam").attr("href",value);
    	var value="${pageContext.request.contextPath}/getExamHistory?userName="+sessionStorage.getItem("userName");
    	$("#history").attr("href",value);
    });
</script>
</body>

</html>
