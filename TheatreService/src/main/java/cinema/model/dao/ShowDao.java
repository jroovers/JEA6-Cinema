package cinema.model.dao;

import cinema.model.domain.entity.Show;
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
public class ShowDao {

    @PersistenceContext
    EntityManager em;

    public void create(Show show) {
        this.em.persist(show);
    }

    public Show find(Long id) {
        try {
            return em.find(Show.class, id);
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<Show> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Show.class));
        return em.createQuery(cq).getResultList();
    }
}
