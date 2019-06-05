package cinema.service.impl;

import cinema.model.dao.RoomDao;
import cinema.model.domain.entity.Room;
import cinema.service.RoomService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class RoomServiceImpl implements RoomService {
    
    @Inject RoomDao rdao;

    @Override
    public List<Room> getAllRooms() {
        return rdao.findAll();
    }

}
