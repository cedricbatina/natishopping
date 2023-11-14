package EJB;

import EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Entity.Client;

@Stateless
public class FacadeProduit extends FacadeAbstraite<Produit> {
 @PersistenceContext(unitName = "natishoppingPU")
 private EntityManager em;

 protected EntityManager getEntityManager() {
  return em;
 }

 public FacadeProduit() { super{Produit.class};}
}
