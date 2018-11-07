<%-- 
    Document   : transfer
    Created on : 27 sept. 2018, 15:04:54
    Author     : lucille
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container content rounded">
            <h1>Transfer page</h1>
            <p>${resultat}</p>
        
            <FORM method="POST" ACTION="transfer.htm">
                <div class="form-group row justify-content-center">
                    <div class="col-md-4">
                        <P> Nommez la transaction : <INPUT Type="text" Name=nom class="form-control" required></p>
                        <P> Entrez la somme à transferer : <INPUT Type=text Name=somme class="form-control" required> </P>
                        <P> Entrez le compte a debiter : 
                            <select name = "debiteur" size="1">
                            ${listeCompte}
                            </select></P>
                        <P> Entrez le compte beneficieur : <INPUT Type=text Name=beneficieur class="form-control" required></P>
                        <button type="submit" class="btn btn-primary">Transferer</button>
                    </div>
                </div>
            </FORM>
                            
        </div>
    </body>
</html>
