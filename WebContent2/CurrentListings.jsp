<%@page import="java.util.ArrayList, java.util.List, datamodel2.*, util2.UtilDBPCMarket, util2.AccountsUtil"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%
Integer userID = (Integer) session.getAttribute("userID");
%>
<!DOCTYPE html> 
<html> 
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<link rel="stylesheet" type="text/css" href="css/ProductDisplay.css">
	<title>Product List</title> 
</head>  
<body style="width: 100%; display: flex; flex-direction: column; align-items: center;">
	<div style="width: 100%; height: 80px; display: flex; justify-content: center; background-color: black;">
		<div style="width: 800px; height: 100%; background-color: #ff0026;">
			<div style="height: 100%; padding-left: 20px; float: left; display: flex; align-items: center;"><a href="CurrentListings.jsp" style="font-size: 24px; color: black; text-decoration: none;">PC Market</a></div>
			<div style="height: 100%; width: 200px; padding-right: 20px; float: right;">
				<div style="height: 100%; float: left; display: flex; align-items: center;"><a href="EasyBuy.jsp" style="width: 100px; color: black; text-decoration: none;">Easy Buy</a></div>
				<% if (userID != null) {%>
					<div style="height: 100%; float: right; display: flex; align-items: center;"></div><a href="Account.jsp" style="color: black; text-decoration: none;">View Account</a></div>
				<%} else {%>
					<div style="height: 100%; float: right; display: flex; align-items: center;s"><a href="Login.jsp" style="color: black; text-decoration: none;">Login</a></div>
				<%} %>
	  		</div>
		</div>
	</div>
	<ul style="width: 800px;">
		<%
		List<Listing> listings = UtilDBPCMarket.listListings();
		
		if (listings.size() == 0) {
		%>
			<a href="Login.jsp" style="width: 100%; color: black; text-decoration: none;">
				<li style="height: 100px; width: 100%; padding-left: 20px;">There's nothing listed. Click here to get us started!</li>
			</a>
		<%
		} else {
			for (Listing listing : listings) {
				String imgSrc = null;
				String partType = listing.getPartType();
				String id = listing.getID().toString();
				String modelName = listing.getModelName();
				String price = listing.getPrice();
								
				if (partType.equals("CPU")) {
					imgSrc = "photos/genericcpu.jpg";
				} else if (partType.equals("GPU")) { 
					imgSrc = "photos/genericgpu.jpg";
				} else if (partType.equals("Hard Drive")) {
					imgSrc = "photos/genericharddrive.jpg";
				} else if (partType.equals("Motherboard")) { 
					imgSrc = "photos/genericmotherboard.jpg";
				} else if (partType.equals("RAM")) {
					imgSrc = "photos/genericRAM.jpg";
				}
			%>	
				<a href="SingleListing.jsp?listing=<%=partType + "," + id%>" style="width: 100%; color: black; text-decoration: none;">
					<li style="height: 100px; width: 100%; display: flex; flex-direction: row; align-items: center; justify-content: space-between;"> 
						<div class="image" style="height: 100%; margin-left: 20px; display: flex; align-items: center;">
							<img src="<%=imgSrc%>" style="height: 75px; width: 50px;">
							<div style="padding-left: 5px;"><%=modelName%></div>
						</div>
						<div class="price" style="height: 100%; margin-right: 20px; display: flex; align-items: center;">$<%=price%></div>	
					</li>
				</a>
		<%
			}
		}
		%>
	</ul>  
</body>
</html> 