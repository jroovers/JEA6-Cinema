package cinema.model.dao;

import cinema.model.domain.entity.Room;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jeroen Roovers
 */
@Stateless
public class RoomDao {

    @PersistenceContext
    EntityManager em;

    public void create(Room room) {
        this.em.persist(room);
    }

    public Room find(Long id) {
        try {
            return em.find(Room.class, id);
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<Room> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Room.class));
        return em.createQuery(cq).getResultList();
    }
}
