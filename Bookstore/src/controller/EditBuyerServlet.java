package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Buyer;

/**
 * Servlet implementation class EditBuyerServlet
 */
@WebServlet("/EditBuyerServlet")
public class EditBuyerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBuyerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BuyerHelper o = new BuyerHelper();
		
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Buyer buyerToUpdate = o.searchForBuyerById(tempId);
		buyerToUpdate.setFname(fname);
		buyerToUpdate.setLname(lname);
		buyerToUpdate.setCity(city);
		buyerToUpdate.setState(state);
		
		o.updateBuyer(buyerToUpdate);
		
		getServletContext().getRequestDispatcher("/ViewAllBuyersServlet").forward(request, response);
	}

}
