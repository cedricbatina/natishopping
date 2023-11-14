package EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;

import Entity.ProduitCommande;

@Stateless
public class FacadeProduitCommande extends FacadeAbstraite<ProduitCommande> {
 @PersistenceContext(unitName = "natishoppingPU")

 private EntityManager em;

 protected EntityManager getEntityManager() {
  return em;
 }

 public FacadeCommandeClient () {
  super(commandeClient.class);
 }

 public List<ProduitCommande> findByOrderId(Object id) {
  return em.createNamedQuery("ProduitCommande.findByCustomerOrderId").setParameter("commande_client_id", id)
    .getResultList();
 }
}
