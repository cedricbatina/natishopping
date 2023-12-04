<%@ taglib prefix="c" uri="https://jakarta.ee/xml/ns/jakartaee/jstl/core" %>
<%@ taglib prefix="fn" uri="https://jakarta.ee/xml/ns/jakartaee/jstl/functions" %>
<%@ taglib prefix="fmt" uri="https://jakarta.ee/xml/ns/jakartaee/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
 <!--<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">-->
 <link rel="stylesheet" type="text/css" href="/natishopping/css/natikongo.css">
 <link rel="shortcut icon" href="natishopping/ressources/favicon.ico">
 <title>natishopping ${param.titre} </title>
</head>
<body>
 <div id="principale">
  <div id="enTete">
   <div id="BarreWidgets">
    <div class="WidgetTete" id="vuePanier">
     <img src="natishopping/ressources/panier.gif" alt="panier" id="panier">
     <span class="margeHorizontale">
      <c:choose>
       <c:when test="${panier.nbItems == null}" > 0</c:when>
       <c:otherwise>$ {panier.nbItems} </c:otherwise>
      </c:choose>
      <c:choose>
       <c:when test="${panier.nbItems >= 1 }">articles</c:when>
       <c:otherwise>article</c:otherwise>
      </c:choose>
     </span>
     <c:if test="${!empty panier && panier.nbItems != 0 && !fn:contains (pageContext.request.servletPath, '/panier') && requestScope[jakarta.servlet.forward.servlet_path'] ne '/panier' }"> 
      <a href="<c:url value='enregistrement'/ " class="bulle">Panier</a>
     </c:if>
    </div>
    <div class="WidgetTete" id="terminer">
     <c:if test="${!empty panier && panier.nbItems != 0 && !fn contains (pageContext.request.servletPath, '/enregistrement') && requestScope[jakarta.servlet.forward.servlet_path'] ne '/enregistrement/' && !fn:contains(pageContext.request.servletPath, 'panier') && requestScope['jakarta.servlet.forward.servlet_path'] ne '/panier' }">
      <a href="<c:url value='enregistrement'/ " class="bulle" >Terminer les achats</a>
     </c:if>
    </div>
   </div>
   <div id="logo">
    <a href="<c:url value= '/' /">
     <img src="/natishopping/ressources/logo.png" alt="logo">
    </a>
   </div>
  </div>
  <jsp:include pages="/${param.contenu}.jsp"/>
  <div  id="pied">
   <br> <br>
   <hr id="dividerPierd">
   <p id="testePied" class="tressPetitTexte">&copy;&nbsp;2023 natishopping</p>
  </div>
 </div>
</body>
</html>