package EJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import Entity.Produit;

@Stateless
public class FacadeProduit extends FacadeAbstraite<Produit> {
 @PersistenceContext(unitName = "natishoppingPU")
 private EntityManager em;

 protected EntityManager getEntityManager() {
  return em;
 }

 public FacadeProduit() {
  super(Produit.class);
 }
}
