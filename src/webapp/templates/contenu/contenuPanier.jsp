<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<c:set var="view" value="/panier" scope="session"/>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Panier - Natishopping</title>
    <!-- Ajoutez ici vos liens CSS ou tout autre élément de tête nécessaire -->
</head>
<body>
    <section id="colonneUnique">
        <c:choose>
            <c:when test="${panier.nbItems > 1}">
                <p>Votre panier contient ${panier.nbItems} articles.</p>
            </c:when>
            <c:otherwise>
                <p>Votre panier est vide.</p>
            </c:otherwise>
        </c:choose>

        <div id="BarreActions">
            <c:if test="${!empty panier && panier.nbItems != 0}">
                <c:url var="urlEffacer" value="voirPanier">
                    <c:param name="effacer" value="true"/>
                </c:url>
                <a href="${urlEffacer}" class="bulle margeH">Vider le panier</a>

                <c:set var="urlContinuer" value="${!empty categorieChoisie ? 'categories' : 'index.jsp'}"/>
                <a href="${urlContinuer}" class="bulle margeH">Continuer les achats</a>

                <a href="<c:url value='enregistrement'/>" class="bulle margeH">Terminer les achats</a>
            </c:if>
        </div>

        <c:if test="${!empty panier && panier.nbItems != 0}">
            <h4 id="soustotal">
                <fmt:formatNumber type="currency" currencySymbol="€" value="${panier.soustotal}"/>
            </h4>
            <table id="TablePanier">
                <thead>
                    <tr class="enTete">
                        <th>Produit</th>
                        <th>Description</th>
                        <th>Prix</th>
                        <th>Quantité</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="itemPanier" items="${panier.items}" varStatus="iter">
                        <c:set var="produit" value="${itemPanier.produit}"/>
                        <tr class="${iter.index % 2 == 0 ? 'fonce' : 'fond'}">
                            <td>
                                <img src="${initParam.cheminImagesProduits}${produit.nom}.png" alt="${produit.description}">
                            </td>
                            <td>
                                ${produit.nom}
                            </td>
                            <td>
                                <fmt:formatNumber type="currency" currencySymbol="€" value="${itemPanier.total}"/>
                                <br>
                                <span class="petitTexte">(${fmt:formatNumber type="currency" currencySymbol="€" value="${produit.prix}"} / unité)</span>
                            </td>
                            <td>
                                <form action="<c:url value='majPanier'/>" method="post">
                                    <input type="hidden" name="idProduit" value="${produit.id}">
                                    <input type="text" maxlength="2" size="2" name="quantite" value="${itemPanier.quantite}" style="margin: 5px;">
                                    <input type="submit" value="Mettre à jour">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </section>
</body>
</html>
