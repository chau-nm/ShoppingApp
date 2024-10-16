<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% String errorMessage = (String) request.getAttribute("errorMessage"); %>

<html>
<head>
	<meta charset="UTF-8">
	<title>${appName} - Login</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/login.css">
</head>
<body>
	<div class="login-page">
		<div class="header" align="center">
			<h1>Login</h1>
		</div>
		<form class="login-form" action="${pageContext.request.contextPath}/auth/login" method="post">
			<% if (errorMessage != null) {%>
				<div class="form-item" align="center">
					<span class="error"><%= errorMessage %></span>
				</div>
			<%}%>
			<div class="form-item">
				<label>Username</label>
				<input type="text" name="username" id="username" placeholder="Username"/>
			</div>
			<div class="form-item">
				<label>Password</label>
				<input type="password" name="password" id="password" placeholder="Password"/>
			</div>
			<div class="form-item">
				<input type="submit" value="Login"/>
			</div>
		</form>
	</div>
</body>
</html>