package cinema.utility;

import cinema.model.domain.dto.Movie;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeroen Roovers <jroovers>
 */
public class CommandGetMovies extends HystrixCommand<List<Movie>> {

    public CommandGetMovies() {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"), 10000);
    }

    @Override
    protected List<Movie> run() {
        return movieServiceConnector.getAllMovies();
    }

    @Override
    protected List<Movie> getFallback() {
        List<Movie> movies = new ArrayList<>(10);
        movies.add(new Movie("Fallback film 1", 1994, 142));
        movies.add(new Movie("Fallback film 2", 1972, 175));
        movies.add(new Movie("Fallback film 3", 2008, 152));
        movies.add(new Movie("Fallback film 4", 1974, 202));
        movies.add(new Movie("Fallback film 5", 2003, 201));
        movies.add(new Movie("Fallback film 6", 1994, 154));
        movies.add(new Movie("Fallback film 7", 1993, 195));
        movies.add(new Movie("Fallback film 8", 1957, 96));
        movies.add(new Movie("Fallback film 9", 1999, 139));
        movies.add(new Movie("Fallback film 10", 2001, 178));
        return movies;
    }
}
