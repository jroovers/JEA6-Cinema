package cinema.service.impl;

import cinema.model.dao.ShowDao;
import cinema.model.domain.entity.Show;
import cinema.service.ShowService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ShowServiceImpl implements ShowService {
    
    @Inject ShowDao sdao;

    @Override
    public List<Show> getAllShows() {
        return sdao.findAll();
    }
    
}
