package cinema.utility;

import cinema.model.domain.dto.Movie;
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

    private static final String TRIP_API_TARGET = "http://localhost:8080/MovieService/rest/";

    public static List<Movie> getAllMovies() {
        Client client = ClientBuilder.newClient();
        WebTarget resource = client.target(TRIP_API_TARGET)
                .path("movies");
        Invocation.Builder request = resource.request();
        request.accept(MediaType.APPLICATION_JSON);
        
        List<Movie> response = request.get(new GenericType<List<Movie>>(){});
        return response;
    }

}
