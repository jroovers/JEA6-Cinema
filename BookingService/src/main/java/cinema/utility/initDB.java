package cinema.utility;

import cinema.model.dao.BookingDao;
import cinema.model.domain.entity.Booking;
import java.util.ArrayList;
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
    BookingDao dao;

    @PostConstruct
    public void init() {
        createBookings();
    }

    private void createBookings() {
        Booking b = new Booking();
        b.setLocation("Eindhoven");
        b.setMovietitle("The Shawshank Redemption");
        b.setShowId(5L);
        b.setRoom("Zaal 1");
        b.setSeats(new ArrayList<>());
        b.getSeats().add(7);
        b.getSeats().add(8);
        dao.create(b);
    }

}
