package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connection.ConnectionManager;
import model.Author;
import model.Book;

public class BookDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	static int bPage;
	static String bTitle, bEdition, bFiction, bLanguage, isbn, uIC, pIC;
	static Date bDate;
	
	//Add data
	
	public String addBook(Book bookBean)
	{
		isbn = bookBean.getIsbn();
		uIC = bookBean.getuIC();
		bTitle = bookBean.getbTitle();
		bEdition = bookBean.getbEdition();
		pIC = bookBean.getpIC();
		bDate = bookBean.getbDate();
		bPage = bookBean.getbPage();
		bFiction = bookBean.getbFiction();
		bLanguage = bookBean.getbLanguage();
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
            String date = dateFormat.format(bDate);
            //step3 : create statement - using preparedStatement
            ps=con.prepareStatement("insert into book(isbn, uIC, bTitle, bEdition, pIC, bDate, bPage, bFiction, bLanguage)values(?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1,isbn);
            ps.setString(2,uIC);
            ps.setString(3, bTitle);
            ps.setString(4, bEdition);
            ps.setString(5,pIC);
            ps.setDate(6,java.sql.Date.valueOf(date));
            ps.setInt(7,bPage);
            ps.setString(8, bFiction);
            ps.setString(9, bLanguage);
            System.out.println(ps);
            int i= ps.executeUpdate();
            
           
            
            if (i!=0)  //Just to ensure data has been inserted into the database
            return "SUCCESS"; 
        }
        catch (Exception ex) 
        {
            System.out.println("failed: An Exception has occurred! " + ex);
        }return "Oops.. Something went wrong there..!";
	}
	
	public static Book getBookById(String isbn)
	{
		Book b = new Book();
		
		 try {
		        con = ConnectionManager.getConnection();
		        ps=con.prepareStatement("select * from book where isbn=?");

		        ps.setString(1, isbn);
		        ResultSet rs = ps.executeQuery();
		            
		        if (rs.next()) {
		        	b.setIsbn(rs.getString("isbn"));
		        	b.setuIC(rs.getString("uIC"));
		        	b.setbTitle(rs.getString("bTitle"));
		        	b.setbEdition(rs.getString("bEdition"));
		        	b.setpIC(rs.getString("pIC"));
		        	b.setbDate(rs.getDate("bDate"));
		        	b.setbPage(rs.getInt("bPage"));
		        	b.setbFiction(rs.getString("bFiction"));
		        	b.setbLanguage(rs.getString("bLanguage"));

		        }
		        } catch (SQLException e) {
		            System.out.println("failed: Cannot get the id " + e);
		        }
		        return b;
		       
		
	}
	
	//list data
    public static List<Book> getAllBook() throws ClassNotFoundException, SQLException
    {
        List<Book> book = new ArrayList<>();
        
        con = ConnectionManager.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery("select * from book ");
        
       
        while (rs.next()) 
        {
        	 
 	       isbn = rs.getString("isbn");
 	       uIC = rs.getString("uIC");
 	       bTitle = rs.getString("bTitle");
 	       bEdition = rs.getString("bEdition");
 	       bFiction = rs.getString("bFiction");
 	       bLanguage = rs.getString("bLanguage");
 	       pIC = rs.getString("pIC");
 	       bPage= rs.getInt("bPage");
 	       bDate = rs.getDate("bDate");
 	       
 	       Book b = new Book( bPage,  bTitle,  bEdition,  bFiction,  bLanguage,  pIC,  uIC,
 	  			 isbn,  bDate);
 	       book.add(b);

        } 
        return book;
    }
    
    public String updateBook(Book bookBean)
	{
    	isbn = bookBean.getIsbn();
		uIC = bookBean.getuIC();
		bTitle = bookBean.getbTitle();
		bEdition = bookBean.getbEdition();
		pIC = bookBean.getpIC();
		bDate = bookBean.getbDate();
		bPage = bookBean.getbPage();
		bFiction = bookBean.getbFiction();
		bLanguage = bookBean.getbLanguage();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		 String date = dateFormat.format(bDate);
        
        String searchQuery = "UPDATE book SET bDate= '" + java.sql.Date.valueOf(date) + "', uIC='" + uIC + "',  bTitle='" + bTitle +"', bEdition='" + bEdition +"' ,  pIC='" + pIC +"', bPage='" + bPage +"',  bFiction='" + bFiction +"' , bLanguage='" + bLanguage +"' WHERE isbn= '" + isbn + "'";
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
    
    public void deleteBook(String isbn) {
	     try {
	     con = ConnectionManager.getConnection();
	     ps=con.prepareStatement("delete from book where isbn=?");
	     ps.setString(1,isbn);
	     ps.executeUpdate();
	     } catch (SQLException e) {
	         System.out.println("failed: tak boleh delete data customer " + e);
	     }
	 }
}
