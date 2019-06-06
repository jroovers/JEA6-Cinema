/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.rest;

import cinema.model.domain.dto.BookingRequest;
import cinema.model.domain.entity.Show;
import cinema.service.ShowService;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author jeroe
 */
@Path("shows")
@Stateless
public class ShowResource {

    @Context
    private UriInfo context;

    @Inject
    private ShowService service;

    /**
     * Creates a new instance of ShowResource
     */
    public ShowResource() {
    }

    /**
     * Retrieves representation of an instance of cinema.rest.ShowResource
     *
     * @return an instance of cinema.model.domain.entity.Show
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllShows() {
        return Response.ok(service.getAllShows()).build();
    }

    @POST
    @Path("{id}/book")
    public Response updateShowWithBooking(@PathParam("id") Long showid, BookingRequest booking) {
        System.out.println(booking);
        Show show = service.removeSeats(showid, booking.getSeats());
        if (show != null) {
            return Response.ok().build();
        } else {
            return Response.status(404).build();
        }
    }
}
