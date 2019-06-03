package cinema.model.dao;

import cinema.model.domain.Movie;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jeroen Roovers <jroovers>
 */
@Stateless
public class MovieDao {

    @PersistenceContext
    EntityManager em;

    public void create(Movie movie) {
        this.em.persist(movie);
    }

    public Movie findById(Long Id) {
        return em.createNamedQuery("movie.getMovieById", Movie.class)
                .setParameter("id", Id)
                .getSingleResult();
    }

    public List<Movie> findAll() {
        return em.createNamedQuery("movie.getAllMovies", Movie.class).getResultList();
    }

}
