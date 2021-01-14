package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuthorDAO;
import dao.BookDAO;

/**
 * Servlet implementation class DeleteBookController
 */
@WebServlet("/DeleteBookController")
public class DeleteBookController extends HttpServlet {
	private BookDAO dao;
	
	 public DeleteBookController() {
	        super();
	        dao = new BookDAO();
	    }
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action = request.getParameter("action");
			
			if (action.equalsIgnoreCase("delete")){
		        String isbn= request.getParameter("isbn");
		        dao.deleteBook(isbn);
		        
		        action = "list-book.jsp";
		        try {
					request.setAttribute("book", BookDAO.getAllBook());
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        }
		        RequestDispatcher view = request.getRequestDispatcher("list-book.jsp");
		        view.forward(request, response);
			
			
			
		}

}
