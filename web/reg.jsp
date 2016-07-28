<%-- 
    Document   : reg
    Created on : 30.10.2014, 0:10:24
    Author     : Anton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Registration</title>

<link href="files/style.css" rel="stylesheet" type="text/css" />
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

<form name="regForm" class="login-form" method="POST" action="Controller" >

    <div class="header">
    <h1>Registration Form</h1>
    <span>Fill out the form below to login!</span>
    </div>
	
    <div class="content">
    <input type="hidden" name="command" value ="reg"/>
    <input name="username" type="text" class="input username" value="" onfocus="this.value=''" placeholder="name"/>
    <input name="password" type="password" class="input password" value="" onfocus="this.value=''" placeholder="password"/>
    <input name="usersurname" type="text" class="input password" value="" onfocus="this.value=''" placeholder="surname"/>
    <input name="userpatronymic" type="text" class="input password" value="" onfocus="this.value=''" placeholder="patronymic"/>
    </div>
    
    <div class="footer">
    <input type="submit" name="submit" value="Register" class="button" />
    </div>

</form>
</div>

    <div class="gradient"></div>

</body>
</html>