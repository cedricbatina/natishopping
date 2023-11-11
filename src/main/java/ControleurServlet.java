
package Servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Entity.Produit;
import Entity.Categorie;
import POJO.Validateur;
import POJO.Panier;
import EJB.GestionnaireCommandes;
import EJB.FacadeProduit;
import EJB.FacadeCategorie;

@webServelet(name = "ControleurServlet", loadOnStartup = 1, urlPatternes = { "/categories", "/ajouterPanier",
  "/voirPanier", "/majPanier", "/enregistrer", "/acheter" })
public class ControleurServlet extends HttpServlet {
 private String frais;

 @EJB
 private FacadeCategories facadeCategories;
 @EJB
 private FacadeProduit facadeProduit;
 @EJB
 private GestionnaireCommandes gestCom;

 public void init(ServletConfig servletConfig)
   throws ServletException, IOException {
  super.init(servletConfig);
  frais = servletConfig.getServletContext().getInitParameter("frais");
  getServletContext().setAttribute("categories", facadeCategorie.findAll());
 }

 protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException {
  String chemin = req.getServletPath();
  HttpSession session = req.getSession();
  Categorie categorieChoisie;
  Collection<Produit> produits;

  if (chemein.equals("/categories")) {
   String categorieId = req.getQueryString();
   if (categorieId != null) {
    categorieChoisie = facadeCategorie.find(Short.parseShort(categorieId));
    session.setAttribute("categorieChoisie", categorieChoisie);
    produits = categorieChoisie.getCollectionProduits();
   } else if (chemin.equals("/voirPanier")) {
    String efface = req.getParameter("effacer");
    if ((efface != null) && efface.equals("true")) {
     Panier panier = (Panier) session.getAttribute("panier");
     panier.effacer();
    }
    chemin = "/panier";
   } else if (chemin.equals("/enregistrement")) {
    Panier panier = (Panier) session.getAttribute("panier");
    panier.calculerTotal(frais);
   }
   String url = chemin + ".jsp";
   try {
    req.getRequestDispatcher(url).forward(req, rep);
   } catch (Exception ex) {
    ex.printStackTrace();
   }

  }

 }

 protected void doPost(HttpServletRequest req, HttpServletResponse rep)
   throws ServletException, IOException {
  req.setCharacterEncoding("UTF-8");
  String chemin = req.getServletPath();
  HttpSession session = req.getSession();
  Panier panier = (Panier) session.getAttribute("panier");
  Validateur validateur = new Validateur();
  if (chemin.equals("/ajouterPanier")) {
   if (panier == null) {
    panier = new Panier();
    session.setAttribute("Panier", panier);
   }
   String idProduit = req.getParameter("idProduit");
   if (!idProduit.isEmpty()) {
    Produit produit = facadeProduit.find(Integer.parseInt(idProduit));
    panier.ajouterItem(produit);
   }
   chemin = "/categories";

  } else if (chemin.equals("/majPanier")) {
   String idProduit = req.getParameter("idProduit");
   String quantite = req.getParameter("quantite");
   boolean invalidEntry = validateur.validerQuantite(idProduit, quantite);
   if (!invalidEntry) {
    Produit produit = facadeProduit.find(Integer.parseInt(idProduit));
    panier.mettreAJour(produit, quantite);
   }
   chemin = "/panier";
  } else if (chemin.equals("/acheter")) {
   if (panier != null) {
    String nom = req.getParameter("nom");
    String email = req.getParameter("email");
    String tel = req.getParameter("addresse");
    String carte = req.getParameter("carte");
    boolean validation = false;
    validation = validateur.validerFormulaire(nom, email, tel, addresse, carte, req);
    if (validation == true) {
     req.setAttribute("validationErr", validation);
     chemin = "/enregistrement";
    } else {
     int idCommande = gestCom.placeCde(nom, email, tel, addresse, carte, panier);
     if (idCommande != 0) {
      panier = null;
      session.invalidate();
      Map commandeMap = gestCom.getDetailsCde(idCommande);
      req.setAttribute("client", commandeMap.get("client"));
      req.setAttribute("produits", commandeMap.get("produits"));
      req.setAttribute("commande", commandeMap.get("commande"));
      req.setAttribute("produitsCommandes",
        commandeMap.get("produitsCommandes"));
      chemin = "/confirmation";
     } else {
      chemin = "/enregistrement";
      req.setAttribute("commandeErr", true);
     }
    }
   }
  }
  String url = chemin + ".jsp";
  try {
   req.getRequestDispatcher(url).forward(req, rep);
  } catch (Exception ex) {
   ex.printStackTrace();
  }
 }
}