package cinema.rest;

import cinema.model.domain.entity.Theatre;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Jeroen Roovers
 */
@Path("theatres")
public class TheatreResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TheatreResource
     */
    public TheatreResource() {
    }

    /**
     * Retrieves representation of an instance of cinema.rest.TheatreResource
     * @return an instance of cinema.model.domain.entity.Theatre
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Theatre getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of TheatreResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Theatre content) {
    }
}
