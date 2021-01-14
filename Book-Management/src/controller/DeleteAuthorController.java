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
import dao.PublisherDAO;
import model.Author;

/**
 * Servlet implementation class DeleteAuthorController
 */
@WebServlet("/DeleteAuthorController")
public class DeleteAuthorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AuthorDAO dao;
    
    public DeleteAuthorController() {
        super();
        dao = new AuthorDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("delete")){
	        String aIC= request.getParameter("aIC");
	        dao.deleteAuthor(aIC);
	        
	        action = "list-author.jsp";
	        try {
				request.setAttribute("author", AuthorDAO.getAllAuthor());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }
	        RequestDispatcher view = request.getRequestDispatcher("list-author.jsp");
	        view.forward(request, response);
		
		
		
	}

}
