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
    <title>Accueil</title>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="/Encheres/" class="navbar-left"><img src="https://image.flaticon.com/icons/svg/345/345629.svg"
                                                          style="height: 50px;width: 50px"></a>
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#myNavbar">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="/Encheres/">ENI-Enchere</a></li>
                <c:if test="${!empty sessionScope.user}">
                    <li><a href="ServletListCategorie">Vendre un article</a></li>
                </c:if>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                <c:if test="${!empty sessionScope.user}">
                <li><a href="ServletProfil"><span class="glyphicon glyphicon-user"></span> Mon profil</a></li>
                <li><a data-toggle="modal" data-target="#myModalDeco"><span
                        class="glyphicon glyphicon-log-out"></span> Se deconnecter</a></li>

                <!-- Modal deco -->
                <div class="modal fade" id="myModalDeco">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h3 class="modal-title">Confirmation</h3>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Etes-vous sur de vouloir vous deconnecter ?
                            </div>
                            <div class="modal-footer">
                                <form action="<%=request.getContextPath()%>/ServletLogout" method="post">
                                    <button type="submit" class="btn btn-danger">
                                        Oui
                                    </button>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                        Non
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                </c:if>
                <c:if test="${empty sessionScope.user}">
                <li><a href="register.jsp"><span class="glyphicon glyphicon-log-in"></span>
                    S'inscrire</a></li>
                <li>
                <li><a data-toggle="modal" data-target="#myModalCo"><span
                        class="glyphicon glyphicon-log-out"></span> Se connecter</a></li>

                <!-- Modal connexion -->
                <div class="modal fade" id="myModalCo">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h3 class="modal-title">Connexion</h3>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form action="<%=request.getContextPath()%>/login" method="post">
                                <div class="modal-body">
                                    <input name="pseudo" class="form-control" placeholder="pseudo" type="text">
                                    <input name="MotDePasse" class="form-control" placeholder="******"
                                           type="password">
                                </div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-primary">
                                        Valider
                                    </button>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                        Fermer
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
        </div>
        </c:if>
        </li>
        </ul>
    </div>
    </div>
</nav>
<div class="jumbotron">
    <div class="container text-center">
        <c:if test="${!empty sessionScope.user}">
            <h3>Bonjour ${sessionScope.user.prenom}, voici la liste des enchères</h3>
        </c:if>
        <c:if test="${empty sessionScope.user}">
            <h3>Liste des encheres</h3>
        </c:if>
    </div>
</div>
<div class="jumbotron">
    <div class="container">

        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search"
                   placeholder="filtrer" aria-label="Search" id="myInput" onkeyup="myFunction()">
        </form>
        <div class="form-group" style="width: 200px">
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
            <form>
                <c:if test="${!empty sessionScope.user}">
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
                    <script>
                        function showAchats() {
                            var y = document.getElementById("achatChoices");
                            var x = document.getElementById("ventesChoices");
                            if (x.style.display === "block") {
                                x.style.display = "none";
                            }
                            if (y.style.display === "none") {
                                y.style.display = "block";
                            } else {
                                y.style.display = "none";
                            }
                        }

                        function showVentes() {
                            var y = document.getElementById("ventesChoices");
                            var x = document.getElementById("achatChoices");
                            if (x.style.display === "block") {
                                x.style.display = "none";
                            }
                            if (y.style.display === "none") {
                                y.style.display = "block";
                            } else {
                                y.style.display = "none";
                            }
                        }
                    </script>

                    <div style="display: none" id="ventesChoices" class="checkbox">
                        <label for="ventesEnCours"><input type="checkbox" id="ventesEnCours">Ventes en cours</label>
                        <label for="ventesNonDeb"><input type="checkbox" id="ventesNonDeb">Ventes non débutées </label>
                        <label for="ventesTerm"><input type="checkbox"
                                                       id="ventesTerm">Ventes terminées</label>
                    </div>
                    <div style="display: none; padding-top: 15px" id="achatChoices" class="checkbox">
                        <label for="encheresOpen"><input type="checkbox" id="encheresOpen">Encheres
                            ouvertes</label>
                        <label for="encheresEnCours"><input type="checkbox" id="encheresEnCours">Encheres
                            en cours</label>
                        <label for="encheresRemportees"><input type="checkbox"
                                                               id="encheresRemportees">Encheres
                            remportées</label>
                    </div>
                </c:if>

            </form>
        </div>
        <ul id="myUL" style="display: inline-block;">
            <c:forEach items="${lstArticles}" var="article">
                <li style="display: block;float:left;margin-right: 10px;list-style: none;">
                    <img class="card-img-top" src="https://dummyimage.com/200x200/55595c/fff"
                         alt="Card image cap">
                    <div class="card-body">

                        <h4 class="card-title"><a href="#"
                                                  title="NomArticle">${article.getNomArticle()}</a>
                        </h4>
                        <p>${article.getUtilisateur().pseudo}</p>
                            <%--                            <c:if test="${!empty sessionScope.user}">--%>
                        <form action="<%=request.getContextPath()%>/ServletDetailArticle" method="post">
                            <div class="row" style="margin-right: 50px">
                                <div class="col" style="width: 300px">
                                    <button type="submit" class="btn btn-danger btn-lg btn-block" name="noArticle"
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

<script>
    function myFunction() {
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        ul = document.getElementById("myUL");
        li = ul.getElementsByTagName("li");
        for (i = 0; i < li.length; i++) {
            a = li[i].getElementsByTagName("a")[0];
            txtValue = a.textContent || a.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                li[i].style.display = "";
            } else {
                li[i].style.display = "none";
            }
        }
    }
</script>
</body>
</html>