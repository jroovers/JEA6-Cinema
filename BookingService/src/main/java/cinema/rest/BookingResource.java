/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.rest;

import cinema.model.domain.dto.BookingRequest;
import cinema.model.domain.entity.Booking;
import cinema.service.BookingService;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jeroen Roovers
 */
@Stateless
@Path("bookings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingResource {

    @Inject
    BookingService service;

    @GET
    public Response getAllBookings() {
        return Response.ok(service.getAllBookings()).build();
    }

    @GET
    @Path("{id}")
    public Response getAllBookings(@PathParam("id") Long id) {
        Booking b = service.getBooking(id);
        if (b != null) {
            return Response.ok(b).build();
        } else {
            return Response.status(404).build();
        }
    }

    @POST
    public Response createNewBooking(Booking body) {
        System.out.println(body.toString());
        service.createBooking(body);
        return Response.ok().build();
    }

}
