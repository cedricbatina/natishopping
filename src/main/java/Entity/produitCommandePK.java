package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable

public class ProduitCommandePK implements Serializable {
  @Basic(optional = false)
  @Column(name = "commande_client_id")
  private int commande_client_id;
  @Basic(optional = false)
  @Column(name = "produit_id")
  private int produit_id;

  public ProduitCommandePK() {

  }

  public ProduitCommandePK(int commande_client_id, int produit_id) {
    this.commande_client_id = commande_client_id;
    this.produit_id = produit_id;
  }

  public int getCommandeClientId() {
    return commande_client_id;
  }

  public void setCommandeClientId(int commande_client_id) {
    this.commande_client_id = commande_client_id;
  }

  public int getProduitId() {
    return produit_id;
  }

  public void setProduitId(int produit_id) {
    this.produit_id = produit_id;
  }

  public int hashCode() {
    int hash = 0;
    hash += (int) commande_client_id;
    hash += (int) produit_id;
    return hash;
  }

  public boolean equals(Object objet) {
    if (!(objet instanceof ProduitCommandePK))
      return false;
    ProduitCommandePK pcpk = (ProduitCommandePK) objet;
    if (this.commande_client_id != pcpk.commande_client_id)
      return false;
    if (this.produit_id != pcpk.produit_id)
      return false;
    return true;
  }

  public String toString() {
    return "entity.ProduitCommandePK[commande_client_id =" + commande_client_id + ", produit_id = " + "]";
  }
}
