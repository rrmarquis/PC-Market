<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="util2.FollowUtil"%>
<%
Integer followerID = (Integer) session.getAttribute("userID");
String price = request.getParameter("price");
String partType = request.getParameter("partType");
if (partType.equals("CPU")) {
	String frequency = request.getParameter("frequency");
	String cores = request.getParameter("cores");
	String socket = request.getParameter("socket");
	FollowUtil.followCPU(cores, frequency, socket, price, followerID);
} else if (partType.equals("GPU")) {
	String clockSpeed = request.getParameter("clockSpeed");
	String interf = request.getParameter("interf");
	String memory = request.getParameter("memory");
	FollowUtil.followGPU(clockSpeed, interf, memory, price, followerID);
} else if (partType.equals("Hard Drive")) {
	String storage = request.getParameter("storage");
	String rpm = request.getParameter("rpm");
	FollowUtil.followHardDrive(storage, rpm, price, followerID);
} else if (partType.equals("Motherboard")) {
	String socket = request.getParameter("socket");
	String expansionSlots = request.getParameter("expansion");
	FollowUtil.followMotherboard(expansionSlots, socket, price, followerID);
} else {
	String type = request.getParameter("type");
	String capacity = request.getParameter("capacity");
	String speed = request.getParameter("speed");
	FollowUtil.followRAM(type, capacity, speed, price, followerID);
}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body style="height: 722px; width: 1536px; display: flex; align-items: center; justify-content: center;">
	<div style="width: 500px; display: flex; flex-direction: column; align-items: center; justify-content: center;">
		<p>You will be notified when the part is listed at a price below <%=price %>!<p>
		<a href="Account.jsp"><button>Back to your account</button></a>
	</div>
</body>
</html>