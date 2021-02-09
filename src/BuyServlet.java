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

import datamodel.CPU;
import datamodel.GPU;
import datamodel.Hard_Drive;
import datamodel.Motherboard;
import util.UtilDBPCMarket;

/**
 * Servlet implementation class DispalyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    List<CPU> cpus = UtilDBPCMarket.listCPU();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
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
			CPU cpu = null;
			for(CPU c : cpus) {
				if(c.getId() == Integer.parseInt(request.getParameter("id"))) {
					cpu = c;
					break;
				}
			}
			request.setAttribute("cpu", cpu);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/BuyPage.jsp");
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
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		doGet(request, response);
	}

}
