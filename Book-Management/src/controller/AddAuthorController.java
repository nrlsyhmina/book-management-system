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

import dao.AuthorDAO;
import model.Author;

/**
 * Servlet implementation class AddAuthorController
 */
@WebServlet("/AddAuthorController")
public class AddAuthorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthorDAO dao;
	
	public AddAuthorController()
	{
		super();
		dao = new AuthorDAO();
	}
	

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			Author author = new Author();
			
			String date = request.getParameter("aDOB");
			Date newDate;
			try {
			newDate = new SimpleDateFormat("yyyy-mm-dd").parse(date);
			author.setaDOB(newDate);
			} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
			author.setaName(request.getParameter("aName"));
			author.setaGender(request.getParameter("aGender"));
			author.setuIC(request.getParameter("uIC"));
			author.setaIC(request.getParameter("aIC"));
			dao.addAuthor(author);
			
			try {
				request.setAttribute("author", AuthorDAO.getAllAuthor());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("list-author.jsp");
			dispatcher.forward(request, response);
		
	}


}
