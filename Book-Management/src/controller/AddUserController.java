package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class AddAuthorController
 */
@WebServlet("/AddUserController")
public class AddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
	
	public AddUserController()
	{
		super();
		dao = new UserDAO();
	}
	

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			User user = new User();
			
			user.setuIC(request.getParameter("uIC"));
			user.setuName(request.getParameter("uName"));
			user.setuEmail(request.getParameter("uEmail"));
			user.setuPassword(request.getParameter("uPassword"));
			dao.addUser(user);
			
			request.setAttribute("user", UserDAO.getAllUser());
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("list-user.jsp");
			dispatcher.forward(request, response);
		
	}


}
