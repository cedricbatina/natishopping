<%taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/functions" %>
<%page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<c: set var="view" value="/panier" scope="session"/>
<div id="colonneUnique">
 <c:choose>
  <c:when test ="${panier.nbItems > 1}">
   <p>
    Votre panier contient ${panier.nbItems} articles.
   </p>
  </c:when>
<c:otherwise> <p> Votre panier est vide.</p> </c:otherwise>
 </c:choose>
<div id="BarreActions">
 <c:if test="${!empty panier && panier.nbItems != 0 }">
  <c:url var="url" value="voirPanier">
   <c:param name="effacer" value=" true"/>

  </c:url>
  <a href="${url}" class="bulle margeH">Vider le panier</a>
 </c:if>
 <c:set var="value">
  <c:choose>
   <c:when test ="${!empty categorieChoisie}">
    categories
   </c:when>
   <c:otherwise>
   index.jsp
  </c:otherwise>
  </c:choose>
  

 </c:set>
<c:url var="url" value="${value}"/>
<a href="${url}" class="bulle margeH"> Continuer les achats</a>
<c:if test ="${!empty panier && panier.nbItems != 0 }">
 <a href="<c:url value='enregistrement'/> " class="bulle margeH"> Terminer les achats</a>
</c:if>


</div>
<c:if test="${!empty panier && panier.nbItems != 0 }">
 <h4 id="soustotal">
  <fmt:formatNumber type="currency" currencySymbol="&euro;" value="${panier.soustotal}"/>
 </h4>
 <table id="TablePanier">
  <tr class="enTete">
   <th>Produit</th>
   <th> Description</th>
   <th>Prix</th>
   <th>Quantité</th>
  </tr>

<c:forEach var="itemPanier" items="${panier.items}" varStatus="iter">
 <c:set var="product" value ="${itemsPanier.produit}"/>

<tr class="${((iter.index % 2) == 0 ) ? 'fonce' : 'fond'}">
 <td>
  <img src="${initParam.cheminImagesProduits} $ {product.nom}.png" alt="${product.description}">
 </td>
 <td>
  $ {product.nom}
  </td>
 <td>
<fmt:formatNumber type="currency" currencySymbol="&euro;" value="${itemPanier.total}">
 <br><span class="petitTexte">   (
  <fmt:formatNumber type="currency" currencySymbol="&euro;" value= "${product.prix}"/> / unité)

 </span>
</fmt:formatNumber> 


 </td>
<td>
 <form action="<c:url value='majPanier'/" method="post">
  <input type="hidden" name="idProduit" id="" value="${produit.id}">
  <input type="text " maxlength="2" size="2" value="${itemPanier.quantite} " name="quantite" style="margin: 5px;">
  <input type="submit" name="submit" value="Mettre à jour" id="">
 </form>
</td>

</tr>

</c:forEach>


 </table>

</c:if>


</div>