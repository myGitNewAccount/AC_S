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
        <b>Name:</b> ${admin}
    </div>
    <div style="font-size: 12pt;background: #ECECEC;padding: 20px 0px 20px 15px;margin-top: -58px; margin-left:150px;">
          ${user.puserName}
    </div>
    <div style="width: 120px; font-size: 12pt;background: rgba(215, 228, 237, 0.7);padding: 20px 0px 20px 15px;margin-top: 15px;">
        <b>Surname:</b>
    </div>
    <div style="font-size: 12pt;background: #ECECEC;padding: 20px 0px 20px 15px;margin-top: -58px; margin-left:150px;">
          ${user.puserSurname}
    </div>
    <div style="width: 120px; font-size: 12pt;background: rgba(215, 228, 237, 0.7);padding: 20px 0px 20px 15px;margin-top: 15px;">
        <b>Patronymic:</b>
    </div>
    <div style="font-size: 12pt;background: #ECECEC;padding: 20px 0px 20px 15px;margin-top: -58px; margin-left:150px;">
          ${user.puserPatronymic}
    </div>
    <div style="width: 120px; font-size: 12pt;background: rgba(215, 228, 237, 0.7);padding: 20px 0px 20px 15px;margin-top: 15px; margin-bottom: -5px;">
        <b>Requests:</b>
    </div>
    <div style="font-size: 12pt; color: rgba(22, 174, 19, 0.57); background: #ECECEC;padding: 20px 0px 20px 15px;margin-top: -58px; margin-left:150px; margin-bottom: -5px;">
        <b>${txscount} TXS</b>
    </div>
    <div style="text-align: center; background: rgba(221, 189, 216, 0.24); width: 120px; font-size: 12pt;padding: 20px 0px 20px 0px;margin-top: -58px; margin-bottom: -5px; margin-left: 520px;">
        <b>User ID:</b> ${user.puserId} ${ec}
    </div>
    <a id="textout" href="#" onclick="fade()"><div style="min-height: 40px;  background: rgba(205, 218, 203, 0.47);margin-top: 20px;"><img src="files/icon1.png" style="opacity: 0.25; margin-top: 6px; margin-left: 305px;"></div></a>
    <div id="text" style="display: none;">
        
    <c:set var="admin" value="${mID}"/>
    <c:if test="${admin == 0}">
    <div style="font-size: 12pt;background: #ECECEC;padding: 20px 0px 20px 15px;margin-top: 15px; margin-bottom: -5px;">
        <b>Create new request:</b><br></br>
        Get the access to the OS with the help of AD account creation.<br></br>
        <div class="footer" style="margin-right: 15px;">
            <form name="newtxForm" method="POST" action="Controller">
                <input type="hidden" name="command" value ="newtx"/>
                <input name="username" type="hidden" value="${username}"/>
                <input name="password" type="hidden" value="${password}"/>
                <input style="margin-right: 160px;" type="submit" name="submit" value="      Build      " class="button"/>
            </form>
        </div>
    </div>
    <div style="font-size: 12pt;background: #ECECEC;padding: 20px 0px 20px 15px;margin-top: 15px; margin-bottom: -5px;">
        <b>My requests:</b>
        <c:forEach var="req" items ="${myreq}">
        <div class="footer" style="margin-right: 15px; margin-top:20px;">
          ${req}
        </div>
        </c:forEach>
          <!--<input name="ybankacc" type="text" class="input password" value="" onfocus="this.value=''" placeholder="your bank account"/>
          <input name="ybankaccmoney" type="text" class="input password" value="" onfocus="this.value=''" placeholder="money"/>-->
    </div>
    </c:if>
    <c:if test="${admin == 1}">
    <div style="font-size: 12pt;background: #ECECEC;padding: 20px 0px 20px 15px;margin-top: 15px; margin-bottom: -5px;">
        <b>Requests to approve:</b><br></br>
        <c:set var="index" value="-1"/>
        <c:forEach var="txone" items ="${txstoappr}">
        <c:set var="index" value="${index + 1}"/>
        <form name="apprForm" method="POST" action="Controller">
        <div class="footer" style="margin-right: 15px;">
            ${txone}
            Index: ${index}
            <input type="hidden" name="command" value ="apprtx"/>
            <input name="username" type="hidden" value="${username}"/>
            <input name="password" type="hidden" value="${password}"/>
            <input name="index" type="hidden" value="${index}"/>
        </div>
        <div class="footer" style="margin-right: 15px; margin-bottom: 25px;">
            <input style="margin-right: 160px;" type="submit" name="submit" value="Approve" class="button"/>
        </div>
        </form>
        <br>
        </c:forEach>
    </div>
    </c:if>
          
    <div style="font-size: 12pt;background: #ECECEC;padding: 20px 0px 20px 15px;margin-top: 15px; margin-bottom: -5px;">
        <b>Current blocks amount in the blockchain:</b><br></br>
          ${blocksamount}
          <!--<input name="bankaccount" type="text" class="input password" value="" onfocus="this.value=''" placeholder="bank account"/>
          <input name="bankaccmoney" type="text" class="input password" value="" onfocus="this.value=''" placeholder="money"/>-->
    </div>
    <div style="font-size: 12pt;background: #ECECEC; padding: 20px 0px 20px 15px;margin-top: 15px; margin-bottom: -5px;">
        <b>Best block:</b><br></br>
        <div class="footer" style="margin-right: 15px;">
          ${bestblock}
        </div>
          <!--<input name="purseid" type="text" class="input password" value="" onfocus="this.value=''" placeholder="other purse id"/>
          <input name="pursemoney" type="text" class="input password" value="" onfocus="this.value=''" placeholder="money"/>-->
    </div>
    <!--<div style="font-size: 12pt;background: #ECECEC;padding: 20px 0px 20px 15px;margin-top: 15px; margin-bottom: -5px;">
        <b>Deposit funds:</b><br></br>
          <input name="ybankacc" type="text" class="input password" value="" onfocus="this.value=''" placeholder="your bank account"/>
          <input name="ybankaccmoney" type="text" class="input password" value="" onfocus="this.value=''" placeholder="money"/>
    </div>-->
    </div>
    </div>
    <div class="footer">
    <input type="hidden" name="command" value ="exec"/>
    <input style="margin-right: 160px;" type="submit" name="submit" value="Execute" class="button"/>
</form>
    <form name="logoutForm" method="POST" action="Controller">
    <input type="hidden" name="command" value ="logout"/>
    <input type="submit" name="submit" value="Logout" class="register" />
    </form>
    </div>

</div>
        <div id="end"></div>
    <div class="gradient"></div>
</body>
</html>
