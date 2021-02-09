import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UtilDBPCMarket;

@WebServlet("/SellServlet")
public class SellServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public SellServlet() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String partType = request.getParameter("partType").trim();
      String model = request.getParameter("model").trim();
      String price = request.getParameter("price").trim();
      UtilDBPCMarket.createAll_Listings(model, partType, price);
      response.sendRedirect("ThankYou.html");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}