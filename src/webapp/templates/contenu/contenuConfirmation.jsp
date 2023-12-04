<%@ taglib prefix="c" uri="https://jakarta.ee/xml/ns/jakartaee/jstl/core" %>
<%@ taglib prefix="fn" uri="https://jakarta.ee/xml/ns/jakartaee/jstl/functions" %>
<%@ taglib prefix="fmt" uri="https://jakarta.ee/xml/ns/jakartaee/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>natishopping - ${param.titre}</title>
    <link rel="stylesheet" type="text/css" href="/src/webapp/natishopping.css">
    <link rel="shortcut icon" href="/src/main/ressources/images/official_favicon48X48.ico">
</head>
<body>
    <section id="colonneUnique">
        <article id="texteConfirmation">
            <strong>Votre commande a été traitée avec succès et sera livrée dans les 24 heures.</strong><br>
            Merci de noter votre numéro de confirmation: <strong>${commande.confirmation}</strong><br>
            Contactez Natishopping en cas de difficultés.<br>
            Merci de votre visite!
        </article>

        <div class="colonneResume">
            <table id="tableResumeCommande" class="TableDetails">
                <thead>
                    <tr class="enTete">
                        <th colspan="3">Résumé de votre commande</th>
                    </tr>
                    <tr class="teteTable">
                        <td>Produit</td>
                        <td>Quantité</td>
                        <td>Prix</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="produit" items="${produitsCommandes}" varStatus="iter">
                        <tr class="${((iter.index % 2) == 0) ? 'fonce' : 'fond'}">
                            <td>${produits[iter.index].nom}</td>
                            <td class="colonneQuantite">${produits[iter.index].quantite}</td>
                            <td class="colonneConfirmationPrix">
                                <fmt:formatNumber type="currency" currencySymbol="€" value="${produits[iter.index].prix}"/>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="2" id="totalCellLeft">
                            <strong>Total : </strong>
                        </td>
                        <td id="totalDroite">
                            <fmt:formatNumber type="currency" currencySymbol="€" value="${commande.montant}"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" id="dateTraitement">
                            <strong>Date de traitement :</strong>
                            <fmt:formatDate value="${commande.date_creation}" type="both" dateStyle="short" timeStyle="short"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div class="colonneResume">
            <table id="TableAdresseLivraison" class="TableDetails">
                <thead>
                    <tr class="enTete">
                        <th colspan="3">Adresse de livraison</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td colspan="3">
                            ${client.nom}<br>
                            ${client.addresse}<hr>
                            <strong>Mail :</strong> ${client.email}<br>
                            <strong>Téléphone :</strong> ${client.tel}
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </section>
</body>
</html>
