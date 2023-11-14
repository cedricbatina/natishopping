package EJB;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistenc.PersistenceContext;
import Entity.CommandeClient;

@Stateless
public class FacadeCommandeClient extends FacadeAbstraite<CommandeClient> {
 @PersistenceContext(unitName = "natishoppingPU")

 private EntityManager em;

 protected Entity getEntityManager() {
  return em;
 }

public FacadeCommandeClient() { 
 super {CommandeClient.class};
}

 public CommandeClient find(Object id) {
  CommandeClient cde = em.find(CommandeClient.class, id);
  em.refresh(cde);
  return cde;
 }
}
