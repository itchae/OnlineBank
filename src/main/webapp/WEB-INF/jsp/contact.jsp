<%-- 
    Document   : contact
    Created on : 1 nov. 2018, 17:15:17
    Author     : APO
--%>
<jsp:include page="include.jsp"/>   <!-- Bootstrap etc... -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultation</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="content container rounded">
            <h1>Contactez dès maintenant votre conseiller</h1>
            <p class="lead">Pour toute information n'hésitez pas à contacter votre conseiller</p>
            <hr class="my-4">
            <p> Votre conseiller est : ${nom} ${prenom}</p>
            <p>Contactez le</p>
            <p>par mail : ${mail}</p>
            <p>ou par telephone : ${tel}</p>
            <p>ou ici </p>
            <form>

                <div class="form-group">
                    <label for="exampleTextarea">Message :</label>
                    <textarea class="form-control" id="exampleTextarea" rows="3"></textarea>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </body>
</html>

