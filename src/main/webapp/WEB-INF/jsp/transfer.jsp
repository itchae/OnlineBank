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

        <h1>Transfer page</h1>
        
        <FORM method="POST" ACTION="transfer.htm">
           <P> Entrez la somme à transferer : <INPUT Type=text Name=somme> </P>
	   <P> Entrez le compte à débiter : <INPUT Type=text Name=debiteur></P>
           <P> Entrez le compte beneficieur : <INPUT Type=text Name=beneficieur></P>
	   <P> <INPUT Type=submit VALUE="OK"> </P>
	</FORM>
    </body>
</html>
