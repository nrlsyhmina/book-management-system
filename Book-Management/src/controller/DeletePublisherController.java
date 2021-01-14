package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PublisherDAO;
import model.Publisher;

/**
 * Servlet implementation class DeletePublisherController
 */
@WebServlet("/DeletePublisherController")
public class DeletePublisherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublisherDAO dao;
    
    public DeletePublisherController() {
        super();
        dao = new PublisherDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("delete")){
	        String pIC= request.getParameter("pIC");
	        dao.deletePublisher(pIC);
	        
	        action = "list-publisher.jsp";
	        try {
				request.setAttribute("publisher", PublisherDAO.getPublisherList());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }
	        RequestDispatcher view = request.getRequestDispatcher("list-publisher.jsp");
	        view.forward(request, response);
		
		
		
	}


}
