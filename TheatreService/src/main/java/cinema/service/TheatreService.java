package cinema.service;

import cinema.model.domain.dto.Movie;
import cinema.model.domain.entity.Theatre;
import java.util.List;

/**
 *
 * @author Jeroen Roovers
 */
public interface TheatreService {
    
    public Theatre getTheatre(Long id);

    public List<Theatre> getAllTheatres();

    public List<Movie> getAllAvailableMovies();

}
