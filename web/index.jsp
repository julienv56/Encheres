<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<div class="jumbotron">
    <div class="container text-center">
        <c:if test="${!empty sessionScope.user}">
            <h3>Bonjour ${sessionScope.user.prenom}, voici la liste des enchères</h3>
        </c:if>
        <c:if test="${empty sessionScope.user}">
            <h3>Liste des enchères</h3>
        </c:if>
    </div>
</div>
<div class="jumbotron">
    <div class="container">

        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search"
                   placeholder="filtrer" aria-label="Search" id="myInput" onkeyup="FiltreParNom()">
        </form>
        <div class="form-group" style="width: 200px">


            <%--   Categorie--%>
            <label>Categorie:</label>
            <form action="<%=request.getContextPath() %>/TrierParCategory" method="post">
                <select class="form-control" id="categoryId" name="categorie">
                    <option value="0">Tout Selectionner</option>
                    <c:forEach items="${lstCategorie}" var="category">
                        <option value="${category.no_categorie}">${category.libelle}</option>
                    </c:forEach>
                </select>
                <button class="btn btn-primary my-2 my-sm-0" type="submit">Filtrer</button>
            </form>
            <%--    Categorie--%>

            <c:if test="${!empty sessionScope.user}">
                <form action="<%=request.getContextPath() %>/TrierParAchats" method="post">
                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                        <label onclick="showAchats()" class="btn btn-primary" for="achats"><input type="radio"
                                                                                                  id="achats"
                                                                                                  name="option"
                                                                                                  value="achats">
                            Achats</label>
                        <label onclick="showVentes()" class="btn btn-primary" for="ventes"><input type="radio"
                                                                                                  id="ventes"
                                                                                                  name="option"
                                                                                                  value="ventes">
                            Mes ventes</label>
                    </div>

                    <div style="display: none" id="ventesChoices" class="checkbox">
                        <label for="ventesEnCours"><input name="ventesEnCours" type="checkbox" id="ventesEnCours">Ventes
                            en cours</label>
                        <label for="ventesNonDeb"><input name="ventesNonDeb" type="checkbox" id="ventesNonDeb">Ventes
                            non débutées </label>
                        <label for="ventesTerm"><input name="ventesTerm" type="checkbox" id="ventesTerm">Ventes
                            terminées</label>
                        <button type="submit" class="btn btn-primary">
                            Valider
                        </button>
                    </div>
                    <div style="display: none; padding-top: 15px" id="achatChoices" class="checkbox">
                        <label for="encheresOpen"><input name="encheresOpen" type="checkbox" id="encheresOpen">Encheres
                            ouvertes</label>
                        <label for="encheresEnCours"><input name="encheresEnCours" type="checkbox" id="encheresEnCours">Encheres
                            en
                            cours</label>
                        <label for="encheresRemportees"><input name="encheresRemportees" type="checkbox"
                                                               id="encheresRemportees">Encheres
                            remportées</label>
                        <button type="submit" class="btn btn-primary">
                            Valider
                        </button>
                    </div>

                </form>
            </c:if>
        </div>
        <ul id="myUL" style="display: inline-block;">
            <c:forEach items="${lstArticles}" var="article">
                <li style="display: block;float:left;margin-right: 50px;list-style: none;">
                    <img class="card-img-top" src="https://www.indexel-datascience.com/wp-content/uploads/2019/12/giphy-4.gif"
                         alt="Card image cap" height="200" width="300">
                    <div class="card-body" style="width: 300px">
                        <h3 class="card-title" style="text-align: -moz-center;">${article.getNomArticle()}</h3>
                        <p>${article.getUtilisateur().pseudo}</p>
                        <form action="<%=request.getContextPath()%>/ServletDetailArticle" method="post">
                            <div class="row" style="margin-right: 50px">
                                <div class="col" style="width: 300px; margin-left:15px">

                                    <button type="submit" <c:if
                                            test="${empty sessionScope.user}"> data-toggle="tooltip" title="Veuillez-vous connecter " disabled </c:if>
                                            class="btn btn-danger btn-lg btn-block" name="noArticle"
                                            value="${article.getNoArticle()}">${article.getMiseAPrix()}
                                        points
                                    </button>

                                </div>
                            </div>
                        </form>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<%@include file="footer.jsp" %>
