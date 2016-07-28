<%-- 
    Document   : main
    Created on : 30.10.2014, 3:17:08
    Author     : Anton
//////////////////////////////////////////**************DRAFT******************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Account</title>

<link href="files/stylemain.css" rel="stylesheet" type="text/css">
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
<div name="regForm" class="login-form" method="POST" action="Controller">

    <div class="header" style="background: #CBE5E7;">
    <h1>Account management</h1>
    <span>Information about you and the system</span>
    <img style="margin-top: -95px; margin-bottom: -20px; margin-left: 483px; width:150px;" src="files/icon2.png">
    </div>
<form name="execForm" method="POST" action="Controller">
    <div class="content">
    <div style="width: 120px; font-size: 12pt;background: rgba(215, 228, 237, 0.7);padding: 20px 0px 20px 15px;margin-top: 15px;">
        Name: ${bestblock}
    </div>
    <div style="font-size: 12pt;background: #ECECEC;padding: 20px 0px 20px 15px;margin-top: -58px; margin-left:150px;">
          ${user.puserName}
    </div>
    <div style="width: 120px; font-size: 12pt;background: rgba(215, 228, 237, 0.7);padding: 20px 0px 20px 15px;margin-top: 15px;">
        Surname:
    </div>
    <div style="font-size: 12pt;background: #ECECEC;padding: 20px 0px 20px 15px;margin-top: -58px; margin-left:150px;">
          ${user.puserSurname}
    </div>
    <div style="width: 120px; font-size: 12pt;background: rgba(215, 228, 237, 0.7);padding: 20px 0px 20px 15px;margin-top: 15px;">
        Patronymic:
    </div>
    <div style="font-size: 12pt;background: #ECECEC;padding: 20px 0px 20px 15px;margin-top: -58px; margin-left:150px;">
          ${user.puserPatronymic}
    </div>
    <div style="width: 120px; font-size: 12pt;background: rgba(215, 228, 237, 0.7);padding: 20px 0px 20px 15px;margin-top: 15px; margin-bottom: -5px;">
        Your balance:
    </div>
    <div style="font-size: 12pt; color: rgba(22, 174, 19, 0.57); background: #ECECEC;padding: 20px 0px 20px 15px;margin-top: -58px; margin-left:150px; margin-bottom: -5px;">
        <b>${purse.purseMoneyUan} UAN</b>
    </div>
    <div style="text-align: center; background: rgba(221, 189, 216, 0.24); width: 120px; font-size: 12pt;padding: 20px 0px 20px 0px;margin-top: -58px; margin-bottom: -5px; margin-left: 520px;">
        Purse ID: ${purse.purseId}
    </div>
    <a id="textout" href="#end" onclick="fade()"><div style="min-height: 40px;  background: rgba(205, 218, 203, 0.47);margin-top: 20px;"><img src="files/icon1.png" style="opacity: 0.25; margin-top: 6px; margin-left: 305px;"></div></a>
    <div id="text" style="display: none;">
    <div style="font-size: 12pt;background: #ECECEC;padding: 20px 0px 20px 15px;margin-top: 15px; margin-bottom: -5px;">
        <b>Bank account operation:</b><br></br>
          <input name="bankaccount" type="text" class="input password" value="" onfocus="this.value=''" placeholder="bank account"/>
          <input name="bankaccmoney" type="text" class="input password" value="" onfocus="this.value=''" placeholder="money"/>
    </div>
    <div style="font-size: 12pt;background: #ECECEC; padding: 20px 0px 20px 15px;margin-top: 15px; margin-bottom: -5px;">
        <b>Send money:</b><br></br>
          <input name="purseid" type="text" class="input password" value="" onfocus="this.value=''" placeholder="other purse id"/>
          <input name="pursemoney" type="text" class="input password" value="" onfocus="this.value=''" placeholder="money"/>
    </div>
    <div style="font-size: 12pt;background: #ECECEC;padding: 20px 0px 20px 15px;margin-top: 15px; margin-bottom: -5px;">
        <b>Deposit funds:</b><br></br>
          <input name="ybankacc" type="text" class="input password" value="" onfocus="this.value=''" placeholder="your bank account"/>
          <input name="ybankaccmoney" type="text" class="input password" value="" onfocus="this.value=''" placeholder="money"/>
    </div>
    </div>
    </div>
    <div class="footer">
    <input type="hidden" name="mypurseid" value ="${purse.purseId}"/>
    <input type="hidden" name="command" value ="exec"/>
    <input style="margin-right: 160px;" type="submit" name="submit" value="Execute" class="button">
</form>
    <form name="logoutForm" method="POST" action="Controller">
    <input type="hidden" name="command" value ="logout"/>
    <input type="submit" name="submit" value="Logout" class="register" />
    </form>
    </div>

</div>

    <div class="gradient"></div>
    <div id="end"></div>
</body>
</html>
