<%-- 
    Document   : login
    Created on : 30.10.2014, 2:03:30
    Author     : Anton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>

<link href="files/style.css" rel="stylesheet" type="text/css" />
<style>
    #wrapper {
	width: 300px;
	height: 400px;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -150px;
	margin-top: -180px;
}
    .login-form .footer {
	padding: 25px 30px 25px 30px;
	overflow: auto;
	
	background: #d4dedf;
	border-top: 1px solid #fff;
	
	box-shadow: inset 0 1px 0 rgba(0,0,0,0.15);
	-moz-box-shadow: inset 0 1px 0 rgba(0,0,0,0.15);
	-webkit-box-shadow: inset 0 1px 0 rgba(0,0,0,0.15);
}
</style>
<script type="text/javascript" src="files/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(".username").focus(function() {
		$(".user-icon").css("left","-48px");
	});
	$(".username").blur(function() {
		$(".user-icon").css("left","0px");
	});
	
	$(".password").focus(function() {
		$(".pass-icon").css("left","-48px");
	});
	$(".password").blur(function() {
		$(".pass-icon").css("left","0px");
	});
});
</script>
</head>
<body>

<div id="wrapper">

    <div class="user-icon"></div>
    <div class="pass-icon"></div>

<form name="logForm" class="login-form" method="POST" action="Controller">

    <div class="header">
    <h1>Login</h1>
    <span>Fill out the form below to login to my super awesome control panel!</span>
    </div>
	
    <div class="content">
    <input type="hidden" name="command" value ="login"/>
    <input name="username" type="text" class="input username" value="" onfocus="this.value=''" placeholder="name"/>
    <input name="password" type="password" class="input password" value="" onfocus="this.value=''" placeholder="password"/>
    </div>
    
    <div class="footer">
    <input type="submit" name="submit" value="Login" class="button" />
    <a href="/WebMoney/reg.jsp" class="register" style="text-decoration: none;">Register</a>
    </div>

</form>
</div>

    <div class="gradient"></div>

</body>
</html>