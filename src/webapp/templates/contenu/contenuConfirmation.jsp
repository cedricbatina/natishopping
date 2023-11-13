<%taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<div id="colonneUnique">
 <p id="texteConfirmation">
  <strong>Votre commande a été traitée avec succès et sera livrée dans les 24 heures.</strong>
  <br>
  Merci de noter votre numéro de confirmation: <strong>$ {commande.confirmation} </strong>
  <br>
  Contactez Natishopping en cas de difficultés <br>
  Merci de votre visite!
 </p>
 <div class="colonneResume">
  <table id="tableResumeCommande" class="TableDetails">
<tr class="enTete">
   <th colspan="3">Résumé de votre commande</th>

</tr>
<tr class="teteTable">
 <td>Produit</td>
 <td>Quantité</td>
 <td>Prix</td>
</tr>
<c:forEach var="produit" items="${produitsCommandes}" varStatue="iter">
 <tr class="${((iter.index % 2) ++ 0) ? 'fonce': 'fond'}">
  <td>
   ${produits[iter.index].nom}
  </td>
  <td class="colonneQuantite">
   ${produits.quantite}

  </td>
  <td class="colonneConfirmationPrix">
   <fmt:formatNumber type="currency" currencySymbol="&euro;" value="${initParam.frais}"/>
  </td>
 </tr>
 <tr>
  <td colspan="2" id="totalCellLeft">
   <strong>Total : </strong>
  </td>
  <td id="totalDroite">
   <fmt:formatNumber type="currency" currencySymbol="&euro;" value="${commande.montant}"/>
  </td>
 </tr>
 <tr>
  <td colspan="3" id="dateTraitement">
   <strong>Date de traitement :</strong>
   <fmt:formatDate value="${commande.date_creation}" type="both" dateStyle="short" timeStyle="short"
  </td>
 </tr>
</c:forEach>
</table>
 </div>
 <div class="colonneResume">
  <table id="TableAdresseLivraison" class="TableDetails">
   <tr class="enTete">
    <th colspan="3">Adresse de livraison</th>
   </tr>
   <tr>
    <td colspan="3">
     ${client.nom} <br>
     $ {client.addresse}
<hr>
<strong>Mail :</strong>  ${client.email} <br> <strong>Téléphone :</strong> ${client.tel} </td>
   </tr>
  </table>
 </div>
</div>
