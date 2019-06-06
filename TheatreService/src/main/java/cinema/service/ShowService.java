package cinema.service;

import cinema.model.domain.entity.Show;
import java.util.List;

/**
 *
 * @author Jeroen Roovers
 */
public interface ShowService {

    public List<Show> getAllShows();

    public Show getShow(Long id);

    public Show removeSeats(Long showid, List<Integer> seats);

}
