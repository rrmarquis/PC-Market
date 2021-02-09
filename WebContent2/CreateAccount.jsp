<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="util2.UtilDBPCMarket" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/CreateAccount.css">
</head>
<body>
	<div class="inner-container">
		<form action="Account.jsp" style="display: flex; flex-direction: column; width: 300px;">
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>name: </label><input type="text" name="name"></div>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>email: </Label><input type="text" name="email"></div>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>password: </label><input type="text" name="password"></div>
			<div style="display: flex; justify-content: center;"><input type="submit" value="Create"></div>
			<% if (request.getParameter("emailInUse") == "T") {%>
				<div style="padding-top: 2px; display: flex; justify-content: center;">That email is in use. Try again.</div>
			<%} %>
		</form>
	</div>
</body>
</html>