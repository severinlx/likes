package Bewertung;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;  

public class DB {
	// JDBC driver name and database URL 
	   static final String JDBC_DRIVER = "org.h2.Driver";   
	   static final String DB_URL = "jdbc:h2:~/test";  
	   
	   //  Database credentials 
	   static final String USER = "sa"; 
	   static final String PASS = ""; 
	  
	   public static void createTable() { 
		   String sql =  "CREATE TABLE   Post_Rating " + 
		        	" (post_id INTEGER, " +  
		            " post_likes_number INTEGER, " +  
		            " post_dislikes_number INTEGER, " +  
		            " PRIMARY KEY ( post_id ))";  
		   
	 
	      System.out.println("Goodbye!");
	      runQuery(sql);
	   }
	   
	   public static void runQuery(String sql) {
			  Connection conn = null; 
		      Statement stmt = null; 
		      try{
		         // STEP 1: Register JDBC driver 
			         Class.forName(JDBC_DRIVER);  
		         
		         // STEP 2: Open a connection 
		         System.out.println("Connecting to a selected database..."); 
		         conn = DriverManager.getConnection(DB_URL, USER, PASS); 
		         System.out.println("Connected database successfully..."); 
		         
		         // STEP 3: Execute a query 
		         stmt = conn.createStatement();  
		         
		         System.out.println(sql);
		         
		         stmt.executeUpdate(sql); 
		         
		         System.out.println("databased changed..."); 
		         
		         // STEP 4: Clean-up environment 
		         stmt.close(); 
		         conn.close(); 
		      } catch(SQLException se) { 
		         // Handle errors for JDBC 
		         se.printStackTrace(); 
		      } catch(Exception e) { 
		         // Handle errors for Class.forName 
		         e.printStackTrace(); 
		      } finally { 
		         // finally block used to close resources 
		         try {
		            if(stmt!=null) stmt.close();  
		         } catch(SQLException se2) { 
		         } // nothing we can do 
		         try { 
		            if(conn!=null) conn.close(); 
		         } catch(SQLException se) { 
		            se.printStackTrace(); 
		         } // end finally try 
		      } // end try 
		      System.out.println("Goodbye!"); 
			
		}
		
	}


