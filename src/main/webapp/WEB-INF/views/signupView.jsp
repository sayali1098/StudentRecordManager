<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Smart Manager</title>
	<link type="text/css" rel="stylesheet" href="./css/style1.css">
	
</head>
<body>
	<nav>
	        <img src="./assets/logo.png" alt="logo" />
	        <h3> Smart Manager</h3>
	        <ul>
	        	<li> <a href="${pageContext.request.contextPath}/login">Login</a></li>
	            <li> <a href="${pageContext.request.contextPath}/signup">Sign Up</a></li>
	        </ul>
	</nav>
	    <div class="welcome-back">Smart Manager</div>
	    <div class="sub-text">This is a Student Record Management System.</div>
	    <img class="login-illustration" src="./assets/illustration on sign up page.svg" alt="">
	    <div class="signup-form">
	        <div class="title">SIGN UP</div>
	        <form action="${pageContext.request.contextPath}/signup" method="post">
	            <label class="label" for="email">Email</label>
	            <input type="text" name="email" id="email">
	            <label class="label" for="password">Password</label>
	            <input type="password" name="password" id="password">
	            <div class="password-hint">Must consist of at least 8 characters, a symbol, an upper and a lower case letter
	            </div>
	            <label class="label" for="password">Confirm Password</label>
	            <input type="password" name="confirmPassword" id="password">
	            ${message}
	            <button class="button" type="submit">Sign In</button>
	        </form>
	    
	    </div>
</body>
</html>