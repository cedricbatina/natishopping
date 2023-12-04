<%@ taglib prefix="c" uri="https://jakarta.ee/xml/ns/jakartaee/jstl/core" %>
<%@ taglib prefix="fn" uri="https://jakarta.ee/xml/ns/jakartaee/jstl/functions" %>
<%@ taglib prefix="fmt" uri="https://jakarta.ee/xml/ns/jakartaee/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>natishopping - ${param.titre}</title>
    <link rel="stylesheet" type="text/css" href="/src/webapp/natishopping.css">
    <link rel="shortcut icon" href="/src/main/ressources/images/official_favicon48X48.ico">
</head>
<body>
    <header id="enTete">
        <!-- Votre contenu d'en-tête ici -->
    </header>

    <nav id="BarreWidgets">
        <!-- Votre barre de navigation ici -->
    </nav>

    <section id="categoriesHaut">
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
                    <a href="<c:url value='categories?${categorie.id}'/" class="BoutonCategorie">
                        <span class="TexteCategorie">${categorie.nom} </span>
                    </a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </section>

    <section id="categoriesBas">
        <table id="tableProduits">
            <c:forEach var="produit" items="${produitsCategorie}" varStatus="iter">
                <tr class="${((iter.index % 2) == 0) ? 'fonce' : 'fond'}">
                    <td>
                        <img src="${produit.imagePath}" alt="${produit.nom}">
                    </td>
                    <td>
                        ${produit.nom} <br>
                        <span class="petitTexte">${produit.description} </span>
                    </td>
                    <td>
                        <fmt:formatNumber value="${produit.prix}" type="currency" currencySymbol="€"/>
                    </td>
                    <td>
                        <form action="<c:url value='ajouterPanier'/>" method="post">
                            <input type="hidden" name="idProduit" value="${produit.id}">
                            <input type="submit" value="Ajouter au panier">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </section>

    <footer id="pied">
        <hr id="dividerPied">
        <p id="textePied" class="tresPetitTexte">&copy; 2023 natishopping</p>
    </footer>
</body>
</html>
