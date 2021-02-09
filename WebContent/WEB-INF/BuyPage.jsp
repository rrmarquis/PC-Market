<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="datamodel.CPU"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Page</title>
</head>
<body>
<%CPU cpu = (CPU)request.getAttribute("cpu");%>
<%=cpu.getModelName()%>
</body>
</html>