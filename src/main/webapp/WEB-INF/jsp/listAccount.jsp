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
        <div class="container content rounded">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <h1>Liste des comptes</h1>

                    <p>Liste des comptes : </p>
                    <div class="list-group">
                        ${listeComptes}
                    </div>
                    <br/>
                    <!--<p>Liste des particuliers</p>
                    <p>${listePart}</p>-->
                </div>
            </div>
        </div>
    </body>
</html>
