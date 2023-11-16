package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlID;

@Entity
@Table(name = "client")
@NamedQueries({ @NamedQuery(name = "Client.findAll", query = "SELECT c FROM c"),
    @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id"),
    @NamedQuery(name = "Client.findByName", query = "SELECT c FROM Client  c WHERE c.nom = :nom"),
    @NamedQuery(name = "Client.findByMail", query = "SELECT c FROM Client c WHERE c.email = :email"),
    @NamedQuery(name = "Client.findByPhone", query = "SELECT c FROM Client c WHERE c.tel = :tel"),
    @NamedQuery(name = "Client.findByAddress", query = "SELECT c FROM Client c WHERE c.addresse = :addresse"),
    @NamedQuery(name = "Client.findByCcNumber", query = "SELECT c FROM Client c WHERE c.carte = :carte")
})

public class Client implements Serializable {
  private static final long serialVersionUID = 1L;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @Column(name = "nom")
  private String nom;
  @Basic(optional = false)
  @Column(name = "email")
  private String email;
  @Basic(optional = false)
  @Column(name = "tel")
  private String tel;
  @Basic(optional = false)
  @Column(name = "addresse")
  private String addresse;
  @Basic(optional = false)
  @Column(name = "carte")
  private String carte;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
  private Collection<CommandeClient> collectionCommandeClients;

  public Client() {
  }

  public Client(Integer id) {
    this.id = id;
  }

  public Client(Integer id, String nom, String email, String tel, String addresse, String carte) {
    this.id = id;
    this.nom = nom;
    this.email = email;
    this.tel = tel;
    this.addresse = addresse;
    this.carte = carte;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getAddresse() {
    return addresse;
  }

  public void setAddresse(String addresse) {
    this.addresse = addresse;
  }

  public String getCarte() {
    return carte;
  }

  public void setCarte(String carte) {
    this.carte = carte;
  }

  public Collection<CommandeClient> getCollectionCommandeClients() {
    return collectionCommandeClients;
  }

  public void setCollectionCommandesClient(Collection<CommandeClient> collectionCommandeClients) {
    this.collectionCommandeClients = collectionCommandeClients;
  }

  public int hashcode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  public boolean equals(Object objet) {
    if (!(objet instanceof Client))
      return false;
    Client cli = (Client) objet;
    if ((this.id == null && cli.id != null) || (this.id == null && cli.id != null)
        || (this.id != null && !this.id.equals(cli.id)))
      return false;
    return true;
  }

  public String toString() {
    return "entity.Client[ id : " + id + "]";
  }
}
