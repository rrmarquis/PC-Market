import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.All_Listings;
import datamodel.Motherboard;
import datamodel.CPU;
import datamodel.GPU;
import datamodel.Hard_Drive;
import util.UtilDBPCMarket;

@WebServlet("/PCMarketServlet")
public class PCMarketServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public PCMarketServlet() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   response.setContentType("text/html");
	   
	   UtilDBPCMarket.createAll_Listings("Core i7-9700K", "CPU", "$250");
	   UtilDBPCMarket.createAll_Listings("Ryzen 7 3800XT", "CPU", "$350");
	   UtilDBPCMarket.createAll_Listings("Core i9-9900K", "CPU", "$350");
	   
	   UtilDBPCMarket.createAll_Listings("RTX 2080 Super Gaming X TRIO", "GPU", "$1000");
	   UtilDBPCMarket.createAll_Listings("GV-N2060OC-6GD ver 2.0", "GPU", "$280");
	   UtilDBPCMarket.createAll_Listings("RX 5700 XT GAMING X", "GPU", "$350");
	   
	   UtilDBPCMarket.createAll_Listings("ST2000DL004", "Hard Drive", "$250");
	   UtilDBPCMarket.createAll_Listings("HD154UI", "Hard Drive", "$60");
	   UtilDBPCMarket.createAll_Listings("WPC101200GSAS-G7", "Hard Drive", "$75");
	   
	   UtilDBPCMarket.createAll_Listings("MPG Z490 GAMING EDGE WIFII", "Motherboard", "$180");
	   UtilDBPCMarket.createAll_Listings("STRIX Z490-E GAMING", "Motherboard", "$225");
	   UtilDBPCMarket.createAll_Listings("Z390 AORUS PRO WIFI", "Motherboard", "$350");
	   
	   UtilDBPCMarket.createCPUs("Intel", "Core i7-9700K", "8-Core", 
			   					 "4.9 GHz", "LGA 1151 (300 Series)", "$250");
	   UtilDBPCMarket.createCPUs("AMD", "Ryzen 7 3800XT", "8-Core", 
								 "4.7 GHz", "Socket AM4", "$350");
	   UtilDBPCMarket.createCPUs("Intel", "Core i9-9900K", "8-Core", 
								 "5.0 GHz", "LGA 1151 (300 Series)", "$350");
	   
	   UtilDBPCMarket.createGPUs("MSI", "RTX 2080 Super Gaming X TRIO", 
								 "1 x HDMI 2.0b 3 x DisplayPort 1.4", 
								 "PCI Express 3.0 x16", "8GB", "$1000");
	   UtilDBPCMarket.createGPUs("GIGABYTE", "GV-N2060OC-6GD ver 2.0", 
								 "1 x HDMI 2.0b 3 x DisplayPort 1.4", 
								 "PCI Express 3.0 x16", "6GB", "$280");
	   UtilDBPCMarket.createGPUs("MSI", "RX 5700 XT GAMING X", 
								 "1 x HDMI 2.0b 3 x DisplayPort 1.4", 
								 "PCI Express 4.0", "8GB", "$350");
	   
	   UtilDBPCMarket.createHard_Drives("Samsung", "ST2000DL004", "2TB", 
										"5400 RPM", "$250");
	   UtilDBPCMarket.createHard_Drives("Samsung", "HD154UI", "1.5TB", 
										"7200 RPM", "$60");
	   UtilDBPCMarket.createHard_Drives("Water Panther", "WPC101200GSAS-G7", "1.2TB", 
										"10000 RPM", "$75");
	   
	   UtilDBPCMarket.createMotherboards("MSI", "MPG Z490 GAMING EDGE WIFI", 
										 "LGA 1200", "2 x PCI Express 3.0 x16", 
										 "ATX", "$180");
	   UtilDBPCMarket.createMotherboards("ASUS", "STRIX Z490-E GAMING", 
										 "LGA 1200", "2 x PCIe 3.0 x16 (x16 or dual x8)", 
										 "ATX", "$225");
	   UtilDBPCMarket.createMotherboards("GIGABYTE", "Z390 AORUS PRO WIFI", 
			   							 "LGA 1151 (300 Series)", 
										 "1 x PCI Express x16 slot, running at x16 (PCIEX16)", 
										 "ATX", "$125");
	   
	   retrieveDisplayData(response.getWriter());
   }

   void retrieveDisplayData(PrintWriter out) {
	   String title = "Database Result";
	   String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
			   			"transitional//en\">\n"; //
	   out.println(docType + //
			   	   "<html>\n" + //
			   	   "<head><title>" + title + "</title></head>\n" + //
			   	   "<body bgcolor=\"#f0f0f0\">\n" + //
			   	   "<h1 align=\"center\">" + title + "</h1>\n");
	   out.println("<ul>");
	   
	   List<All_Listings> allList = UtilDBPCMarket.listAllListings();
	   for (All_Listings lists : allList) {
		   System.out.println("[DBG] " + lists.getId() + ", " //
				   			  + lists.getModelName() + ", " //
				   			  + lists.getPartType() + ", " //
				   			  + lists.getPrice());
		   
		   out.println("<li>" + lists.getId() + ", " //
				   			  + lists.getModelName() + ", " //
				   			  + lists.getPartType() + ", " //
				   			  + lists.getPrice());
	   }
	   
	   List<Motherboard> listMobos = UtilDBPCMarket.listMotherboard();
	   for (Motherboard mobos : listMobos) {
		   System.out.println("[DBG] " + mobos.getId() + ", " //
				   			  + mobos.getManufacturer() + ", " //
				   			  + mobos.getModelName() + ", " //
				   			  + mobos.getSocket() + ", " //
				   			  + mobos.getExpansionSlots() + ", " //
				   			  + mobos.getFormFactor() + ", " //
				   			  + mobos.getPrice());
		   
		   out.println("<li>" + mobos.getId() + ", " //
				   	   + mobos.getManufacturer() + ", " //
		   			   + mobos.getModelName() + ", " //
		   			   + mobos.getSocket() + ", " //
		   			   + mobos.getExpansionSlots() + ", " //
		   			   + mobos.getFormFactor() + ", " //
		   			   + mobos.getPrice() + "</li>");
	   }
	   
	   List<CPU> listCPUs = UtilDBPCMarket.listCPU();
	   for (CPU cpus : listCPUs) {
		   System.out.println("[DBG] " + cpus.getId() + ", " //
				   			  + cpus.getManufacturer() + ", " //
				   			  + cpus.getModelName() + ", " //
				   			  + cpus.getNumOfCores() + ", " //
				   			  + cpus.getFreq() + ", " //
				   			  + cpus.getSocketCompatibility() + ", " //
				   			  + cpus.getPrice());
		   
		   out.println("<li>" + cpus.getId() + ", " //
		   			   + cpus.getManufacturer() + ", " //
		   			   + cpus.getModelName() + ", " //
		   			   + cpus.getNumOfCores() + ", " //
		   			   + cpus.getFreq() + ", " //
		   			   + cpus.getSocketCompatibility() + ", " //
		   			   + cpus.getPrice() + "</li>");
	   }
	   
	   List<GPU> listGPUs = UtilDBPCMarket.listGPU();
	   for (GPU gpus : listGPUs) {
		   System.out.println("[DBG] " + gpus.getId() + ", " //
				   			  + gpus.getManufacturer() + ", " //
				   			  + gpus.getModelName() + ", " //
				   			  + gpus.getPortType() + ", " //
				   			  + gpus.getInterfaceType() + ", " //
				   			  + gpus.getMemorySize() + ", " //
				   			  + gpus.getPrice());
		   
		   out.println("<li>" + gpus.getId() + ", " //
		   			   + gpus.getManufacturer() + ", " //
		   			   + gpus.getModelName() + ", " //
		   			   + gpus.getPortType() + ", " //
		   			   + gpus.getInterfaceType() + ", " //
		   			   + gpus.getMemorySize() + ", " //
		   			   + gpus.getPrice() + "</li>");
	   }
	   
	   List<Hard_Drive> listDrives = UtilDBPCMarket.listHardDrive();
	   for (Hard_Drive drives : listDrives) {
		   System.out.println("[DBG] " + drives.getId() + ", " //
				   			  + drives.getManufacturer() + ", " //
				   			  + drives.getModelName() + ", " //
				   			  + drives.getStorageSpace() + ", " //
				   			  + drives.getRotationsPerMinute() + ", " //
				   			  + drives.getPrice());
		   
		   out.println("<li>" + drives.getId() + ", " //
		   			   + drives.getManufacturer() + ", " //
		   			   + drives.getModelName() + ", " //
		   			   + drives.getStorageSpace() + ", " //
		   			   + drives.getRotationsPerMinute() + ", " //
		   			   + drives.getPrice() + "</li>");
	   }
	   out.println("</ul>");
	   out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
