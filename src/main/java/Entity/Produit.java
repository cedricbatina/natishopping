package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.util.Date;
import javax.xml.bind.annotation.XmlID;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Generatedvalue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TemporalType;

@Entity
@Table(name = "produit")
@NamedQueries({
  @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
  @NamedQuery(name = "Produit.findById", query = "SELECT p FROM Produit p WHERE p.id = :id")
})

public class Produit implements Serializable {
 private static final long serialVersionUID = 1L;
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Basic(optional = false)
 @Column(name = "id")
 private Integer id;
 @Basic(optional = false)
 @Column(name = "nom")
 private String nom;
 @Basic(optional = false)
 @Column(name = "prix")
 private BigDecimal prix;
 @Basic(optional = false)
 @Column(name = "description")
 private String description;
 @Basic(optional = false)
 @Column(name = "derniere_maj")
 private String derniere_maj;
 @Temporal(TemporalType.DATE)
 private Date derniere_maj;
 @JoinColumn(name = "categorie_id", referencedColumnName = "id")
 @ManyToOne(optional = false)
 private Categorie categorie;
@OneToMany (cascade = CascadeType.ALL, mappedBy="produit")
private Collection <ProduitCommande> collectionProduitsCommandes

 public Produit() {
 }

 public Produit(Integer id) {
  this.id = id;
 }

 public Produit(Integer id, String nom, BigDecimal prix, String description, Date derniere_maj) {
  this.id = id;
  this.nom = nom;
  this.prix = prix;
  this.description = description;
  this.derniere_maj = derniere_maj;
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

 public BigDecimal getPrix() {
  return prix;
 }

 public void setPrix(BigDecimal prix) {
  this.prix = prix;
 }

 public String getDescription() {
  return description;
 }

 public void setDescription(String description) {
  this.description = description;
 }

 public Date getDerniereMaj() {
  return derniere_maj;
 }

 public void setDernierMaj() {
  this.dernier_maj = derniere_maj;
 }

 public Categorie getCategorie() {
  return categorie;
 }

 public void setCategorie(Categorie categorie) {
  this.categorie = categorie;
 }

 public Collection<ProduitCommande> getCollectionProduitsCommandes() {
  return getCollectionProduitsCommandes();
 }

 public void setCollectionProduitsCommandes(Collection<ProduitCommande> collectionProduitsCommandes) {
  this.collectionProduitsCommandes = collectionProduitsCommandes;
 }

 public int hashCode() {
  int hash = 0;
  hash += (id != null ? id.hashCode() : 0);
  return hash;
 }

 public boolean equals(Object objet) {
  if (!(objet instanceof Produit))
   return false;
  Produit prod = (Produit) objet;
  if ((this.id == null && !this.id.equals(prod.id)))
   return false;
  return true;
 }

 public String toString() {
  return "entity.Produit [ id = " + id + "]";
 }
}