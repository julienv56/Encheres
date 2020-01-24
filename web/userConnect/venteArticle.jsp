<%--
  Created by IntelliJ IDEA.
  User: jveneu2018
  Date: 24/01/2020
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Nouvelle vente</title>
</head>
<body>
<div class="jumbotron">
    <div class="container text-center">
        <h3>Nouvelle Vente</h3>
    </div>
</div>
<div class="jumbotron">
    <div class="container">
        <form>
            <div class="form-group">
                <label for="article">Article</label>
                <input type="text" class="form-control" id="article" placeholder="titre">
                <label for="exampleFormControlTextarea1" style="padding-top: 10px">Description</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>


                <label for="sel1">Categorie:</label>
                <select class="form-control" id="categoryId" name="category">
                    <option value="">Selectionner :</option>
                    <c:forEach items="${lstCategorie}" var="category">
                        <option value="${category.no_categorie}">${category.libelle}</option>
                    </c:forEach>
                </select>
                <label for="exampleFormControlFile1" style="padding-top: 10px">Photo de l'article</label>
                <input type="file" class="form-control-file" id="exampleFormControlFile1">
                <label for="article" style="padding-top: 10px">Mise à prix</label>
                <input class="form-control" type="number" name="miseAPrix">
                <label for="article" style="padding-top: 10px">Début de l'enchère</label>
                <input type="date" class="form-control">
                <label for="article" style="padding-top: 10px">Fin de l'enchère</label>
                <input type="date" class="form-control"/>

                <div class="panel panel-default" style="margin-top:20px">
                    <div class="panel-heading">RETRAIT</div>
                    <div class="panel-body">
                        <label for="article">Rue</label>
                        <input type="text" class="form-control" id="rue" placeholder="8 Rue Léo Lagrange">
                        <label for="article">Code Postal</label>
                        <input type="text" class="form-control" id="code_postal" placeholder="35131">
                        <label for="article">Ville</label>
                        <input type="text" class="form-control" id="ville" placeholder="Chartres-de-Bretagne">
                    </div>
                </div>


                <button type="submit" class="btn btn-primary">Valider</button>
                <button type="Reset" class="btn btn-warning">Annuler</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
