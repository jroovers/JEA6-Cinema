/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.service.impl;

import cinema.model.dao.MovieDao;
import cinema.model.domain.Movie;
import cinema.service.MovieService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MovieServiceImpl implements MovieService {

    @Inject
    MovieDao dao;

    @Override
    public List<Movie> getAllMovies() {
        return dao.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return dao.findById(id);
    }

}
