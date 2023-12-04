package EJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
//import jakarta.swing.text.html.parser.Entity;

import Entity.Client;

@Stateless
public class FacadeClient extends FacadeAbstraite<Client> {
 @PersistenceContext(unitName = "natishoppingPU")
 private EntityManager em;

 protected EntityManager getEntityManager() {
  return em;

 }

 public FacadeClient() {
  super(Client.class);
 }
}
