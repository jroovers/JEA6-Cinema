package cinema.utility;

import cinema.model.domain.dto.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jeroen Roovers
 */
public class movieServiceConnector {

    private static final String MOVIE_API_TARGET = "http://docker:8080/MovieService/rest/";
    private static final String MOVIE_API_TARGET_BACKUP = "http://movieservice:8080/MovieService-1.0/rest/";

    public static List<Movie> getAllMovies() {
        try {
            return tryGetMovies(MOVIE_API_TARGET);
        } catch (Exception ex) {
            System.out.println("COULD NOT CONNECT ON LOCALHOST...");
            List<Movie> movies = null;
            int i = 0;
            while (movies == null) {
                i++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex1) {
                    System.out.println("WAITING INTERRUPTED.");
                    break;
                }
                System.out.println("ATTEMPTING CONNECTION ON ADDRESS " + MOVIE_API_TARGET_BACKUP);
                try {
                    movies = tryGetMovies(MOVIE_API_TARGET_BACKUP);
                } catch (Exception ignore) {
                    System.out.println("FAILED... WAITING FOR 1 SECOND BEFORE RETRY");
                }
                if (i > 20) {
                    System.out.println("6 ATTEMPTS. TIMING OUT.");
                    break;
                }
            }
            return movies;
        }
    }

    private static List<Movie> tryGetMovies(String url) {
        Client client = ClientBuilder.newClient();
        WebTarget resource = client.target(url)
                .path("movies");
        Invocation.Builder request = resource.request();
        request.accept(MediaType.APPLICATION_JSON);

        List<Movie> response = request.get(new GenericType<List<Movie>>() {
        });
        return response;
    }

}
