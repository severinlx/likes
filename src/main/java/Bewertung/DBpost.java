package Bewertung;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Statement;  
public class DBpost {
	   
	   public static void post(PostEig postEig) {
		   String sql =  String.format("INSERT INTO Post_Rating VALUES (%s, %s, %s)", 
	        		 Integer.toString(postEig.getPost_id()), 
	        		 Integer.toString(postEig.getNr_of_likes()), 
	        		 Integer.toString(postEig.getNr_of_dislikes())); 
		   System.out.println("post!!!!!!!! "+sql);
		   DB.runQuery(sql);
	}
	   
	public static void update(PostEig postRating) {
		String sql = String.format("UPDATE Post_Rating SET post_likes_number=%s, post_dislikes_number=%s WHERE post_id=%s", 
				Integer.toString(postRating.getNr_of_likes()),
				Integer.toString(postRating.getNr_of_dislikes()),
				Integer.toString(postRating.getPost_id())
				);
		System.out.println("update!!!!!!!! "+sql);
		DB.runQuery(sql);
	}
}
