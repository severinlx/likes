package Bewertung;
//import java.util.ArrayList;
//import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;
import java.sql.*;

//import com.google.gson.Gson;

//import jerseyexample.Greeting;



@Path("/likes")
public class LikeService {
	//protected static final String[] POSTS = { "1" : {likes: anzahl, dislikes: anzahl}, "2", "3" };
	PostEig postEig;
	JsonObject result = new JsonObject();
	//id, likes, dislikes
	Integer[][] postFeaturesArray =  {{1,2,3}, {2,2,3}
			};
	 Gson gson = new Gson();
	String numbersJson = gson.toJson(postFeaturesArray);
	
	@GET
	@Path("/{Post_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject getLikesNumber(@PathParam("Post_id") int Post_id) throws SQLException
	{
		
		JsonObject result = new JsonObject();
		result.addProperty("post_id", Post_id);
		result.addProperty("likes", DBOperations.getLikes(Post_id));
		result.addProperty("dislikes", DBOperations.getDisLikes(Post_id));
		result.addProperty("user_id",0);
		return result;
		
		
	}
	
	public String getPostId(JsonObject json) {
		
		return json.get("Post_id").getAsString();
		

		
	}
	@POST
	@Path("/{new_like_nr}")
	public void  incrementDislike(JsonObject json) {
		
		 DBOperations.incrementDisLike(getPostId(json));
		
	}
	@POST
	
	public void  incrementlike(JsonObject json) {
		
		 DBOperations.incrementLike(getPostId(json));
		
	}
	
	//public JsonObject incrementBewertungNumber(int Post_id, String event) {
		
		
	//	if(event=="like" )
	//	{
	//		result.addProperty("likes", DBOperations.getLikes(Post_id)+1);
			
	//	}		
		
	//	else if (event=="dislike") {
			
		//	result.addProperty("dislikes", DBOperations.getDisLikes(Post_id) + 1);
	//	}
		
		
	//	return result;
	}
	

