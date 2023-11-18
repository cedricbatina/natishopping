<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<c:set var='view' value='/index' scope='session'/>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Natishopping - Accueil</title>
    <!-- Ajoutez ici vos liens CSS ou tout autre élément de tête nécessaire -->
</head>
<body>
    <section id="haut">
        <div id="bienvenue">
            <p>Bienvenue sur Natishopping</p>
            <p>Notre boutique en ligne vous offre des produits frais bio qui seront livrés chez vous. Pour choisir une catégorie de produits, cliquez sur l'image correspondante.</p>
        </div>
    </section>
    <section id="bas">
        <c:forEach var="categorie" items="${categories}">
            <div class="BoiteCategorie">
                <a href="<c:url value='categories?${categorie.id}'/>">
                    <img src="${initParam.cheminImagesCategories}${categorie.nom}.jpg" alt="${categorie.nom}" class="ImageCategorie" title="${categorie.nom}"/>
                </a>
            </div>
        </c:forEach>
    </section>
</body>
</html>
