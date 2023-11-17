package EJB;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Entity.Produit;
import Entity.ProduitCommande;
import Entity.ProduitCommandePK;
import Entity.Client;
import Entity.CommandeClient;
import POJO.ItemPanier;
import POJO.Panier;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)

public class GestionnaireCommandes {
  @PersistenceContext(unitName = "natishoppingPU")

  private EntityManager em;
  @Resource
  private SessionContext contexte;
  @EJB
  private FacadeProduit facadeProduit;
  @EJB
  private FacadeCommandeClient facadeCommandeClient;
  @EJB
  private FacadeProduitCommande facadeProduitCommande;

  @TransactionAttribute(TransactionAttributeType.REQUIRED)

  public int placeCde(String nom, String email, String tel, String addresse, String carte, Panier panier) {
    try {
      Client client = ajouteClient(nom, email, tel, addresse, carte);
      CommandeClient cde = ajouteCommande(client, panier);
      return cde.getId();
    } catch (Exception e) {
      contexte.setRollbackOnly();
      return 0;
    }

  }

  private Client ajouteClient(String nom, String email, String tel, String addresse, String carte) {
    Client client = new Client();
    client.setNom(nom);
    client.setEmail(email);
    client.setTel(tel);
    client.setAddresse(addresse);
    client.setCarte(carte);
    em.persist(client);
    return client;
  }

  private CommandeClient ajouteCommande(Client client, Panier panier) {
    CommandeClient cde = new CommandeClient();
    cde.setClient(client);
    cde.setMontant(BigDecimal.valueOf(panier.getTotal()));
    Random random = new Random();
    int i = random.nextInt(999999999);
    cde.setConfirmation(i);
    em.persist(cde);
    return cde;
  }

  private void ajouteProduitsCommande(CommandeClient order, Panier panier) {
    em.flush();
    List<ItemPanier> items = panier.getItems();
    for (ItemPanier scItem : items) {
      int productId = scItem.getProduit().getId();
      ProduitCommandePK orderedProductPK = new ProduitCommandePK(productId, productId);
      orderedProductPK.setCommandeClientId(order.getId());
      orderedProductPK.setProduitId(productId);
      ProduitCommande orderedItem = new ProduitCommande(orderedProductPK);
      orderedItem.setQuantite(scItem.getQuantite());
      em.persist(orderedItem);
    }

  }

  public Map<String, Object> getDetailsCde(int idCde) {
    Map<String, Object> cdeMap = new HashMap<>();
    CommandeClient cde = facadeCommandeClient.find(idCde);
    Client client = cde.getClient();
    List<ProduitCommande> produitsCommandes = facadeProduitCommande.findByOrderId(idCde);
    List<Produit> produits = new ArrayList<Produit>();
    for (ProduitCommande op : produitsCommandes) {
      Produit p = (Produit) facadeProduit.find(op.getProduitCommandePK().getProduitId());
      produits.add(p);

    }
    cdeMap.put("commande", cde);
    cdeMap.put("client", client);
    cdeMap.put("produitsCommandes", produitsCommandes);
    cdeMap.put("produits", produits);
    return cdeMap;

  }
}