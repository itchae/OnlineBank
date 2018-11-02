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
        <div class="container">
            <h1>Parameters</h1>
            <FORM method="POST" ACTION="parameter.htm">
                
               <p>Login : ${logingars}</p>
               <c:set var="role"  scope="session" value="${res}"/>
               <c:if test= "${role == 'par'}">
               <p>E-Mail : ${email}</p>
               <P> Nouvel E-Mail : <INPUT Type=text Name=mail> </P>
               <p>Adresse : ${adresse}</p>
               <P> Nouvelle adresse : <INPUT Type=text Name=address> </P>
               <p>Phone : ${phone}</p>
               <P> Nouveau numero : <INPUT Type=text Name=phone> </P
               </c:if>
               <c:out value="${sessionScope.role}"/>
               <p>Mot de passe : </p>
               <P> Mot de Passe : <INPUT Type=text Name=mdpchange></P>
               <P> Confirmez le mot de passe : <INPUT Type=text Name=mdpconf></P>
               <P> <INPUT Type=submit VALUE="OK"> </P>

            </FORM>
        </div>
    </body>
</html>
