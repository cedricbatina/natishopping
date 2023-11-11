<%taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%taglib prefix="fn" uri =http://java.sun.com/jsp/jstl/functions"%>
<%taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<c:set var="view" value="/categories" scope="session"/>
<div id="categoriesHaut">
 <c:forEach var="categorie" items="${categories}">
  <c:choose>
   <c:when test="${categorie.nom == categorieChoisie.nom}">
    <span class="BoutonCategorie" id="categorieChoisie">
     <span class="TexteCategorie">
      ${categorie.nom}

     </span>
    </span>
   </c:when>
   <c:otherwise>
    <a href="<c:url value='categories?${categorie.id}'/ " class="BoutonCategorie">
     <span class="TexteCategorie">${categorie.com} </span>
    </a>
   </c:otherwise>
  </c:choose>
 </c:forEach>
</div>
<div id="categoriesBas">
 <table id="tableProduits">
  <c:forEach var="produit" items="${produitsCategorie}" varStatus="iter">
   <tr class="${((iter.index % 2 ) == 0) ? 'fonce' : 'fond'}">
    <td>
     <img src="${produit.nom}" alt="">
    </td>
    <td>
     ${produit.nom} <br>
     <span class="petitTexte">${produit.description} </span>
    </td> 
    <td > <fmt:formatNumber type ="currency" currencySymbl=""$euro;  </td>
<td>
 <form action="<c:url value = 'ajouterPanier'/> " method="post">
  <input type="hidden" name="idProduit" value="Ajouter au panier">
 </form>
</td>
   </tr>
  </c:forEach>
 </table>
</div>
