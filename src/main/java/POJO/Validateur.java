package POJO;

import javax.servlet.http.HttpServletRequest;

public class Validateur {
 public boolean validerQuantite(String pid, String qt) {
  boolean boolErr = false;
  if (!pid.isEmpty() && !qt.isEmpty()) {
   int i = 1;
   try {
    i = Integer.parseInt(qt);
   } catch (NumberFormatException nfe) {
    System.out.println("Quantite pas numérique");
   }
   if (i < 0 || i > 99)
    boolErr = true;
  }
  return boolErr;
 }

 public boolean validerFormulaire(String nom, String email, String tel, String addresse, String carte,
   HttpServletRequest req) {
  boolean boolErr = false;
  boolean nomErr;
  boolean emailErr;
  boolean telErr;
  boolean addresseErr;
  boolean carteErr;
  if (nom == null || nom.equals("") || !nom.length() > 45) {
   boolErr = true;
   nomErr = true;
   req.setAttribute("nomErr", nomErr);

  }
  if (email == null || email.equals("") || !email.contains("@")) {
   boolErr = true;
   emailErr = true;
   req.setAttribute("emailErr", emailErr);
  }
  if (tel == null || tel.equals("") || tel.length() < 9) {
   boolErr = true;
   telErr = true;
   req.setAttribute("telErr", telErr);
  }
  if (addresse == null || addresse.equals("") || addresse.length() > 45) {
   boolErr = true;
   addresseErr = true;
   req.setAttribute("addresseErr", addresseErr);
  }
  if (carte == null || carte.equals("") || carte.length() > 19) {
   boolErr = true;
   carteErr = true;
   req.setAttribute("carteErr", carteErr);
  }
  return boolErr;
 }
}
