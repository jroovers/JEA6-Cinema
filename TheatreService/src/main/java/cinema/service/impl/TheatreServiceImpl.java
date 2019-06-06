package cinema.service.impl;

import cinema.model.dao.TheatreDao;
import cinema.model.domain.entity.Theatre;
import cinema.service.TheatreService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class TheatreServiceImpl implements TheatreService {
    
    @Inject TheatreDao tdao;

    @Override
    public List<Theatre> getAllTheatres() {
        return tdao.findAll();
    }

    @Override
    public Theatre getTheatre(Long id) {
        return tdao.find(id);
    }
    
}
