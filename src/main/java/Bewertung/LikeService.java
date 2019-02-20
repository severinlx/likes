package Bewertung;
//import java.util.ArrayList;
//import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;

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
	@Produces(MediaType.TEXT_PLAIN)
	public int getLikesNumber(@PathParam("Post_id") int Post_id)
	{
		postEig = new PostEig(postFeaturesArray[1][0]);
		postEig.setNr_of_likes(6);
		return postEig.getNr_of_likes();
		 
	}
	
}
