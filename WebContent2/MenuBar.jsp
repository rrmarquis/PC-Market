<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
Integer userID = (Integer) session.getAttribute("userID");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/MenuBar.css">
</head>
<body>
	<div class="header">
		<div class="inner-header">
			<div class="logo-container"><a href="CurrentListings.jsp" style="color: black;">PC Market</a></div>
			<div style="width: 50%; height: 100%; padding-right: 20px; display: flex; align-items: center; justify-content: flex-end;">
				<% if (userID != null) {%>
					<a href="Account.jsp" style="color: black">View Account</a>
				<%} else {%>
					<a href="Login.jsp" style="color: black">Login</a>
				<%} %>
	  		</div>
		</div>
	</div>
</body>
</html>