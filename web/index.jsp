<%-- 
    Document   : main
    Created on : 30.10.2014, 3:17:08
    Author     : Anton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Intro</title>

<link href="files/stylemain.css" rel="stylesheet" type="text/css">
    <style>
        .login-form .header {
	padding: 0px 0px 0px 40px;
        }
        .login-form .content {
	padding: 0 30px 10px 30px;
        }
        .by {
	width:100%;
	position:relative;
	z-index:100;
	margin:0 auto;
        }
    </style>
<script type="text/javascript" src="files/jquery.min.js"></script>
<script type="text/javascript" src="files/jquery-ui.min.js"></script>
<script type="text/javascript" src="files/text.js"></script>
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
<div name="" class="login-form">
<form name="execForm" method="POST" action="Controller">
    <div class="header" style="background-color: #E8E8E8;">
        <h1>AC System</h1>
        <span>The easiest way to manage!</span>
    </div>
    <div class="content">
        <img src="files/logo.png" style="margin-left: 140px;">
    </div>
    <div class="footer">
        <a href="/WebMoney/login.jsp" class="button" style="text-decoration: none; margin-right: 160px;">Login</a>
        <a href="/WebMoney/reg.jsp" class="register" style="text-decoration: none;">Register</a>
    </div>
</form>
</div>
    <div class="gradient"></div>
</body>    
<div class="by" style="text-align: center; color: #627886;">by Boretskyi Anton</div>
</html>
