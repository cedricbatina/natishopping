<%taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8">
<c:set var="view" value="/enregistrement" scope="session"/>
<div id="colonneUnique">
 <h2>Enregistrement</h2>
 <p>Pour acheter les articles de votre panier merci de fournir les informations ci-dessous : </p>
 <form action="<c:url value='acheter'/ " id="checkoutForm" method="post">
  <table id="TableEnregistrement">
   <c:if test="${!empty validationErr}">
 <tr>
  <td colspan="2" style="text-align: left;">
  <span class="erreur petitTexte">Merci de compléter ou corriger :
   <c:if test="${!empty nomErr}">
    <br> <span class="indent">- le nom</span>
   </c:if> 
  <c:if test="${!empty emailErr}">
   <br> <span class="indent">- l'adresse mail</span>
  </c:if> 
 <c:if test="${!empty telErr}"><br> <span class="indent">- le numéro de téléphone</span> </c:if>
<c:if test="${!empty addressErr}">
 <br> <span class="indent">- l'adresse</span>
</c:if>
<c:if test="${!empty carteErr}">
<br> <span class="indent">- le numéro de la carte bancaire</span>

</c:if>
</span>

  </td>
 </tr>
  </c:if>
<tr>
 <td class="champSaisie">
  <input type="text" size="31" maxlength="45" id="name" name="nom" value="${param.name}">
 </td>
</tr>
<tr>
 <td class="">
  <label for="email">Mail :</label>
 </td>
 <td class="champSaisie">
  <input type="text " size="31" maxlength="45" id="email" name="email" value="${param.email}">
 </td>
</tr>
<tr>
 <td>
  <label for="phone">Numéro de téléphone</label>
 </td>
 <td class="champSaisie">
  <input type="text" size="31" maxlength="45" value="${param.phone}">
 </td>
</tr>
<tr>
 <td>
  <label for="address">Adress :</label>
 </td>
<td>
 <label for="creditcard">Carte de crédit :</label>
</td>
<td class="champSaisie">
 <input type="text" size="31" maxlength="19" id="creditcard" name="carte" class="creditcard" value="${param.creditcard}">

</td>

</tr>

<tr>
<td colspan="2">
 <input type="submit" value="Enregistrer">
</td>


</tr>




  </table>
 </form>
<div id="BoiteInfo">
 <ul>
  <li>   Livraison le lendemain garantie.  </li>
  <li>   Des frais de <fm:formatNumber type="currency" currencySymbl="&euro;" value="${initParam.frais}"> sont appliqués à toutes les commandes</fm:formatNumber>  </li>
 </ul>
 <table id="BoitePrix">
  <tr>
   <td>
    Sous total :
   </td>
   <td class="colonneEnregistrementPrix">
    <fmt:formatNumber type="currency" currencySymbol="&euro;" value="${panier.soustotal}"/>
   </td>
  </tr>
  <tr>
   <td>Frais :</td>
   <td class="colonneEnregistrementPrix"><fmt:formatNumber type="currency" currencySymbol="&euro;" value="${initParam.frais}"/> </td>
  </tr>
  <tr>
   <td class="total" >Total :</td>
   <td class="total colonneEnregistrementPrix" ><fmt:formatNumber type="currency" currencySymbol="&euro;" value="${panier.total}"/> </td>
  </tr>
 </table>
</div>

</div>