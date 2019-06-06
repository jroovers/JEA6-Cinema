package cinema.service.impl;

import cinema.model.dao.ShowDao;
import cinema.model.domain.entity.Show;
import cinema.service.ShowService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ShowServiceImpl implements ShowService {

    @Inject
    ShowDao sdao;

    @Override
    public List<Show> getAllShows() {
        return sdao.findAll();
    }

    @Override
    public Show getShow(Long id) {
        return sdao.find(id);
    }

    @Override
    public Show removeSeats(Long showid, List<Integer> seats) {
        Show s = getShow(showid);
        System.out.println(s.getRoom().getSeats().size());
        seats.forEach((seat) -> {
            s.getRoom().getSeats().remove(seat);
        });
        System.out.println(s.getRoom().getSeats().size());
        return sdao.update(s);
    }

}
