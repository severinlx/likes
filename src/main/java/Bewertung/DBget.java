package Bewertung;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Statement;
import java.util.ArrayList; 

public class DBget {
	   
	   public static ArrayList<Integer> getIds() {
		   Connection conn = null; 
		   Statement stmt = null; 
		    
		      ArrayList<Integer> list = new ArrayList<Integer>();
		      try { 
		         // STEP 1: Register JDBC driver 
		         Class.forName(DB.JDBC_DRIVER); 
		         
		         // STEP 2: Open a connection 
		         System.out.println("Connecting to database..."); 
		         conn = DriverManager.getConnection(DB.DB_URL,DB.USER,DB.PASS);  
		         
		         // STEP 3: Execute a query 
		         System.out.println("Connected database successfully..."); 
		         stmt = conn.createStatement(); 
		         String sql = "SELECT post_id FROM Post_Rating"; 
		         ResultSet rs = stmt.executeQuery(sql); 
		         
		         while(rs.next()) {
		        	list.add(rs.getInt("post_id"));
		         }
		         // STEP 5: Clean-up environment 
		         rs.close(); 
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
		   return list;
		   
		
	}

	public static PostEig get(int postID) {
		Connection conn = null; 
	      Statement stmt = null; 
	      PostEig postRating = new PostEig(postID);
	      
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(DB.JDBC_DRIVER); 
	         
	         // STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB.DB_URL,DB.USER,DB.PASS);  
	         
	         // STEP 3: Execute a query 
	         System.out.println("Connected database successfully..."); 
	         stmt = conn.createStatement(); 
	         String sql = String.format("SELECT post_likes_number, post_dislikes_number FROM Post_Rating  WHERE post_id=%x", postID); 
	         ResultSet rs = stmt.executeQuery(sql); 
	         
	         // STEP 4: Extract data from result set 
	       
	            // Retrieve by column name 
	            rs.first();
	            int likes = rs.getInt("post_likes_number"); 
	            int dislikes = rs.getInt("post_dislikes_number"); 
	            
	            // Display values 
	            System.out.print(postID); 
	            System.out.print(", likes: " + likes); 
	            System.out.print(", dislikes: " + dislikes); 
	            
	            postRating = new PostEig(postID, likes, dislikes);
	         
	         // STEP 5: Clean-up environment 
	         rs.close(); 
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
	      return postRating;
		
	}

}
