<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="datamodel.CPU"%>
<%@page import ="datamodel.GPU"%>
<%@page import ="datamodel.Hard_Drive"%>
<%@page import ="datamodel.Motherboard"%>
<%@page import ="datamodel.All_Listings"%>
<%@page import="util.UtilDBPCMarket"%>
<%String id = request.getParameter("id");%>
<%String type = request.getParameter("type");%>
<%All_Listings item = UtilDBPCMarket.searchAllListings(type, id);%>
<%String imgName = null;
if(type.compareTo("Hard Drive") == 0) {
	imgName = "HardDrive.jpg";
}
else {
	imgName = item.getPartType() + ".jpg";
}
System.out.println(imgName);
%>
<!DOCTYPE html>
<html>
<head>
<style>
header {
    background-color:black;
    color:white;
    text-align:center;
    padding:5px;	 
}
nav {
    line-height:30px;
    background-color:#eeeeee;
    height:300px;
    width:100px;
    float:left;
    padding:5px;	      
}
section {
    width:350px;
    float:left;
    padding:10px;	 	 
}
footer {
    background-color:black;
    color:white;
    clear:both;
    text-align:center;
    padding:5px;	 	 
}
</style>
</head>

<body>
<header>
<h1> PC Market </h1>
</header>

<nav>
<a href="http://localhost:8080/PCMarket/DispalyServlet">View All Products</a> <br>
</nav>

<section>
	<h1><%=item.getModelName()%></h1>
	<img src=<%=imgName%> width="200" height="200">
	<br>
	<p1>Price: <%=item.getPrice()%></p1>
	<br>
	<a href="ThankYou.html">Buy</a>
</section>

<footer>
Copyright
</footer>
</body>
</html>