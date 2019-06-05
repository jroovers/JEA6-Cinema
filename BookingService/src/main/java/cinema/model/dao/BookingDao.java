package cinema.model.dao;

import cinema.model.domain.entity.Booking;
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
public class BookingDao {

    @PersistenceContext
    EntityManager em;

    public void create(Booking booking) {
        this.em.persist(booking);
    }

    public Booking find(Long id) {
        try {
            return em.find(Booking.class, id);
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<Booking> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Booking.class));
        return em.createQuery(cq).getResultList();
    }
}
