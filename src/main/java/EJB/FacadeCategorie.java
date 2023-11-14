package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Entity.Categorie;

@Stateless
public class FacadeCategorie extends FacadeAbstraite<Categorie> {
 @PersistenceContext(unitName = "natishopping")
 private EntityManager em;

 protected EntityManager getEntityManager() {
  return em;
 }

 public FacadeCategorie() {
  super(Client.class);
 }
}
