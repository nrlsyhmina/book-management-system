package dao;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionManager;
import model.Publisher;

public class PublisherDAO {
	static Connection con;
	static Statement stmt;
	static ResultSet rs;
	static PreparedStatement ps;
	
	static String pName, pCity, pState, pIC, uIC;
	
	public String addPublisher(Publisher publisherBean)
	{
		try 
        {
            //step 2: create connection
            con = ConnectionManager.getConnection();
            
            //step3 : create statement - using preparedStatement
            ps=con.prepareStatement("insert into publisher(pIC,pName,pCity,pState,uIC)values(?,?,?,?,?)");
            ps.setString(1,publisherBean.getpIC());
            ps.setString(2,publisherBean.getpName());
            ps.setString(3,publisherBean.getpCity());
            ps.setString(4,publisherBean.getpState());
            ps.setString(5,publisherBean.getuIC());
            int i= ps.executeUpdate();
            
            if (i!=0)  //Just to ensure data has been inserted into the database
            return "SUCCESS"; 
        }
        catch (Exception ex) 
        {
        	JOptionPane.showMessageDialog(null,"Data already exist!");
        }return "Oops.. Something went wrong there..!";
	}
	
	
	
	public static Publisher getPublisherById(String pIC) {
		Publisher p = new Publisher();
       
        try {
        con = ConnectionManager.getConnection();
        ps=con.prepareStatement("select * from publisher where pIC=?");

        ps.setString(1, pIC);
        ResultSet rs = ps.executeQuery();
            
        if (rs.next()) {
        p.setpIC(rs.getString("pIC"));
        p.setuIC(rs.getString("uIC"));
        p.setpName(rs.getString("pName"));
        p.setpCity(rs.getString("pCity"));
        p.setpState(rs.getString("pState"));
        
        }
        } catch (SQLException e) {
            System.out.println("failed: Cannot get the id " + e);
        }
        return p;
       }
	
	public String updatePublisher(Publisher publisherBean)
	{
		pIC = publisherBean.getpIC();
		uIC = publisherBean.getuIC();
		pName = publisherBean.getpName();
		pCity = publisherBean.getpCity();
		pState = publisherBean.getpState();
		try 
        {
            //step 2: create connection
            con = ConnectionManager.getConnection();
            
            //step3 : create statement - using preparedStatement
            String sqlSearch =" UPDATE publisher SET pName= '" + pName + "', pCity= '" + pCity + "', pState= '" + pState + "' WHERE pIC= '" + pIC + "'";
            stmt = con.createStatement();
            stmt.executeUpdate(sqlSearch);
            
        }
        catch (Exception ex) 
        {
            System.out.println("failed: An Exception has occurred! " + ex);
        }return "Oops.. Something went wrong there..!";
	}
	
	public static List<Publisher> getPublisherList() throws ClassNotFoundException, SQLException
	{
		
		ArrayList<Publisher> publisher = new ArrayList<>();
		
		 con = ConnectionManager.getConnection();
		 stmt = con.createStatement();
		 rs = stmt.executeQuery("select * from publisher");
		
		while(rs.next())
		{
			 pIC = rs.getString("pIC");
			 uIC = rs.getString("uIC");
			 pName = rs.getString("pName");
			 pCity = rs.getString("pCity");
			 pState = rs.getString("pState");
			 Publisher p = new Publisher(pIC, pName, pCity, pState, uIC);
			 publisher.add(p);
		}
		
		return publisher;
	}
	
	public void deletePublisher(String pIC) throws FileNotFoundException {
		
	     try {
	     con = ConnectionManager.getConnection();
	     ps=con.prepareStatement("delete from publisher where pIC=?");
	     ps.setString(1,pIC);
	     ps.executeUpdate();
	     } catch (SQLException e) {
	    	 JOptionPane.showMessageDialog(null,"Data cannot delete");
	     }
	    }

}
