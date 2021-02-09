<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
session.setAttribute("userID", null);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/Login.css">
</head>
<body>
	<div class="inner-container">
		<form action="Account.jsp" style="display: flex; flex-direction: column; width: 300px;">
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Email: </label><input type="text" name="email"></div>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Password: </label><input type="text" name="password"></div>
			<div style="padding-top: 2px; display: flex; justify-content: center;"><input type="submit" value="login"></div>
		</form>
		<% if (request.getAttribute("invalidLogin") ==  "T") {%>
			<div style="text-align: center;">Try again or create an account</div>
		<%} %>
		<div style="padding-top: 2px; display: flex; justify-content: center;"><a href="CreateAccount.jsp">Create Account</a></div>
	</div>
</body>
</html>