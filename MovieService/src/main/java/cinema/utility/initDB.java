package cinema.utility;

import cinema.model.dao.MovieDao;
import cinema.model.domain.Movie;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Jeroen Roovers <jroovers>
 */
@Startup
@Singleton
public class initDB {

    @Inject
    MovieDao dao;

    @PostConstruct
    public void init() {
        addSomeMovies();
    }

    private void addSomeMovies() {
        dao.create(new Movie("The Shawshank Redemption", 1994, 142));
        dao.create(new Movie("The Godfather", 1972, 175));
        dao.create(new Movie("The Dark Knight", 2008, 152));
        dao.create(new Movie("The Godfather: Part II ", 1974, 202));
        dao.create(new Movie("The Lord of the Rings: The Return of the King", 2003, 201));
        dao.create(new Movie("Pulp Fiction", 1994, 154));
        dao.create(new Movie("Schindler's List", 1993, 195));
        dao.create(new Movie("12 Angry Men", 1957, 96));
        dao.create(new Movie("Fight Club", 1999, 139));
        dao.create(new Movie("The Lord of the Rings: The Fellowship of the Ring", 2001, 178));

    }

}
