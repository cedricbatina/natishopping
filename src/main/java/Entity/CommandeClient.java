package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

//import jakarta.management.MXBean;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
//import jakarta.xml.bind.annotation.XmlID;

@Entity
@Table(name = "commande_client")
@NamedQueries({
    @NamedQuery(name = "CommandeClient.findAll", query = "SELECT c FROM CommandeClient c"),
    @NamedQuery(name = "CommandeClient.findById", query = "SELECT c FROM CommandeClient c WHERE c.id = :id"),
    @NamedQuery(name = "CommandeClient.findById", query = "SELECT c FROM CommandeClient c "),
    @NamedQuery(name = "CommandeClient.findByCustomer", query = "SELECT c FROM CommandeClient c WHERE c.client = :client"),
    @NamedQuery(name = "CommandeClient.findByAmount", query = "SELECT c FROM CommandeCLient c WHERE c.amount = :amount"),
    @NamedQuery(name = "CommandeClient.findByCreated", query = "SELECT c FROM CommandeClient c WHERE c.date_creation = :date_creation"),
    @NamedQuery(name = "CommandeClient.findByConfirmationNumber", query = "SELECT c FROM CommandeClient c WHERE c.confirmation = :confirmation")
})

public class CommandeClient implements Serializable {
  private static final long serialVersionUID = 1L;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @Column(name = "montant")
  private BigDecimal montant;
  @Basic(optional = false)
  @Column(name = "date_creation")
  @Temporal(TemporalType.DATE)
  private Date date_creation;
  @Basic(optional = false)
  @Column(name = "no_confirmation")
  private int confirmation;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "commandeClient")
  private Collection<ProduitCommande> collectionProduitsCommandes;
  @JoinColumn(name = "client_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Client client;

  public CommandeClient() {
  }

  public CommandeClient(Integer id) {
    this.id = id;
  }

  public CommandeClient(Integer id, BigDecimal montant, Date date_creation, int confirmation) {
    this.id = id;
    this.montant = montant;
    this.date_creation = date_creation;
    this.confirmation = confirmation;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public BigDecimal getMontant() {
    return montant;
  }

  public void setMontant(BigDecimal montant) {
    this.montant = montant;
  }

  public Date getdate_creation() {
    return date_creation;
  }

  public void setdate_creation(Date date_creation) {
    this.date_creation = date_creation;
  }

  public int getConfirmation() {
    return confirmation;
  }

  public void setConfirmation(int confirmation) {
    this.confirmation = confirmation;
  }

  public Collection<ProduitCommande> getCollectionProduitsCommandes() {
    return collectionProduitsCommandes;
  }

  public void setCollectionProduitsCommandes(Collection<ProduitCommande> collectionProduitsCommandes) {
    this.collectionProduitsCommandes = collectionProduitsCommandes;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  public boolean equals(Object objet) {
    if (!(objet instanceof CommandeClient))
      return false;
    CommandeClient cc = (CommandeClient) objet;
    if ((this.id == null && cc.id != null) || (this.id != null && cc.id != null)
        || (this.id != null && (!this.id.equals(cc.id))))
      return false;
    return true;
  }

  public String toString() {
    return "entity.CommandeClient[id=" + id + "]";
  }
}
