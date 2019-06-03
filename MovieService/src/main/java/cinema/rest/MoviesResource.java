/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.rest;

import cinema.model.domain.Movie;
import cinema.service.MovieService;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Jeroen Roovers <jroovers>
 */
@Path("movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class MoviesResource {

    @Inject
    MovieService mService;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MoviesResource
     */
    public MoviesResource() {
    }

    /**
     * Get a list of all movies
     *
     * @return
     */
    @GET
    public Response getMovies() {
        return Response
                .ok(mService.getAllMovies())
                .build();
    }

    /**
     * Get a single movies
     *
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    public Response getMovie(@PathParam("id") Long id) {
        Movie m = mService.getMovieById(id);
        if (m != null) {
            return Response
                    .ok(m)
                    .build();
        } else {
            return Response
                    .status(404)
                    .build();
        }
    }

    /**
     * PUT method for updating or creating an instance of MoviesResource
     *
     * @param content representation for the resource
     */
    @PUT
    public void putJson(Movie content) {
    }
}
