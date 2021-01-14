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
 * Servlet implementation class UpdatePublisherController
 */
@WebServlet("/UpdatePublisherController")
public class UpdatePublisherController extends HttpServlet {
	private PublisherDAO dao;
	
    public UpdatePublisherController() {
    	dao = new PublisherDAO();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pIC = request.getParameter("pIC");
        Publisher publisher = dao.getPublisherById(pIC); 
        request.setAttribute("publisher", publisher);
        RequestDispatcher view = request.getRequestDispatcher("update-publisher.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Publisher p = new Publisher();
		p.setpIC(request.getParameter("pIC"));
		p.setuIC(request.getParameter("uIC"));
		p.setpName(request.getParameter("pName"));
		p.setpCity(request.getParameter("pCity"));
		p.setpState(request.getParameter("pState"));
	    dao.updatePublisher(p);//DAO
	        
	     try {
				request.setAttribute("publisher", PublisherDAO.getPublisherList());
	      } catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	      RequestDispatcher view = request.getRequestDispatcher("list-publisher.jsp");
	      view.forward(request, response);

}
}
