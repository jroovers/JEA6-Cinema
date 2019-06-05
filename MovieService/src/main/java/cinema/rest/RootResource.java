package cinema.rest;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Jeroen Roovers <jroovers>
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RootResource {

    @Context
    private UriInfo context;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDescription() {
        String actualURL = context.getBaseUriBuilder().build().toASCIIString();
        JsonObject reply;
        reply = Json.createObjectBuilder()
                .add("movies_url", actualURL + "movies")
                .add("movie_url", actualURL + "movies/{id}")
                .build();
        return Response.ok(reply).build();
    }

}
