package EJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import Entity.Categorie;

@Stateless
public class FacadeCategorie extends FacadeAbstraite<Categorie> {
 @PersistenceContext(unitName = "natishoppingPU")
 private EntityManager em;

 protected EntityManager getEntityManager() {
  return em;
 }

 public FacadeCategorie() {
  super(Categorie.class);
 }
}
