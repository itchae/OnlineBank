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
            <p>${userService}</p>
           <P> E-Mail : <INPUT Type=text Name=mail> </P>
	   <P> Mot de Passe : <INPUT Type=text Name=mpdchange></P>
           <P> Confirmez le mot de passe : <INPUT Type=text Name=mdpconf></P>
	   <P> <INPUT Type=submit VALUE="OK"> </P>
	</FORM>
    </body>
</html>
