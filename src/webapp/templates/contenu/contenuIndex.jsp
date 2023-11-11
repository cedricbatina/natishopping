<%taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%taglib prefix="fn" uri="http://java.sun.com/jstl/functions" %>
<%taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<c:set var='view' value='/index' scope='session'/>

<div id="haut">
<div id="bienvenue">
  <p>Bienvenue sur natishopping </p>
 <p> Notre boutique en ligne vous offre des poduits frais bio qui seront livrés chez vous. <br>
 Notre boutique en ligne vous offre des produits frais bio qui seront livrés chez vous. Pour choisir une catégorie de produits, cliquez sur l'image correspondante.</p>
</div>
</div>
<div id="bas">
 <c:forEach var="catégorie" items="${catégorie}">
  <div class="BoiteCategorie">
   <a href="<c:url value='categories?${categorie.id}' "/>
   <img src="${initParam.cheminImagesCategories}${categorie.nom}.jsp" alt="${categorie.nom} " class="ImageCategorie" title='${categorie.nom}/'>
  </a>
  </div>
 </c:forEach>
</div>