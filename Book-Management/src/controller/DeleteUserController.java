package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class DeletePublisherController
 */
@WebServlet("/DeleteUserController")
public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
    
    public DeleteUserController() {
        super();
        dao = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("delete")){
	        String uIC= request.getParameter("uIC");
	        dao.deleteUser(uIC);
	        
	        action = "list-user.jsp";
	        request.setAttribute("user", UserDAO.getAllUser());
	        }
	        RequestDispatcher view = request.getRequestDispatcher("list-user.jsp");
	        view.forward(request, response);
		
		
		
	}


}
