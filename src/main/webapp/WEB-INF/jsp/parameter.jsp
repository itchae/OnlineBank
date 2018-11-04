<%-- 
    Document   : paramaters
    Created on : 29 sept. 2018, 15:47:21
    Author     : lucille
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container content rounded">
            <h1>Parameters</h1>
            <FORM id="parameters" method="POST" ACTION="parameter.htm">

                <p>Login : ${logingars}</p>
                <p>Role du membre : ${sessionScope.role}</p>
                <c:if test= "${role == 'par' || role == 'banq'}">
                    <p>Prenom : ${prenom}</p>
                    <div class="form-group offset-md-3 w-50">
                        <input class="form-control" Type=text Name=prenom placeholder="Prénom">
                    </div>

                </c:if>
                <c:if test= "${role == 'pro'}">
                    <p>Siret : ${siret}</p>
                    <div class="form-group offset-md-3 w-50">
                        <input class="form-control" Type=text Name=siret placeholder="Siret">
                    </div>
                </c:if>
                <p>E-Mail : ${email}</p>
                <div class="form-group offset-md-3 w-50">
                    <input class="form-control" Type=text Name=mail placeholder="E-mail">
                </div>
                <p>Adresse : ${adresse}</p>
                <div class="form-group offset-md-3 w-50">
                    <input class="form-control" Type=text Name=address placeholder="Adresse">
                </div>
                <p>Phone : ${phone}</p>
                <div class="form-group offset-md-3 w-50">
                    <input class="form-control" Type=text Name=phone placeholder="Téléphone">
                </div>
                <p>Mot de passe : </p>
                <div class="form-group offset-md-3 w-50">
                    <input id="password" class="form-control" Type=password Name=mdpchange placeholder="Nouveau mot de passe">
                </div>
                <div class="form-group offset-md-3 w-50">
                    <input id="confirm_password" class="form-control" Type=password Name=mdpconf placeholder="Confirmation mot de passe" oninput="check(this)">
                    <script language='javascript' type='text/javascript'>
                        function check(input) {
                            if (input.value != document.getElementById('password').value) {
                                input.setCustomValidity('Les deux mots de passes doivent correspondre');
                            } else {
                                // input is valid -- reset the error message
                                input.setCustomValidity('');
                            }
                        }
                    </script>
                </div>
                <button type="submit" class="btn btn-primary">Modifier mes paramètres</button>

            </FORM>
        </div>
    </body>
</html>
