<%-- 
    Document   : consultAccount
    Created on : 27 sept. 2018, 15:04:36
    Author     : lucille
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultation</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <h1>Consultation du compte</h1>
        <% for (int i=0; i<10; i++) { %>
            Mouvement <%= i %> <br/>
        <% }%>
        <a href="listAccount.htm">Retour à la liste des comptes</a>
    </body>
</html>
