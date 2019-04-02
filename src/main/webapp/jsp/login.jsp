<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录</title>
    <link rel="stylesheet" href="../vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="../vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="../css/styles1.css">    
</head>
<body>
<div class="page-wrapper flex-row align-items-center" >
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card p-4">
                <form action="../login" method="POST" onsubmit="return login();">
                    <div class="card-header text-center text-uppercase h4 font-weight-light">
                       	 登录	
                    </div>

                    <div class="card-body py-5" >
                        <div class="form-group">
                            <label class="form-control-label">用户名</label>
                            <input type="text"  class="form-control" name="userName">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">密码</label>
                            <input type="password"  class="form-control" name="userPassword">
                        </div>

                    </div>

                    <div class="card-footer">
                        <div class="row">
                            <div class="col-6">
                                <button type="submit" class="btn btn-primary px-5">登录</button>
                            </div>
                            
                            <div class="col-6">
                                <a href="#" class="btn btn-link">忘记密码？</a>
                            </div>
                        </div>
                    </div>
                   </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/popper.js/popper.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="../vendor/chart.js/chart.min.js"></script>
<script src="../js/carbon.js"></script>
<script src="../js/demo.js"></script>
<script type="text/javascript">
    $(function(){
    	var mes=getQueryVariable("message");
    	if(mes!=""){
    		alert(mes);
    	}
    });
    function getQueryVariable(variable)
    {
           var query = window.location.search.substring(1);
           var vars = query.split("&");
           for (var i=0;i<vars.length;i++) {
                   var pair = vars[i].split("=");
                   if(pair[0] == variable){return pair[1];}
           }
           return(false);
    }
    function login() {
    	var userName = document.getElementsByName("userName").toString;
    	// console.info(userName)
    	var userPass = document.getElementsByName("userPassword").toString;
    	// console.info(userPass);
    	if (userName == "" || userName == null) {
    		alert("用户名不能为空");
    		return false;
    	} else if (userPass == "" || userPass == null) {
    		alert("密码不能为空");
    		return false;
    	} else {
    		return true;
    	}
    }
   </script>
</body>
</html>