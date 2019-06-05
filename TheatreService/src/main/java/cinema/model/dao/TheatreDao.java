package cinema.model.dao;

import cinema.model.domain.entity.Theatre;
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
public class TheatreDao {

    @PersistenceContext
    EntityManager em;

    public void create(Theatre theatre) {
        this.em.persist(theatre);
    }

    public Theatre find(Long id) {
        try {
            return em.find(Theatre.class, id);
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<Theatre> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Theatre.class));
        return em.createQuery(cq).getResultList();
    }
}
