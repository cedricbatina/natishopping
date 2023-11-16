package POJO;

import java.util.*;
import java.util.ArrayList;

import Entity.Produit;

public class Panier {
 List<ItemPanier> items;
 int nbItems;
 double total;

 public Panier() {
  items = new ArrayList<ItemPanier>();
  nbItems = 0;
  total = 0;
 }

 public synchronized void ajouterItem(Produit produit) {
  boolean nouveau = true;
  for (ItemPanier item : items) {
   if (item.getProduit().getId() == produit.getId()) {
    nouveau = false;
    item.incrementerQuantite();
   }
  }
  if (nouveau) {
   ItemPanier item = new ItemPanier(produit);
   items.add(item);
  }
 }

 public synchronized void mettreAJour (Produit produit , String qte)  {
  short qt = -1;
  qt = Short.parseShort(qte);
  if (qt >=0) {
   ItemPanier item = null;
   for (ItemPanier it : items) {
    if (it.getProduit().getId () ==  produit.getId()) {
     if (qt != 0) {
      it.setQuantite(qt);
     }
     else {item = it;
     break;}
    }
   }
     if (item != null) items.remove(item)

  }
 }

 public synchronized List<ItemPanier> getItems() {
  return items;
 }

 public synchronized int getnbItems() {
  nbItems = 0;
  for (ItemPanier scItem : items) {
   nbItems += scItem.getQuantite();
  }
  return nbItems;
 }

 public synchronized double getSousTotal() {
  double montant = 0;
  for (ItemPanier scItem : items) {
   nbItems += scItem.getQuantite();
  }
  return montant;
 }

 public synchronized void calculerTotal(String frais) {
  double montant = 0;
  double fr = Double.parseDouble(frais);
  montant = this.getSousTotal();
  montant += fr;
  total = montant;
 }

 public synchronized double getTotal() {
  return total;
 }

 public synchronized void effacer() {
  items.clear();
  nbItems = 0;
  total = 0;
 }

}
