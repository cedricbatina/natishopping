package EJB;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public abstract class FacadeAbstraite<T> {
  private Class<T> classeEntite;

  public FacadeAbstraite(Class<T> classeEntite) {
    this.classeEntite = classeEntite;
  }

  protected abstract EntityManager getEntityManager();

  public void create(T entite) {
    getEntityManager().persist(entite);
  }

  public void edit(T entite) {
    getEntityManager().merge(entite);
  }

  public void remove(T entite) {
    getEntityManager().remove(getEntityManager().merge(entite));
  }

  public T find(Object id) {
    return getEntityManager().find(classeEntite, id);
  }

  public List<T> findAll() {
    CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
    CriteriaQuery<T> cq = cb.createQuery(classeEntite);
    cq.select(cq.from(classeEntite));
    return getEntityManager().createQuery(cq).getResultList();
  }

  public List<T> findRange(int[] etendue) {
    CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
    CriteriaQuery<T> cq = cb.createQuery(classeEntite);
    cq.select(cq.from(classeEntite));
    TypedQuery<T> q = getEntityManager().createQuery(cq);
    q.setMaxResults(etendue[1] - etendue[0]);
    q.setFirstResult(etendue[0]);
    return q.getResultList();
  }

  public int count() {
    CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Long> cq = cb.createQuery(Long.class);
    Root<T> rt = cq.from(classeEntite);
    cq.select(cb.count(rt));
    TypedQuery<Long> q = getEntityManager().createQuery(cq);
    return ((Long) q.getSingleResult()).intValue();
  }

}

/*
 * public List<T> findRange(int[] etendue) {
 * jakarta.persistence.criteria.CriteriaQuery cq =
 * getEntityManager().getCriteriaBuilder().createQuery();
 * cq.select(cq.from(classeEntite));
 * jakarta.persistence.Query q = getEntityManager()
 * .createQuery(cq);
 * q.setMaxResults(etendue[1] - etendue[0]);
 * q.setFirstResult(etendue[0]);
 * return q.getResultList();
 * }
 * 
 * public int count() {
 * jakarta.persistence.criteria.CriteriaQuery cq =
 * getEntityManager().getCriteriaBuilder().createQuery();
 * jakarta.persistence.criteria.Root<T> rt = cq.from(classeEntite);
 * cq.select(getEntityManager().getCriteriaBuilder().count(rt));
 * jakarta.persistence.Query q = getEntityManager().createQuery(cq);
 * return ((long) q.getSingleResult()).intValue();
 * }
 * * public List<T> findAll() {
 * jakarta.persistence.criteria.CriteriaQuery cq =
 * getEntityManager().getCriteriaBuilder().createQuery();
 * cq.select(cq.from(classeEntite));
 * return getEntityManager().createQuery(cq).getResultList();
 * }
 * }
 */
