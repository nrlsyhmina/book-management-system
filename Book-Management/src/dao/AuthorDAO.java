package dao;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionManager;
import model.Author;


public class AuthorDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	static String aName, aGender, aIC, uIC;
	static Date aDOB;
	
	//Add data
	
	public String addAuthor(Author authorBean)
	{
		aIC = authorBean.getaIC();
		uIC = authorBean.getuIC();
		aName = authorBean.getaName();
		aGender = authorBean.getaGender();
		aDOB = authorBean.getaDOB();
		/*System.out.println("A ID " + aID);
 		System.out.println("U ID " + uID);
 		System.out.println("Name " + aName);
 		System.out.println("A Gender " + aGender);
 		System.out.println("a DOB " + aDOB);*/
		
		try 
        {
            //step 2: create connection
            con = ConnectionManager.getConnection();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            String date = dateFormat.format(aDOB);
            //step3 : create statement - using preparedStatement
            ps=con.prepareStatement("insert into author(aIC, uIC, aName, aDOB, aGender)values(?,?,?,?,?)");
            
           
            ps.setString(1,aIC);
            ps.setString(2,uIC);
            ps.setString(3, aName);
            ps.setDate(4,java.sql.Date.valueOf(date));
            ps.setString(5,aGender);
            System.out.println(ps);
            int i= ps.executeUpdate();
            
           
            
            if (i!=0)  //Just to ensure data has been inserted into the database
            return "SUCCESS"; 
        }
        catch (Exception ex) 
        {
        	JOptionPane.showMessageDialog(null,"Data already exist!");
        }return "Oops.. Something went wrong there..!";
	}
	
	public static Author getAuthorById(String aIC)
	{
		Author a = new Author();
		
		 try {
		        con = ConnectionManager.getConnection();
		        ps=con.prepareStatement("select * from author where aIC=?");

		        ps.setString(1, aIC);
		        ResultSet rs = ps.executeQuery();
		            
		        if (rs.next()) {
		        	a.setaIC(rs.getString("aIC"));
		        	a.setuIC(rs.getString("uIC"));
		        	a.setaName(rs.getString("aName"));
		        	a.setaDOB(rs.getDate("aDOB"));
		        	a.setaGender(rs.getString("aGender"));
		       
		        }
		        } catch (SQLException e) {
		            System.out.println("failed: Cannot get the id " + e);
		        }
		        return a;
		       
		
	}
	
	//list data
    public static List<Author> getAllAuthor() throws ClassNotFoundException, SQLException
    {
        List<Author> author = new ArrayList<>();
        
        con = ConnectionManager.getConnection();
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from author ");
        
       
        while (rs.next()) 
        {
        	 
 	       aIC = rs.getString("aIC");
 	       uIC = rs.getString("uIC");
 	       aName = rs.getString("aName");
 	       aDOB = rs.getDate("aDOB");
 	       aGender = rs.getString("aGender");
 	       
 	      System.out.println("A ID " + aIC);
 	 		System.out.println("U ID " + uIC);
 	 		System.out.println("Name " + aName);
 	 		System.out.println("A Gender " + aGender);
 	 		System.out.println("a DOB " + aDOB);
 	       
 	       Author a = new Author(aIC, aName, aGender, aDOB, uIC);
 	       author.add(a);

        } 
        return author;
    }
    
    public String updateAuthor(Author authorBean)
	{
		aIC = authorBean.getaIC();
		uIC = authorBean.getuIC();
		aName = authorBean.getaName();
		aGender = authorBean.getaGender();
		aDOB = authorBean.getaDOB();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String date = dateFormat.format(aDOB);
        
        String searchQuery = "UPDATE author SET aDOB= '" + java.sql.Date.valueOf(date) + "', aIC='" + aIC + "',  aName='" + aName +"', aGender='" + aGender +"' WHERE aIC= '" + aIC + "'";
        //System.out.println(searchQuery);
        
		try 
        {
            //step 2: create connection
            con = ConnectionManager.getConnection();
            
            //step3 : create statement - using preparedStatement
            stmt = con.createStatement();
            stmt.executeUpdate(searchQuery);
            
        }
        catch (Exception ex) 
        {
            System.out.println("failed: An Exception has occurred! " + ex);
        }return "Oops.. Something went wrong there..!";
	}
    
    public void deleteAuthor(String aIC) throws FileNotFoundException {
	     try {
	     con = ConnectionManager.getConnection();
	     ps=con.prepareStatement("delete from author where aIC=?");
	     ps.setString(1,aIC);
	     ps.executeUpdate();
	     } catch (SQLException e) {
	    	 JOptionPane.showMessageDialog(null,"Data cannot delete");
	     }
	 }
	

}

