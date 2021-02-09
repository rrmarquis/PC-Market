<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="datamodel.All_Listings"%>
<%@page import="datamodel.CPU"%>
<%@page import="datamodel.GPU"%>
<%@page import="datamodel.Hard_Drive"%>
<%@page import="datamodel.Motherboard"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
  <head> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
   <title>Product List</title> 
  </head> 
  <body> 
      <h1 align="center">PC-Market Product List</h1>
      <br>
      <h2 align="center">CPUs</h2>
      <div style="width:600px; height:250px; overflow:auto; margin-left: auto; margin-right: auto;">
      	<table border ="1" width="500" align="center">
      		<tr bgcolor="FFFFFF">
      			<th><b>ID</b></th>
      			<th><b>Manufacturer</b></th>
      			<th><b>Model Name</b></th>
      			<th><b>Number of Cores</b></th>
      			<th><b>Frequency</b></th> 
      			<th><b>Socket Type</b></th>
      			<th><b>Price</b></th>
      			<th><b>Buy</b></th>
   			</tr> 
	         
			<%List<CPU> cpu =  (List<CPU>)request.getAttribute("cpus");
			
			for(CPU c : cpu){%>
			<tr>
				<td><%=c.getId()%></td>
				<td><%=c.getManufacturer()%></td> 
				<td><%=c.getModelName()%></td> 
				<td><%=c.getNumOfCores()%></td> 
				<td><%=c.getFreq()%></td> 
				<td><%=c.getSocketCompatibility()%></td>
				<td><%=c.getPrice()%></td>
				<td><form action="BuyServlet" method="post">
					<button type="submit" name="id" value=<%=c.getId()%>>Buy</button>
				</form>
			</tr> 
			<%}%>
		</table>
		</div>
        
        <br>
        <h3 align="center">GPUs</h3> 
        <table border ="1" width="500" align="center">
			<tr bgcolor="FFFFFF">
				<th><b>ID</b></th> 
				<th><b>Manufacturer</b></th> 
				<th><b>Model Name</b></th> 
				<th><b>Port Type</b></th> 
				<th><b>Interface Type</b></th>
				<th><b>Memory Size</b></th>
				<th><b>Price</b></th>
			</tr> 
		   
			<%List<GPU> gpu =  (List<GPU>)request.getAttribute("gpus");
			
			for(GPU g : gpu){%> 
			<tr>
				<td><%=g.getId()%></td>
				<td><%=g.getManufacturer()%></td> 
				<td><%=g.getModelName()%></td> 
				<td><%=g.getPortType()%></td>
				<td><%=g.getInterfaceType()%></td> 
				<td><%=g.getMemorySize()%></td>
				<td><%=g.getPrice()%></td>
			</tr> 
			<%}%> 
		</table>
        
        <br>
        <h4 align="center">Hard Drives</h4>
		<table border ="1" width="500" align="center"> 
			<tr bgcolor="FFFFFF">
				<th><b>ID</b></th>
				<th><b>Manufacturer</b></th>
				<th><b>Model Name</b></th> 
				<th><b>Storage Size</b></th> 
				<th><b>RPM</b></th>
				<th><b>Price</b></th>
			</tr> 
        
			<%List<Hard_Drive> hd =  (List<Hard_Drive>)request.getAttribute("hds");
        
			for(Hard_Drive h : hd){%> 
			<tr>
				<td><%=h.getId()%></td> 
				<td><%=h.getManufacturer()%></td>
				<td><%=h.getModelName()%></td> 
				<td><%=h.getStorageSpace()%></td> 
				<td><%=h.getRotationsPerMinute()%></td>
				<td><%=h.getPrice()%></td>
			</tr> 
			<%}%>
		</table>
          
        <br>
       
        <h5 align="center">Motherboards</h5>
        <table border ="1" width="500" align="center"> 
			<tr bgcolor="FFFFFF">
				<th><b>ID</b></th>
				<th><b>Manufacturer</b></th>
				<th><b>Model Name</b></th>  
				<th><b>Socket Type</b></th> 
				<th><b>Expansion Slots</b></th>
				<th><b>Form Factor</b></th>
				<th><b>Price</b></th>
			</tr> 
       
       		<%List<Motherboard> mobo =  (List<Motherboard>)request.getAttribute("mobos");
        
			for(Motherboard m : mobo){%> 
			<tr> 
				<td><%=m.getId()%></td>
				<td><%=m.getManufacturer()%></td>
				<td><%=m.getModelName()%></td> 
				<td><%=m.getSocket()%></td> 
				<td><%=m.getExpansionSlots()%></td>
				<td><%=m.getFormFactor()%></td>
				<td><%=m.getPrice()%></td>
			</tr> 
			<%}%>
		</table>
		
		<br>
        <h6 align="center">All Listings</h6> 
        <table border ="1" width="500" align="center">
			<tr bgcolor="FFFFFF">
				<th><b>ID</b></th> 
				<th><b>Model Name</b></th> 
				<th><b>Part Type</b></th> 
				<th><b>Price</b></th>
			</tr> 
		   
			<%List<All_Listings> allList =  (List<All_Listings>)request.getAttribute("allList");
			
			for(All_Listings a : allList){%> 
			<tr>
				<td><%=a.getId()%></td>
				<td><%=a.getModelName()%></td> 
				<td><%=a.getPartType()%></td>
				<td><%=a.getPrice()%></td>
			</tr> 
			<%}%> 
		</table>
        <br>
        <hr/> 
    </body> 
</html> 