package dao;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.swing.JOptionPane;

import connection.ConnectionManager;
import model.Author;
import model.User;

public class UserDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	static String uName, uEmail, uPassword, uIC;
	
	public static User login(User bean) {
		// preparing some objects for connection 		
		Statement stmt = null;
		String uIC = bean.getuIC();
		String uEmail = bean.getuEmail();
		String uName = bean.getuName();
		String uPassword = bean.getuPassword();
		String searchQuery = "select * from bkuser where uEmail='" 
		+ uEmail + "' AND uPassword='" + uPassword + "'";
		//------prepared statement
		
		try {
			// connect to DB
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			// if user does not exist
			if (!more) {
				System.out.println("Sorry, you are not a registered user! " + "Please sign up first");
				bean.setValid(false);
			}
			// if user exists
			else if (more) {
				uName = rs.getString("uName");
				uEmail = rs.getString("uEmail");
				uPassword = rs.getString("uPassword");
				uIC = rs.getString("uIC");
				bean.setuName(uName);
				bean.setuEmail(uEmail);
				bean.setuPassword(uPassword);
				bean.setuIC(uIC);
				bean.setValid(true);
			}
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) { }
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) { }
				stmt = null;
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) { }
				con = null;
			}
		}
		return bean;
	}
	
	public static List<User> getAllUser(){
		// preparing some objects/variable 
        List<User> user = new LinkedList<>();
        String sql = "select * from bkuser";
        Statement stmt = null;

        try {        	
        	// connect to DB
        	con = ConnectionManager.getConnection();
        	stmt = con.createStatement();
        	rs = stmt.executeQuery(sql);
        	// iterate over the ResultSet, add row into object and object into list
            while(rs.next()){ 
            	User u = new User();
            	u.setuIC(rs.getString(1));
            	u.setuName(rs.getString(2));
            	u.setuEmail(rs.getString(3));
            	u.setuPassword(rs.getString(4));
            	user.add(u);
       
            }
        } catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) { }
				stmt = null;
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) { }
				con = null;
			}
		}       
        return user;
    }
	
	//Add data
	
		public String addUser(User authorBean) throws FileNotFoundException
		{
			
			uIC = authorBean.getuIC();
			uName = authorBean.getuName();
			uEmail = authorBean.getuEmail();
			uPassword = authorBean.getuPassword();
			
			/*System.out.println("A ID " + aID);
	 		System.out.println("U ID " + uID);
	 		System.out.println("Name " + aName);
	 		System.out.println("A Gender " + aGender);
	 		System.out.println("a DOB " + aDOB);*/
			
			try 
	        {
	            //step 2: create connection
	            con = ConnectionManager.getConnection();
	           
	            ps=con.prepareStatement("insert into bkuser(uIC, uName, uEmail, uPassword)values(?,?,?,?)");
	            
	           
	            ps.setString(1,uIC);
	            ps.setString(2,uName);
	            ps.setString(3, uEmail);
	            ps.setString(4,uPassword);
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
		
		public static User getUserById(String uIC)
		{
			User u = new User();
			
			 try {
			        con = ConnectionManager.getConnection();
			        ps=con.prepareStatement("select * from bkuser where uIC=?");

			        ps.setString(1, uIC);
			        ResultSet rs = ps.executeQuery();
			            
			        if (rs.next()) {
			        	u.setuIC(rs.getString("uIC"));
			        	u.setuName(rs.getString("uName"));
			        	u.setuEmail(rs.getString("uEmail"));
			        	u.setuPassword(rs.getString("uPassword"));
			       
			        }
			        } catch (SQLException e) {
			            System.out.println("failed: Cannot get the id " + e);
			        }
			        return u;
			       
			
		}
		
		public String updateUser(User userBean)
		{
			uIC = userBean.getuIC();
			uName = userBean.getuName();
			uEmail = userBean.getuEmail();
			uPassword = userBean.getuPassword();
	        
	        String searchQuery = "UPDATE bkuser SET uIC='" + uIC + "', uName='" + uName + "', uEmail='" + uEmail +"', uPassword='" + uPassword +"' WHERE uIC= '" + uIC + "'";
	        System.out.println(searchQuery);
	        
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
	    
	    public void deleteUser(String uIC) throws FileNotFoundException {
	    	
		     try {
		     con = ConnectionManager.getConnection();
		     ps=con.prepareStatement("delete from bkuser where uIC=?");
		     ps.setString(1,uIC);
		     ps.executeUpdate();
		     } catch (SQLException e) {
		    	 JOptionPane.showMessageDialog(null,"Data cannot delete");
		     }
		 }
		

}
