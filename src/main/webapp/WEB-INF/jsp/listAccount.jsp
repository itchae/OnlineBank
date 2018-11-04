<%-- 
    Document   : listAccount
    Created on : 27 sept. 2018, 15:01:13
    Author     : lucille
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des comptes</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container">
        <p>${welcome}</p>
        <p>${sessionScope.role}</p>
        <h1>Liste des comptes</h1>
        <!-- Il faut rechercher combien de comptes il y a,
        créer le nombre d'input en fonction, avec les bons noms,
        service ? -->
        <!--<ul>
        <% for (int i=0; i<10; i++) { %>
        <li>
            <a href="consultAccount.htm">Compte <%= i %> </a>
        </li>
        <% }%>
        </ul>-->
        <p>Liste des comptes : </p>
        <ul>
        ${listeComptes}
        </ul>
        
        <p>${listeBA}</p>
        
        <!--<p>Liste des particuliers</p>
        <p>${listePart}</p>-->
    </body>
</html>
