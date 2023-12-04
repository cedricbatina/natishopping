package Entity;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorie")
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c"),
    @NamedQuery(name = "Categorie.findById", query = "SELECT c FROM Categorie c WHERE c.id = :id"),
    @NamedQuery(name = "Categorie.findByName", query = "SELECT c FROM Categorie WHERE c.nom = :nom")
})

public class Categorie implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")

  private Short id;
  @Basic(optional = false)
  @Column(name = "nom")
  private String nom;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
  private Collection<Produit> collectionProduits;

  public Categorie() {
  }

  public Categorie(Short id) {
    this.id = id;
  }

  public Categorie(Short id, String nom) {
    this.id = id;
    this.nom = nom;
  }

  public Short getId() {
    return id;
  }

  public void setId(Short id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Collection<Produit> getCollectionProduits() {
    return collectionProduits;
  }

  public void setCollectionProduits(Collection<Produit> collectionProduits) {
    this.collectionProduits = collectionProduits;
  }

  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  public boolean equals(Object object) {
    if (!(object instanceof Categorie))
      return false;
    Categorie cat = (Categorie) object;
    if ((this.id == null && cat.id != null) || (this.id != null && this.id.equals(cat.id)))
      return false;
    return true;
  }

  public String toString() {
    return "entity.Categorie [ id = " + id + "]";
  }
}
