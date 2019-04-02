<%@page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
 	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>在线学习系统</title>
    <link rel="stylesheet" href="vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="css/styles.css">
<title>首页</title>
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <nav class="navbar page-header">
        <a href="#" class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto">
            <i class="fa fa-bars"></i>
        </a>

        <a class="navbar-brand" href="#">
            首页
            <!--img src="./imgs/logo.png" alt="logo"-->
        </a>

        <a href="#" class="btn btn-link sidebar-toggle d-md-down-none">
            <i class="fa fa-bars"></i>
        </a>

        <ul class="navbar-nav ml-auto">
            <li class="nav-item d-md-down-none">
                <a href="#">
                    <i class="fa fa-bell"></i>
                    <!--span class="badge badge-pill badge-danger">5</span>-->
                </a>
            </li>

            <li class="nav-item d-md-down-none">
                <a href="#">
                    <i class="fa fa-envelope-open"></i>
                    <!--<span class="badge badge-pill badge-danger">5</span>-->
                </a>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <img src="imgs/person.png" class="avatar avatar-sm" alt="logo">
                    <span class="small ml-1 d-md-down-none">${userName}</span>
                </a>

                <div class="dropdown-menu dropdown-menu-right">
                    <div class="dropdown-header">账户</div>

                    <a href="#" class="dropdown-item">
                        <i class="fa fa-user"></i> 个人资料
                    </a>

                    <a href="#" class="dropdown-item">
                        <i class="fa fa-lock"></i> 登出
                    </a>
                </div>
            </li>
        </ul>
    </nav>

    <div class="main-container">
        <div class="sidebar">
            <nav class="sidebar-nav">
                <ul class="nav">
                    <li class="nav-title">导航</li>

                    <li class="nav-item">
                        <a href="index.jsp" class="nav-link active">
                            <i class="fas fa-university"></i> 首页
                        </a>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="fas fa-book"></i> 课程 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="/getclass?chapterId=1" class="nav-link">
                                    <i class="fas fa-book"></i> 第一章
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="chapter.jsp" class="nav-link">
                                    <i class="fas fa-book"></i> 第二章
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="chapter.jsp" class="nav-link">
                                    <i class="fas fa-book"></i> 第三章
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="chapter.jsp" class="nav-link">
                                    <i class="fas fa-book"></i> 第四章
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="fas fa-pencil-alt"></i> 练习 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="alerts.html" class="nav-link">
                                    <i class="fas fa-pencil-alt"></i> 智能组卷
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="buttons.html" class="nav-link">
                                    <i class="fas fa-pencil-alt"></i> 章节练习
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="cards.html" class="nav-link">
                                    <i class="fas fa-pencil-alt"></i> 错题练习
                                </a>
                            </li>

                        </ul>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="fas fa-clipboard"></i> 笔记 <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="chartjs.html" class="nav-link">
                                    <i class="fas fa-clipboard"></i> 记笔记
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="chartjs.html" class="nav-link">
                                    <i class="fas fa-clipboard"></i> 查看笔记
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item">
                        <a href="forms.html" class="nav-link">
                            <i class="fas fa-comments"></i> 在线交流
                        </a>
                    </li>

                    
                </ul>
            </nav>
        </div>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-2,col-3">
                        kkkk
                    </div>
                    <div class="col-2">
                        
                    </div>
                    
                </div>

                <div class="row ">
                    <div class="col-2">
                        kkkk
                    </div>

                 
                </div>
            </div>
        </div>
    </div>
</div>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/popper.js/popper.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/chart.js/chart.min.js"></script>
<script src="js/carbon.js"></script>
<script src="js/demo.js"></script>
</body>
</html>
