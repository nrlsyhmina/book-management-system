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
 * Servlet implementation class UpdatePublisherController
 */
@WebServlet("/UpdateUserController")
public class UpdateUserController extends HttpServlet {
	private UserDAO dao;
	
    public UpdateUserController() {
    	dao = new UserDAO();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uIC = request.getParameter("uIC");
        User user = dao.getUserById(uIC); 
        request.setAttribute("user", user);
        RequestDispatcher view = request.getRequestDispatcher("update-user.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		u.setuIC(request.getParameter("uIC"));
		u.setuName(request.getParameter("uName"));
		u.setuEmail(request.getParameter("uEmail"));
		u.setuPassword(request.getParameter("uPassword"));
	    dao.updateUser(u);//DAO
	        
	     request.setAttribute("user", UserDAO.getAllUser());
	      RequestDispatcher view = request.getRequestDispatcher("list-user.jsp");
	      view.forward(request, response);

}
}
