/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.service;

import cinema.model.domain.Movie;
import java.util.List;

/**
 *
 * @author Jeroen Roovers <jroovers>
 */
public interface MovieService {

    /**
     * Get all movies in storage.
     *
     * @return
     */
    public List<Movie> getAllMovies();

    /**
     * Get a movie by its unique ID
     *
     * @param id
     * @return
     */
    public Movie getMovieById(Long id);

}
