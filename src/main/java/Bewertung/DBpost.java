package Bewertung;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Statement;  
public class DBpost {
	static final String JDBC_DRIVER = "org.h2.Driver";   
	   static final String DB_URL = "jdbc:h2:~/test";  
	   
	   //  Database credentials 
	   static final String USER = "sa"; 
	   static final String PASS = ""; 
	   
	   public static void post(PostEig postEig) {
		   String sql =  String.format("INSERT INTO Post_Rating VALUES (%s, %s, %s)", 
	        		 Integer.toString(postEig.getPost_id()), 
	        		 Integer.toString(postEig.getNr_of_likes()), 
	        		 Integer.toString(postEig.getNr_of_dislikes())); 
		   
		   DB.runQuery(sql);
	}
	   
	public static void update(PostEig postRating) {
		String sql = String.format("UPDATE Post_Rating SET post_likes_number=%x, post_dislikes_number=%x WHERE post_id=%x", 
				postRating.getNr_of_likes(),
				postRating.getNr_of_dislikes(),
				postRating.getPost_id()
				);
		DB.runQuery(sql);
	}
}
