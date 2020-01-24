<%--
  Created by IntelliJ IDEA.
  User: jveneu2018
  Date: 24/01/2020
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
                <label for="exampleFormControlTextarea1">Description</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
            </div>
            <form action="<%=request.getContextPath() %>/categorie" method="get">
                <div class="form-group" style="width: 200px">
                    <label for="sel1">Categorie:</label>
                    <select class="form-control" id="categoryId" name="category">
                        <option value="">Selectionner :</option>
                        <c:forEach items="${lstCategorie}" var="category">
                            <option value="${category.no_categorie}">${category.libelle}</option>
                        </c:forEach>
                    </select>
                </div>
            </form>
        </form>
    </div>
</div>
</body>
</html>
