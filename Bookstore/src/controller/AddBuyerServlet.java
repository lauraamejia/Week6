package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Buyer;

/**
 * Servlet implementation class AddBuyerServlet
 */
@WebServlet("/AddBuyerServlet")
public class AddBuyerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBuyerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		Buyer o = new Buyer(fname, lname, city, state);
		BuyerHelper dao = new BuyerHelper();
		dao.insertBuyer(o);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}
}
