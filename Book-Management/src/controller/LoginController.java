package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
			PrintWriter out = response.getWriter();
			User user = new User();
			user.setuEmail(request.getParameter("uEmail"));
			user.setuPassword(request.getParameter("uPassword"));
			user = UserDAO.login(user);
			if (user.isValid()) { // logged-in page
				HttpSession session = request.getSession(true);
				session.setAttribute("uName", user.getuName());
				session.setAttribute("uEmail", user.getuEmail());
				session.setAttribute("uIC", user.getuIC());
				request.setAttribute("userList", UserDAO.getAllUser());
				RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
				rd.forward(request, response);
			} else 
			{//response.sendRedirect("customerLogin.jsp");
				 out.println("<script type=\"text/javascript\">");
				 out.println("alert('Email or password incorrect');");
				 out.println("location='login.jsp';");
				 out.println("</script>");
				// error page
			}
		}
		catch(Throwable theException)
		{
			System.out.println(theException);
		}
	}

}
