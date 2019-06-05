package cinema.rest;

import cinema.model.domain.entity.Theatre;
import cinema.service.TheatreService;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Jeroen Roovers
 */
@Path("theatres")
@Stateless
public class TheatreResource {

    @Context
    private UriInfo context;

    @Inject
    private TheatreService service;

    /**
     * Creates a new instance of TheatreResource
     */
    public TheatreResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTheatres() {
        return Response.ok(service.getAllTheatres()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTheatre(@PathParam("id") Long id) {
        Theatre t = service.getTheatre(id);
        if (t != null) {
            return Response.ok(t).build();
        } else {
            return Response.status(404).build();
        }
    }

    @GET
    @Path("{id}/rooms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTheatreRooms(@PathParam("id") Long id) {
        Theatre t = service.getTheatre(id);
        if (t != null) {
            return Response.ok(t.getAvailableRooms()).build();
        } else {
            return Response.status(404).build();
        }
    }

    @GET
    @Path("{id}/schedule")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTheatreSchedule(@PathParam("id") Long id) {
        Theatre t = service.getTheatre(id);
        if (t != null) {
            return Response.ok(t.getSchedule()).build();
        } else {
            return Response.status(404).build();
        }
    }

}
