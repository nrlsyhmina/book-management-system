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

import dao.PublisherDAO;
import model.Publisher;


/**
 * Servlet implementation class ListPublisherController
 */
@WebServlet("/ListPublisherController")
public class ListPublisherController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get data from db(model)
		try {
			List<Publisher> publisher = PublisherDAO.getPublisherList();
			request.setAttribute("publisher", publisher);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//redirect to diff page(view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-publisher.jsp");
		dispatcher.forward(request,  response);
		
	}
}
