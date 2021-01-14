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

import dao.BookDAO;
import model.Book;

/**
 * Servlet implementation class AddBookController
 */
@WebServlet("/AddBookController")
public class AddBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO dao;
	
	public AddBookController()
	{
		super();
		dao = new BookDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = new Book();
		
		
		String date = request.getParameter("bDate");
		Date newDate;
		try {
		newDate = new SimpleDateFormat("yyyy-mm-dd").parse(date);
		book.setbDate(newDate);
		} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		book.setIsbn(request.getParameter("isbn"));
		book.setuIC(request.getParameter("uIC"));
		book.setpIC(request.getParameter("pIC"));
		book.setbTitle(request.getParameter("bTitle"));
		book.setbEdition(request.getParameter("bEdition"));
		book.setbPage(Integer.parseInt(request.getParameter("bPage")));
		book.setbFiction(request.getParameter("bFiction"));
		book.setbLanguage(request.getParameter("bLanguage"));
		dao.addBook(book);
		
		try {
			request.setAttribute("book", BookDAO.getAllBook());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-book.jsp");
		dispatcher.forward(request, response);
	}

}
