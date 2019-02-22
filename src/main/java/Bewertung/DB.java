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
	   
	   //table an columns:
	   static final String TABLE = "Post_Rating";
	   static final String POST_ID_COLUMN =  "post_id";
	   static final String LIKES_NUMBER_COLUMN =  "post_likes_number";
	   static final String DISLIKES_NUMBER_COLUMN =  "post_dislikes_number";
	   public static void createTable() { 
		   String sql =  String.format("CREATE TABLE   %s" + 
		        	" (% INTEGER, " +  
		            " % INTEGER, " +  
		            " % INTEGER, " +  
		            " PRIMARY KEY ( % ))", 
		            TABLE, POST_ID_COLUMN, LIKES_NUMBER_COLUMN, DISLIKES_NUMBER_COLUMN, POST_ID_COLUMN);  
		   
	 
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
		         //ab hier raus
		         
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
		}
		
	}


