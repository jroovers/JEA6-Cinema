package cinema.service.impl;

import cinema.model.dao.TheatreDao;
import cinema.model.domain.dto.Movie;
import cinema.model.domain.entity.Theatre;
import cinema.service.TheatreService;
import cinema.utility.movieServiceConnector;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class TheatreServiceImpl implements TheatreService {
    
    @Inject TheatreDao tdao;

    @Override
    public List<Theatre> getAllTheatres() {
        return tdao.findAll();
    }

    @Override
    public List<Movie> getAllAvailableMovies() {
        return movieServiceConnector.getAllMovies();
    }

    @Override
    public Theatre getTheatre(Long id) {
        return tdao.find(id);
    }
    
}
