package cinema.utility;

import cinema.model.domain.entity.Booking;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jeroen Roovers <jroovers>
 */
public class theatreServiceConnector {

    private static final String THEATRE_API_TARGET = "http://docker:8080/TheatreService/rest/";
    private static final String THEATRE_API_TARGET_BACKUP = "http://theatreservice:8080/TheatreService-1.0/rest/";

    public static void informTheatre(Booking booking) {
        try {
            registerSeats(THEATRE_API_TARGET, booking);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            registerSeats(THEATRE_API_TARGET_BACKUP, booking);
        }
    }

    private static void registerSeats(String url, Booking booking) {
        Client client = ClientBuilder.newClient();
        WebTarget resource = client.target(url)
                .path("shows")
                .path(booking.getShowId().toString())
                .path("book");
        Invocation.Builder request = resource.request();
        request.accept(MediaType.APPLICATION_JSON);
        Response response = request.post(Entity.json(booking));
        if (response.getStatus() == 404) {
            System.out.println(response.toString());
            throw new NotFoundException("404 not found");
        } else {
            System.out.println(response.toString());
        }
    }
}
