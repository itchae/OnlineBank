<%-- 
    Document   : navigationBar
    Created on : 28 sept. 2018, 23:44:30
    Author     : lucille
--%>
<jsp:include page="include.jsp"/>   <!-- Bootstrap etc... -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
    <a class="navbar-brand" href="listAccount.htm"><i class="fas fa-piggy-bank"></i> Luto Bank</a>
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item">
        <a class="nav-link" href="listAccount.htm">Liste des comptes<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="transfer.htm">Virement</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Ordre de bourse</a>
      </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class="nav-item">
          <a class="nav-link" href="parameter.htm"><i class="fas fa-cog"></i>Paramètre du compte</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="logout.htm"><i class="fas fa-sign-out-alt"></i>Déconnexion</a>
        </li>
      </ul>
    
  </div>
</nav>