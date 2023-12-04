package EJB;

//import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
//import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import Entity.CommandeClient;

@Stateless
public class FacadeCommandeClient extends FacadeAbstraite<CommandeClient> {
 @PersistenceContext(unitName = "natishoppingPU")

 private EntityManager em;

 protected EntityManager getEntityManager() {
  return em;
 }

 public FacadeCommandeClient() {
  super(CommandeClient.class);
 }

 public CommandeClient find(Object id) {
  CommandeClient cde = em.find(CommandeClient.class, id);
  em.refresh(cde);
  return cde;
 }
}
