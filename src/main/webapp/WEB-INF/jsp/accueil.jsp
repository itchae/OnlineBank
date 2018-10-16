<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Animal Kepper JPA</title>
    </head>
<body>
    
    <h1>Display datas </h1>
     <form method="post" action="affichage.htm">
                <input type="submit" name="action" value="Display"/>
        </form>
   
    <h1>Management</h1>
    <form>
           <input type="button" value="Manage" onclick="javascript: document.location='add.htm'">   
    </form>
        
   
</body>
</html>

