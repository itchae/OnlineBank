<%-- 
    Document   : paramaters
    Created on : 29 sept. 2018, 15:47:21
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
        <h1>Parameters</h1>
        <FORM method="POST" ACTION="parameter.htm">
           <P> E-Mail : <INPUT Type=text Name=mail> </P>
	   <P> Mot de Passe : <INPUT Type=text Name=mpdchange></P>
           <P> Confirmez le mot de passe : <INPUT Type=text Name=mdpconf></P>
	   <P> <INPUT Type=submit VALUE="OK"> </P>
           <p>${id}</p>
           <p>Login : </p>
           <p>${logingars}</p>
           <p> Email : </p>
           <p>${email}</p>
           <p>Adresse</p>
           <p>${adresse}</p>
           <p>Phone</p>
           <p>${phone}</p>
           <p>Mot de passe</p>
           <p>${pwd}</p>
           
           
           
	</FORM>
    </body>
</html>
