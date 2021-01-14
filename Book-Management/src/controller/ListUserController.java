package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;


/**
 * Servlet implementation class ListPublisherController
 */
@WebServlet("/ListUserController")
public class ListUserController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> user = UserDAO.getAllUser();
		request.setAttribute("user", user);
		
		//redirect to diff page(view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-user.jsp");
		dispatcher.forward(request,  response);
		
	}
}
