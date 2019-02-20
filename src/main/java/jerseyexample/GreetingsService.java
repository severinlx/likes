package jerseyexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

@Path("/greetings")
public class GreetingsService
{
	/** The available greetings. */
	protected static final String[] GREETINGS = { "Hello World.", "Hello Jersey." };
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getGreetings()
	{
		List<Greeting> greetinglist = new ArrayList<>();
		
		for (int i = 0; i < GREETINGS.length; ++i)
			greetinglist.add(new Greeting(GREETINGS[i], i));
		
		Gson gson = new Gson();
		return gson.toJson(greetinglist.toArray(new Greeting[greetinglist.size()]));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{ids}")
	public String getJsonGreeting(@PathParam("ids") int id)
	{
		String greetingtext = GREETINGS[id];
		Greeting greeting = new Greeting(greetingtext, id);
		Gson gson = new Gson();
		return gson.toJson(greeting);
	}
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Greeting postJsonGreeting(Greeting greeting)
	{
		System.out.println(greeting.greeting + greeting.id);
		return greeting;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{id}")
	public String getPlainTextGreeting(@PathParam("id") int id)
	{
		String greeting = GREETINGS[id];
		return greeting;
	}
}