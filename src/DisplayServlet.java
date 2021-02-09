import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.All_Listings;
import datamodel.CPU;
import datamodel.GPU;
import datamodel.Hard_Drive;
import datamodel.Motherboard;
import util.UtilDBPCMarket;

/**
 * Servlet implementation class DispalyServlet
 */
@WebServlet("/DispalyServlet")
public class DisplayServlet extends HttpServlet {
	List<All_Listings> allList = UtilDBPCMarket.listAllListings();
	List<CPU> cpus = UtilDBPCMarket.listCPU();
	List<GPU> gpus = UtilDBPCMarket.listGPU();
	List<Hard_Drive> hds = UtilDBPCMarket.listHardDrive();
	List<Motherboard> mobos = UtilDBPCMarket.listMotherboard();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        
        //Hard coded products for testing purposes;
        /*
        cpus.add(new CPU(1, "Intel", "Core i7-9700K", "8-Core", "4.9 GHz", "LGA 1151 (300 Series)", "$250"));
		cpus.add(new CPU(2, "AMD", "Ryzen 7 3800XT", "8-Core", "4.7 GHz", "Socket AM4", "$350"));
		cpus.add(new CPU(3, "Intel", "Core i9-9900K", "8-Core", "5.0 GHz", "LGA 1151 (300 Series)", "$350"));
		
		gpus.add(new GPU(1, "MSI", "RTX 2080 Super Gaming X TRIO", "1 x HDMI 2.0b 3 x DisplayPort 1.4", "PCI Express 3.0 x16", "8GB", "$1000"));
		gpus.add(new GPU(2, "GIGABYTE", "GV-N2060OC-6GD ver 2.0", "1 x HDMI 2.0b 3 x DisplayPort 1.4", "PCI Express 3.0 x16", "6GB", "$280"));
		gpus.add(new GPU(3, "MSI", "RX 5700 XT GAMING X", "1 x HDMI 2.0b 3 x DisplayPort 1.4", "PCI Express 4.0", "8GB", "$350"));
		
		hds.add(new Hard_Drive(1, "Samsung", "ST2000DL004", "2TB", "5400 RPM", "$250"));
		hds.add(new Hard_Drive(2, "Samsung", "HD154UI", "1.5TB", "7200 RPM", "$60"));
		hds.add(new Hard_Drive(3, "Water Panther", "WPC101200GSAS-G7", "1.2TB", "10000 RPM", "$75"));
		
		mobos.add(new Motherboard(1, "MSI", "MPG Z490 GAMING EDGE WIFI", "LGA 1200", "2 x PCI Express 3.0 x16", "ATX", "$180"));
		mobos.add(new Motherboard(2, "ASUS", "STRIX Z490-E GAMING", "LGA 1200", "2 x PCIe 3.0 x16 (x16 or dual x8)", "ATX", "$225"));
		mobos.add(new Motherboard(3, "GIGABYTE", "Z390 AORUS PRO WIFI", "LGA 1151 (300 Series)", "1 x PCI Express x16 slot, running at x16 (PCIEX16)", "ATX", "$125"));
		*/
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>"); 
			out.println("<html>"); 
			out.println("<head>"); 
			out.println("<title>Servlet DisplayServlet</title>"); 
			out.println("</head>"); 
			out.println("<body>");
			
			request.setAttribute("allList", allList);
			request.setAttribute("cpus", cpus);
			request.setAttribute("gpus", gpus);
			request.setAttribute("hds", hds);
			request.setAttribute("mobos", mobos);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ProductDisplay.jsp");
			rd.forward(request, response);
			
			out.println("</body>");
			out.println("</html");
    	}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
