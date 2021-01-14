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


@WebServlet("/UpdateAuthorController")
public class UpdateAuthorController extends HttpServlet {
	private AuthorDAO dao;
    public UpdateAuthorController() {
       dao = new AuthorDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aIC = request.getParameter("aIC");
        Author author = dao.getAuthorById(aIC); 
        request.setAttribute("author", author);
        RequestDispatcher view = request.getRequestDispatcher("update-author.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Author a = new Author();
		a.setaIC(request.getParameter("aIC"));
		a.setuIC(request.getParameter("uIC"));
		a.setaName(request.getParameter("aName"));
		a.setaGender(request.getParameter("aGender"));
		String date = request.getParameter("aDOB");
		Date newDate;
		try {
		newDate = new SimpleDateFormat("yyyy-mm-dd").parse(date);
		a.setaDOB(newDate);
		} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
	    dao.updateAuthor(a);//DAO
	        
	     try {
				request.setAttribute("author", AuthorDAO.getAllAuthor());
	      } catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	      RequestDispatcher view = request.getRequestDispatcher("list-author.jsp");
	      view.forward(request, response);

}

}
