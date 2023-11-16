package POJO;

import Entity.Produit;

public class ItemPanier {
 Produit produit;
 short quantite;

 public ItemPanier(Produit produit) {
  this.produit = produit;
  quantite = 1;
 }

 public Produit getProduit() {
  return produit;
 }

 public short getQuantite() {
  return quantite;
 }

 public void setQuantite(short quantite) {
  this.quantite = quantite;
 }

 public void incrementerQuantite() {
  quantite++;
 }

 public void decrementerQuantite() {
  quantite--;
 }

 public double getTotal() {
  double montant = 0;
  montant = (this.getQuantite() * produit.getPrix().doubleValue());
  return montant;
 }
}
