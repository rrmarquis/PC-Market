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
</head>
<body style="width: 100%; display: flex; flex-direction: column; align-items: center;">
	<div style="width: 100%; height: 80px; display: flex; justify-content: center; background-color: black;">
		<div style="width: 800px; height: 100%; display: flex; background-color: #ff0026;">
			<div style="width: 50%; height: 100%; display: flex; align-items: center; padding-left: 20px; font-size: 24px;"><a href="CurrentListings.jsp" style="color: black; text-decoration: none;">PC Market</a></div>
			<div style="width: 50%; height: 100%; padding-right: 20px; display: flex; align-items: center; justify-content: flex-end;">
				<% if (userID != null) {%>
					<a href="Account.jsp" style="color: black; text-decoration: none;">View Account</a>
				<%} else {%>
					<a href="Login.jsp" style="color: black; text-decoration: none;">Login</a>
				<%} %>
	  		</div>
		</div>
	</div>
	<div style="width: 800px; padding-left: 20px;">
		<form action="FollowingConfirmation.jsp" style="padding-top: 5px; display: flex; flex-direction: column; width: 300px;">
			<h1>CPU</h1>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Number of Cores: </label><input type="text" name="cores"></div>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Frequency: </label><input type="text" name="frequency"></div>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Socket Type: </label><input type="text" name="socket"></div>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Price: </label><input type="text" name="price"></div>
			<div style="padding-top: 2px;"><input type="submit" value="Create"></div>
			<input type="hidden" name="partType" value="CPU"> 
		</form>
		<form action="FollowingConfirmation.jsp" style="padding-top: 5px; display: flex; flex-direction: column; width: 300px;">
			<h1>GPU</h1>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Clock Speed: </label><input type="text" name="clockSpeed"></div>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Interface Type: </label><input type="text" name="interf"></div>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Memory: </label><input type="text" name="memory"></div>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Price: </label><input type="text" name="price"></div>
			<div style="padding-top: 2px;"><input type="submit" value="Create"></div>
			<input type="hidden" name="partType" value="GPU"> 
		</form>
		<form action="FollowingConfirmation.jsp" style="padding-top: 5px; display: flex; flex-direction: column; width: 300px;">
			<h1>Hard Drive</h1>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Storage Space: </label><input type="text" name="storage"></div>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Rotations per Minute: </label><input type="text" name="rpm"></div>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Price: </label><input type="text" name="price"></div>
			<div style="padding-top: 2px;"><input type="submit" value="Create"></div>
			<input type="hidden" name="partType" value="Hard Drive"> 
		</form>
		<form action="FollowingConfirmation.jsp" style="padding-top: 5px; display: flex; flex-direction: column; width: 300px;">
			<h1>Motherboard</h1>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Expansion Slots: </label><input type="text" name="expansion"></div>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Socket Type: </label><input type="text" name="socket"></div>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Price: </label><input type="text" name="price"></div>
			<div style="padding-top: 2px;"><input type="submit" value="Create"></div>
			<input type="hidden" name="partType" value="Motherboard"> 
		</form>
		<form action="FollowingConfirmation.jsp" style="padding-top: 5px; display: flex; flex-direction: column; width: 300px;">
			<h1>RAM</h1>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Type: </label><input type="text" name="type"></div>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Capacity: </label><input type="text" name="capacity"></div>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Speed: </label><input type="text" name="speed"></div>
			<div style="padding-top: 2px; padding-bottom: 2px; display: flex; justify-content: space-between;"><label>Price: </label><input type="text" name="price"></div>
			<div style="padding-top: 2px;"><input type="submit" value="Create"></div>
			<input type="hidden" name="partType" value="RAM"> 
		</form>
</body>
</html>