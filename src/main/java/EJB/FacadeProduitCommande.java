package EJB;

import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
//import jakarta.swing.text.html.parser.Entity;

import Entity.ProduitCommande;

@Stateless
public class FacadeProduitCommande extends FacadeAbstraite<ProduitCommande> {
  @PersistenceContext(unitName = "natishoppingPU")

  private EntityManager em;

  protected EntityManager getEntityManager() {
    return em;
  }

  public FacadeProduitCommande() {
    super(ProduitCommande.class);
  }

  public List<ProduitCommande> findByOrderId(Object id) {
    return em.createNamedQuery("ProduitCommande.findByCustomerOrderId", ProduitCommande.class)
        .setParameter("commande_client_id", id)
        .getResultList();
  }

}
