package controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;

/**
 * Servlet implementation class DeleteBuyerServlet
 */
@WebServlet("/DeleteBuyerServlet")
public class DeleteBuyerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBuyerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BuyerHelper o = new BuyerHelper();
		
		request.setAttribute("allItems", o.showAllBuyers());
		
		if(o.showAllBuyers().isEmpty()) {
			request.setAttribute("noItems", "Nothing to delete here");
		}
		
		getServletContext().getRequestDispatcher("/delete-buyer.jsp").forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BuyerHelper o = new BuyerHelper();
		BookHelper p = new BookHelper();
		List<Book> bookList = p.showAllBooks();
		int buyer_id = Integer.parseInt(request.getParameter("id"));
		for (Book book: bookList)
		{
			if(book.getBuyer() == null)
			{
				continue;
			}
			else if (book.getBuyer().getId() == buyer_id)
			{
				System.out.println(book.getName());
				book.setNullBuyer();
				p.updateBook(book);
			}
		}
		
		
		o.deleteBuyer(o.searchForBuyerById(buyer_id));
		
		getServletContext().getRequestDispatcher("/index.html").forward(request,  response);
	}

}
