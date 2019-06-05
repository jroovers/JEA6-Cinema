package cinema.rest;

import cinema.service.RoomService;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author jeroe
 */
@Path("rooms")
@Stateless
public class RoomResource {

    @Context
    private UriInfo context;

    @Inject
    private RoomService service;

    /**
     * Creates a new instance of RoomsResource
     */
    public RoomResource() {
    }

    /**
     * Retrieves representation of an instance of cinema.rest.RoomsResource
     *
     * @return an instance of cinema.model.domain.entity.Room
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        return Response.ok(service.getAllRooms()).build();
    }
}
