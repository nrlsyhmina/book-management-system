package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PublisherDAO;
import model.Publisher;


/**
 * Servlet implementation class AddPublisherController
 */
@WebServlet("/AddPublisherController")
public class AddPublisherController extends HttpServlet {
	private PublisherDAO dao;
    public AddPublisherController() {
    	dao = new PublisherDAO();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieve input and set values
       Publisher publisher = new Publisher();
        
        try {
        	publisher.setpName(request.getParameter("pName"));
        	publisher.setpCity(request.getParameter("pCity"));
        	publisher.setpState(request.getParameter("pState"));
        	publisher.setuIC(request.getParameter("uIC"));
        	publisher.setpIC(request.getParameter("pIC"));
	        
	        
        } catch(NumberFormatException ex){
        	     return; 
        	  }
 
        dao.addPublisher(publisher);
        
		try {
			request.setAttribute("publisher", PublisherDAO.getPublisherList());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-publisher.jsp");
		dispatcher.forward(request, response);
	}

}
