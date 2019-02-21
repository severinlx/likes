package Bewertung;
//import java.util.ArrayList;
//import java.util.List;

import javax.ws.rs.GET;
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
		//result.addProperty("post_id", Post_id);
		//result.addProperty("likes", DBOperations.getLikes(Post_id));
		//result.addProperty("dislikes", DBOperations.getDisLikes(Post_id));
		result.addProperty("post_id", 9);
		result.addProperty("likes", 10);
		result.addProperty("dislikes",3);
		return result;
	}
	
}
