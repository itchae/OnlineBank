<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Animal Kepper JPA</title>
    </head>
<body>
<h1>Animal Keeper JPA</h1>

    <h1>Add animal</h1>
    <form method="post" action="addAnimal.htm">
            <fieldset>
                Nom* : <input type="text" name="nom" /><br />
                Age: <input type="text" name="age" /><br />
                Type*: <input type="text" name="type" /><br />
                <input type="submit" name="action" value="Add animal"/>
            </fieldset>
        </form>
        <font size="1" color="#ff0000">* Champs obligatoire</font>
        <h2>${animals}</h2>
            
    <h1>Add Keeper</h1>
     <form method="post" action="addKeeper.htm">
            <fieldset>
                Nom* : <input type="text" name="nom" /><br />
                Prenom*: <input type="text" name="prenom" /><br />
                Age: <input type="text" name="age" /><br />
                Adresse: <input type="text" name="adresse" /><br />
                <input type="submit" name="action" value="Add keeper"/>
            </fieldset>
        </form>
        <font size="1" color="#ff0000">* Champs obligatoire</font>
    
    <h1>Add relation Keeper/Animal</h1>
     <form method="post" action="addKeeperAnimal.htm">
            <fieldset>
                Nom de l'animal* : <input type="text" name="nomAnimal" /><br />
                Nom du keeper*: <input type="text" name="nomKeeper" /><br />
                <input type="submit" name="action" value="Add relation"/>
            </fieldset>
        </form>
        <font size="1" color="#ff0000">* Champs obligatoire</font>
<p>${indexMessage}</p>
<p>${listeMessage}</p>
</body>
</html>

