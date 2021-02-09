<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, util2.AccountsUtil, datamodel2.*"%>
<%
// Check if user is logged in
Integer userID = (Integer) session.getAttribute("userID");
// Log them in or create account depending on where the request is coming from
if (userID == null) {
	String previousPage = request.getHeader("referer");
	if (previousPage.endsWith("Login.jsp")) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		userID = AccountsUtil.loginUser(email, password);
		if (userID != null) {
			session.setAttribute("userID", userID);
		} else {
			request.setAttribute("invalidLogin", "T");
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/Login.jsp");
			disp.forward(request, response);
		}
	} else if (previousPage.endsWith("CreateAccount.jsp")) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (!AccountsUtil.isEmailInUse(email)) {
			userID = AccountsUtil.createUser(name, email, password);
			AccountsUtil.getUser(userID);
			session.setAttribute("userID", userID);
		} else {
			request.setAttribute("emailInUse", "T");
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/CreateAccount.jsp");
			disp.forward(request, response);
		}
	}
}

User user = AccountsUtil.getUser(userID);

List<Listing> currentListings = AccountsUtil.getCurrentListings(userID);
List<Sold_Listing> soldListings = AccountsUtil.getSoldListings(userID);
List<Sold_Listing> purchases = AccountsUtil.getPurchases(userID);
List<Followed_CPU> followedCPUs = AccountsUtil.getFollowedCPU(userID);
List<Followed_GPU> followedGPUs = AccountsUtil.getFollowedGPU(userID);
List<Followed_Hard_Drive> followedHardDrives = AccountsUtil.getFollowedHardDrive(userID);
List<Followed_Motherboard> followedMotherboards = AccountsUtil.getFollowedMotherboard(userID);
List<Followed_RAM> followedRAMs = AccountsUtil.getFollowedRAM(userID);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/Account.css">
</head>
<div class="outer-container">
	<div class="inner-container">
		<h1 style="font-size: 24px;">Welcome, <%=user.getName()%></h1>
		<div style="width: 800px;">
			<div style="height: 50px;float: left; display: flex; align-items: center; font-size: 16px; font-weight: bold;">Currently Selling</div>
			<div style="height: 50px;float: right; display: flex; align-items: center;"><a href="Sell.jsp"><button>List a part</button></a></div>
		</div
		<ul>
		<% 
		if (currentListings.size() == 0) {%>
			<a href="Sell.jsp"><li>None. Click here to list a part</li></a>	
		<%
		} else {
			for (Listing currentListing : currentListings) {
				String imgSrc = "";
				String partType = currentListing.getPartType();
				System.out.println(partType);
				if (partType.equals("CPU")) {
					imgSrc = "photos/genericcpu.jpg";
				} else if (partType.equals("GPU")) {
					imgSrc = "photos/genericgpu.jpg";
				} else if (partType.equals("Motherboard")) {
					imgSrc = "photos/genericmotherboard.jpg";
				} else if (partType.equals("Hard Drive")) {
					imgSrc = "photos/genericharddrive.jpg";
				} else {
					imgSrc = "photos/genericram.jpg";
				}
		%>
				<a href="SingleListing.jsp?listing=<%=currentListing.getPartType() + "," + currentListing.getID()%>">
					<li>
						<div class="image">
							<img src="<%=imgSrc%>">
							<div style="padding-left: 5px;"><%=currentListing.getModelName()%></div>
						</div>
						<div class="price">$<%=currentListing.getPrice()%></div>
					</li>
				</a>
		<%
			}
		}
		%>
		<div style="width: 800px;">
			<div style=" height: 50px; float: left; display: flex; align-items: center;  font-size: 16px; font-weight: bold;">Sold Parts</div>
		</div>	
		<% 
		if (purchases.size() == 0) {%>
			<a href="CurrentListings.jsp"><li>None.</li></a>
		<%} else {
			for (Sold_Listing soldListing : soldListings) {
				String imgSrc = "";
				String partType = soldListing.getPartType();
				if (partType.equals("CPU")) {
					imgSrc = "photos/genericcpu.jpg";
				} else if (partType.equals("GPU")) {
					imgSrc = "photos/genericgpu.jpg";
				} else if (partType.equals("Motherboard")) {
					imgSrc = "photos/genericmotherboard.jpg";
				} else if (partType.equals("Hard Drive")) {
					imgSrc = "photos/genericharddrive.jpg";
				} else {
					imgSrc = "photos/genericram.jpg";
				}
		%>
				<a href="SingleListing.jsp?listing=<%=soldListing.getPartType() + "," + soldListing.getID()%>">
					<li>
						<div class="image">
							<img src="<%=imgSrc%>">
							<div style="padding-left: 5px;"><%=soldListing.getModelName()%></div>
						</div>
						<div class="price">$<%=soldListing.getPrice()%></div>
					</li>
				</a>
		<%	
			}
		} 
		%>
		</ul>
		<div style="width: 100%;">
			<div style="height: 50px; float: left; display: flex; align-items: center; font-size: 16px; font-weight: bold;">Purchases</div>
			<div style="height: 50px; float: right; display: flex; align-items: center; "><a href="CurrentListings.jsp"><button>Shop</button></a></div>
		</div>
		<ul>
		<% 
		if (purchases.size() == 0) {%>
			<a href="CurrentListings.jsp"><li>None. Click here to view the current listings</li></a>
		
		<%
		} else {
			for (Sold_Listing purchase : purchases) {
				String imgSrc = "";
				String partType = purchase.getPartType();
				if (partType.equals("CPU")) {
					imgSrc = "photos/genericcpu.jpg";
				} else if (partType.equals("GPU")) {
					imgSrc = "photos/genericgpu.jpg";
				} else if (partType.equals("Motherboard")) {
					imgSrc = "photos/genericmotherboard.jpg";
				} else if (partType.equals("Hard Drive")) {
					imgSrc = "photos/genericharddrive.jpg";
				} else {
					imgSrc = "photos/genericram.jpg";
				}
		%>
				<li>
					<div class="image">
						<img src="<%=imgSrc%>">
						<div style="padding-left: 5px;"><%=purchase.getModelName()%></div>
					</div>
					<div class="price">$<%=purchase.getPrice()%></div>
				</li>
		<%		
			} 
		}
		%>
		</ul>
		<div style="width: 100%;">
			<div style="height: 50px; float: left; display: flex; align-items: center; font-size: 16px; font-weight: bold;">Currently Following</div>
			<div style="height: 50px; float: right; display: flex; align-items: center; "><a href="CreateFollowing.jsp"><button>Follow a part</button></a></div>
		</div>
		<ul>
		<% 
		if ((followedCPUs.size() + followedGPUs.size() + followedHardDrives.size() + followedMotherboards.size() + followedRAMs.size()) == 0) {
		%>
			<a href="CreateFollowing.jsp"><li>None. Click here to create a following</li></a>
		
		<%
		} else {
			for (Followed_CPU followedCPU : followedCPUs) {
				if (followedCPU.getListingID() != 0) {
		%>
					<a href="SingleListing.jsp?listing=<%="CPU," + followedCPU.getListingID()%>">
						<li style="background-color: yellow">
							<div><%="CPU: " + followedCPU.getCores() + " cores, " + followedCPU.getFrequency() + " frequency, " + followedCPU.getSocket() + " socket"%></div>
							<div class="price"><%="<= $" + followedCPU.getPrice()%></div>
						</li>
					</a>
		<%		
				} else { 
		%>
					<li>
							<div><%="CPU: " + followedCPU.getCores() + " cores, " + followedCPU.getFrequency() + " frequency, " + followedCPU.getSocket() + " socket"%></div>
						<div class="price"><%="<= $" + followedCPU.getPrice()%></div>
					</li>
		<% 
				}
			}
			for (Followed_GPU followedGPU : followedGPUs) {
				if (followedGPU.getListingID() != 0) {
		%>
					<a href="SingleListing.jsp?listing=<%="GPU," + followedGPU.getListingID()%>">
						<li style="background-color: yellow">
						<div><%="GPU: " + followedGPU.getClockSpeed() + "MHz clock speed , " + followedGPU.getInterf() + " interface, " + followedGPU.getMemory() + "GB memory"%></div>
							<div class="price"><%="<= $" + followedGPU.getPrice()%></div>
						</li>
					</a>
		<%		
				} else { 
		%>			<li>
						<div><%="GPU: " + followedGPU.getClockSpeed() + "MHz clock speed , " + followedGPU.getInterf() + " interface, " + followedGPU.getMemory() + "GB memory"%></div>
						<div class="price"><%="<= $" + followedGPU.getPrice()%></div>
					</li>
		<% 
				}
			}
			for (Followed_Hard_Drive followedHardDrive : followedHardDrives) {
				if (followedHardDrive.getListingID() != 0) {
		%>
					<a href="SingleListing.jsp?listing=<%="Hard Drive," + followedHardDrive.getListingID()%>">
						<li style="background-color: yellow">
							<div><%= "Hard Drive: " + followedHardDrive.getRPM() + " rpm, " + followedHardDrive.getStorage() + " TBs storage"%></div>
							<div class="price"><%="<= $" + followedHardDrive.getPrice()%></div>
						</li>
					</a>
		<%		
				} else { 
		%>
					<li>
							<div><%= "Hard Drive: " + followedHardDrive.getRPM() + " rpm, " + followedHardDrive.getStorage() + " TBs storage"%></div>
						<div class="price"><%="<= $" + followedHardDrive.getPrice()%></div>
					</li>
		<% 		}
			}
			for (Followed_Motherboard followedMotherboard : followedMotherboards) {
				System.out.println("followed motherboard id: " + followedMotherboard.getID());
				if (followedMotherboard.getListingID() != 0) {
		%>
					<a href="SingleListing.jsp?listing=<%="Motherboard," + followedMotherboard.getListingID()%>">
						<li style="background-color: yellow">
							<div><%="Motherboard: " + followedMotherboard.getSocket() + "socket, " + followedMotherboard.getExpansionSlots() + "expansion slots"%></div>
							<div class="price"><%="<= $" + followedMotherboard.getPrice()%></div>
						</li>
					</a>
		<%		
				} else { 
		%>
					<li>
						<div><%="Motherboard: " + followedMotherboard.getSocket() + "socket, " + followedMotherboard.getExpansionSlots() + "expansion slots"%></div>
						<div class="price"><%="<= $" + followedMotherboard.getPrice()%></div>
					</li>
		<% 
				}
			}
			for (Followed_RAM followedRAM : followedRAMs) {
				if (followedRAM.getListingID() != 0) {
		%>
					<a href="SingleListing.jsp?listing=<%="RAM," + followedRAM.getListingID()%>">
						<li style="background-color: yellow">
							<div><%="RAM: " + "type " + followedRAM.getType() + ", " + followedRAM.getCapacity() + " capacity, " + followedRAM.getSpeed() + " speed"%></div>
							<div class="price"><%="<= $" + followedRAM.getPrice()%></div>
						</li>
					</a>
		<%		
				} else { 
		%>
					<li>
						<div><%="RAM: " + "type " + followedRAM.getType() + ", " + followedRAM.getCapacity() + " capacity, " + followedRAM.getSpeed() + " speed"%></div>
						<div class="price"><%="<= $" + followedRAM.getPrice()%></div>
					</li>
		<% 
				}
			}
	  	}
	  	%>
		</ul>
		<div style="width: 800px; display: flex; justify-content: center; padding-top: 10px;"><a href="Login.jsp"><button>Logout</button></a></div>
	</div>
</div>
</html>