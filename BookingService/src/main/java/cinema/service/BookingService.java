package cinema.service;

import cinema.model.domain.entity.Booking;
import java.util.List;

/**
 *
 * @author Jeroen Roovers
 */
public interface BookingService {

    public Booking getBooking(Long id);

    public List<Booking> getAllBookings();

}
