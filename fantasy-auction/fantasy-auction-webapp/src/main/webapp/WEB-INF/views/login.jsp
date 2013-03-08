<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head><title>Login</title>
</head>
<body>
<h1>Please Log In to Your Account</h1>

<form action="/fantasy-auction-webapp/j_spring_openid_security_check" method="post">
	<input name="openid_identifier" type="hidden" value="https://me.yahoo.com"/>
	<input type="image" src="http://l.yimg.com/a/i/reg/openid/buttons/8.png" alt="Login with Yahoo!" />	
</form>
</body>
</html>