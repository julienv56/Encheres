<%--
  Created by IntelliJ IDEA.
  User: jveneu2018
  Date: 24/01/2020
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../header.jsp"%>
<div class="jumbotron">
    <div class="container text-center">
        <h3>Nouvelle Vente Enchère</h3>
    </div>
</div>
<div class="jumbotron">
    <div class="container">
        <form action="<%=request.getContextPath() %>/ServletAjoutArticle" method="post">
            <div class="form-group">
                <label for="article">Article</label>
                <input type="text" class="form-control" id="article" name="titre" placeholder="titre">

                <label for="exampleFormControlTextarea1" style="padding-top: 10px">Description</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" name="description" rows="3"></textarea>

                <label for="categoryId">Categorie:</label>
                <select class="form-control" id="categoryId" name="categorie">
                    <option value="">Selectionner :</option>
                    <c:forEach items="${lstCategorie}" var="category">
                        <option value="${category.no_categorie}" name="selected">${category.libelle}</option>
                    </c:forEach>
                </select>

                <label for="exampleFormControlFile1" style="padding-top: 10px">Photo de l'article</label>
                <input type="file" class="form-control-file" id="exampleFormControlFile1" name="image">

                <label for="article" style="padding-top: 10px">Mise à prix</label>
                <input class="form-control" type="number" name="miseAPrix">

                <label for="article" style="padding-top: 10px">Début de l'enchère</label>
                <input type="date" class="form-control" name="date_debut_enchere">

                <label for="article" style="padding-top: 10px">Fin de l'enchère</label>
                <input type="date" class="form-control" name="date_fin_enchere"/>

                <div class="panel panel-default" style="margin-top:20px">
                    <div class="panel-heading">RETRAIT</div>
                    <div class="panel-body">
                        <label for="article">Rue</label>
                        <input type="text" class="form-control" id="rue" name="rue"
                               value="<c:out value="${sessionScope.user.rue}"/>"
                               placeholder="8 Rue Léo Lagrange">
                        <label for="article">Code Postal</label>
                        <input type="text" class="form-control" id="code_postal" name="code_postal"
                               value="<c:out value="${sessionScope.user.code_postal}"/>" placeholder="35131">
                        <label for="article">Ville</label>
                        <input type="text" class="form-control" id="ville" name="ville"
                               value="<c:out value="${sessionScope.user.ville}"/>" placeholder="Chartres-de-Bretagne">
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
