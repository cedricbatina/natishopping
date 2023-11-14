package EJB;

import java.util.List;
import javax.persistence.EntityManager;

public abstract class FacadeAbstraite<T> {
  private Class<T> classeEntite;

  public FacadeAbstraite(Class<T> classeEntite) {
    this.classeEntite = classeEntite;
  }

 protected abstract EntityManager getEntityManager();pblic

  void create(T entite) {
    getEntityManager().persist(entite);
  }

  public void edit(T entite) {
    getEntityManager().merge(entite);
  }

 public void remove (T entite) {
  getEntieyManager().remove(getEntityManager().merge(entite))
 }

  public T find(Object id) {
    return getEntityManager().find(classeEntite, id);
  }

  public List<T> findAll() {
    javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
    cq.select(cq.from(classeEntite));
    return getEntityManager().createQuery(cq).getResultList();
  }

  public List<T> findRange(int[] etendue) {
    javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
    cq.select(cq.from(classeEntite));
    javax.persistence.Query q = getEntityManager()
        .createQuery(cq);
    q.setMaxResults(etendue[1] - etendue[0]);
    q.setFirstResult(etendue[0]);
    return q.getResultList();
  }

  public int count() {
    javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
    javax.persistence.criteria.Root<T> rt = cq.from(classeEntite);
    cq.select(getEntityManager().getCriteriaBuilder().count(rt));
    javax.persistence.Query q = getEntityManager().createQuery(cq);
    return ((long) q.getSingleResult()).intValue();
  }

}