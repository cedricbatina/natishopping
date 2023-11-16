package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;

import Entity.Client;

@Stateless
public class FacadeClient extends FacadeAbstraite<Client> {
 @PersistenceContext(unitName="natishopping");
 private EntityManager em;

 protected EntityManager getEntityManager() {
  return em;

 }

 public FacadeClient() {
  super(Client.class);
 }
}
