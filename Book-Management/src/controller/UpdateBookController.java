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
import dao.PublisherDAO;
import model.Book;
import model.Publisher;



@WebServlet("/UpdateBookController")
public class UpdateBookController extends HttpServlet {
	private BookDAO dao;
	
    public UpdateBookController() {
        super();
        dao = new BookDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
        Book book = dao.getBookById(isbn); 
        request.setAttribute("book", book);
        RequestDispatcher view = request.getRequestDispatcher("update-book.jsp");
        view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book b = new Book();
		b.setIsbn(request.getParameter("isbn"));
		b.setuIC(request.getParameter("uIC"));
		b.setbTitle(request.getParameter("bTitle"));
		b.setbEdition(request.getParameter("bEdition"));
		b.setbFiction(request.getParameter("bFiction"));
		b.setpIC(request.getParameter("pIC"));
		b.setbPage(Integer.parseInt(request.getParameter("bPage")));
		b.setbLanguage(request.getParameter("bLanguage"));
		String date = request.getParameter("bDate");
		Date newDate;
		try {
		newDate = new SimpleDateFormat("yyyy-mm-dd").parse(date);
		b.setbDate(newDate);
		} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
	    dao.updateBook(b);//DAO
	        
	     try {
				request.setAttribute("book", BookDAO.getAllBook());
	      } catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	      RequestDispatcher view = request.getRequestDispatcher("list-book.jsp");
	      view.forward(request, response);
	}

}
