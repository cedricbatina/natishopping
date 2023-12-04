package Entity;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "commande_client_vers_produit")
@NamedQueries({
    @NamedQuery(name = "ProduitCommande.findAll", query = "SELECT O FROM ProduitCommande o"),
    @NamedQuery(name = "ProduitCommade.findByCostomerOrderId", query = "SELECT o FROM ProduitCommande o WHERE o.produitCommandePK.commmande_client_id = :commande_client_id"),
    @NamedQuery(name = "ProduitCommande.findByProductId", query = "SELECT o FROM ProduitCommande o WHERE  o.produitCommandePK.produit_id = :produit_id"),
    @NamedQuery(name = "ProduitCommande.findByQuantity", query = " SELECT o FROM ProduitCommande o WHERE o.quantite = :quantite")

})

public class ProduitCommande implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ProduitCommandePK produitCommandePK;
  @Basic(optional = false)
  @Column(name = "quantite")
  private Short quantite;
  @JoinColumn(name = "produit_id", referencedColumnName = "id", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Produit produit;
  @JoinColumn(name = "commande_client_id", referencedColumnName = "id", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private CommandeClient commandeClient;

  public ProduitCommande() {

  }

  public ProduitCommande(ProduitCommandePK produitCommandePK) {
    this.produitCommandePK = produitCommandePK;
  }

  public ProduitCommande(ProduitCommandePK produitCommandePK, Short quantite) {
    this.produitCommandePK = produitCommandePK;
    this.quantite = quantite;
  }

  public ProduitCommande(int commandeClientId, int produitId) {
    this.produitCommandePK = new ProduitCommandePK(commandeClientId, produitId);
  }

  public ProduitCommandePK getProduitCommandePK() {
    return produitCommandePK;
  }

  public void setProduitCommandePK(ProduitCommandePK produitCommandePK) {
    this.produitCommandePK = produitCommandePK;
  }

  public Short getQuantite() {
    return quantite;
  }

  public void setQuantite(Short quantite) {
    this.quantite = quantite;
  }

  public Produit getProduit() {
    return produit;

  }

  public void setProduit(Produit produit) {
    this.produit = produit;
  }

  public CommandeClient getCommande() {
    return commandeClient;
  }

  public void setCommandeClient(CommandeClient commandeClient) {
    this.commandeClient = commandeClient;
  }

  public int hashCode() {
    int hash = 0;
    hash += (produitCommandePK != null ? produitCommandePK.hashCode() : 0);
    return hash;

  }

  public boolean equals(Object objet) {
    if (!(objet instanceof ProduitCommande))
      return false;
    ProduitCommande pc = (ProduitCommande) objet;
    if ((this.produitCommandePK == null && pc.produitCommandePK != null)
        || (this.produitCommandePK != null && pc.produitCommandePK != null)
        || (this.produitCommandePK != null && !this.produitCommandePK.equals(pc.produitCommandePK)))
      return false;
    return true;
  }

  public String toString() {
    return "entity.ProduitCommande[produitCommandePK " + produitCommandePK + "]";
  }
}