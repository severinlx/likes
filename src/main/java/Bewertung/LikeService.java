package Bewertung;
//import java.util.ArrayList;
//import java.util.List;

import javax.ws.rs.Consumes;
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



@Path("")
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
	public String get(@PathParam("Post_id") int Post_id) throws SQLException{
		JsonObject result = new JsonObject();
		result.addProperty("post_id", Post_id);
		result.addProperty("likes_number", DBOperations.getLikes(Post_id));
		result.addProperty("dislikes_number", DBOperations.getDisLikes(Post_id));
		result.addProperty("user_id",0);
		return result.toString();		
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public void  update(String jsonString) {
		String json = gson.toJson(jsonString);

		Gson gson = new Gson();
		PostEig postRating = gson.fromJson(jsonString, PostEig.class);
		System.out.println(postRating.getNr_of_likes());
		
		DBOperations.postOrUpdate(postRating);
	}
	
	public int getPostId(JsonObject json) {
		return Integer.getInteger(json.get("post_id").getAsString());
	
	}
	}
	

