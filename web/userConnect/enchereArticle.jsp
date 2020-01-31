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
    <title>Encherir</title>
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
</nav>
<div class="jumbotron">
    <div class="container text-center">
        <h3>Détail enchère</h3>
    </div>
</div>
<div class="jumbotron">
    <div class="container">
        <aside class="col-sm-7">
            <article class="card-body p-5">
                <h3 class="title mb-3">${article.getNomArticle()}</h3>
                <h3 class="title mb-3">${retrait.getArticle().getNomArticle()}</h3>

                <dl class="item-property">
                    <dt>Description</dt>
                    <dd><p>${retrait.getArticle().getDescription()}</p></dd>
                </dl>
                <dl class="param param-feature">
                    <dt>Categorie</dt>
                    <dd>${retrait.getArticle().getCategorie().getLibelle()}</dd>
                </dl>  <!-- item-property-hor .// -->
                <dl class="param param-feature">
                    <dt>Meilleur offre</dt>
                    <dd>${retrait.getArticle().getPrixVente()}</dd>
                </dl>  <!-- item-property-hor .// -->
                <dl class="param param-feature">
                    <dt>Mise à Prix</dt>
                    <dd>${retrait.getArticle().getMiseAPrix()}</dd>
                </dl>  <!-- item-property-hor .// -->
                <hr>
                <dl class="param param-feature">
                    <dt>Fin de l'enchère</dt>
                    <dd>${retrait.getArticle().getDateFinEncheres()}</dd>
                </dl>  <!-- item-property-hor .// -->
                <hr>
                <dl class="param param-feature">
                    <dt>Retrait</dt>
                    <dd>${retrait.getRue()}</dd>
                    <dd>${retrait.getCode_postal()} - ${retrait.getVille()}</dd>
                </dl>  <!-- item-property-hor .// -->
                <dl class="param param-feature">
                    <dt>Vendeur</dt>
                    <dd>${retrait.getArticle().getUtilisateur().getPseudo()}</dd>
                </dl>  <!-- item-property-hor .// -->
                <hr>
                <form action="<%=request.getContextPath()%>/encheres" method="post">
                    <dl class="param param-inline">
                        <dt>Ma Proposition:</dt>
                        <dd>
                            <input class="form-control" type="number" name="proposition">
                        </dd>
                    </dl>  <!-- item-property .// -->
                    <button type="submit" class="btn btn-lg btn-primary text-uppercase">Enchérir</button>
                    <% if (request.getAttribute("error") != null) {%>
                    <div class="error">
                        <script> alert("<%=request.getAttribute("error")%>");
                        </script>
                    </div>
                    <%}%>
                </form>

            </article> <!-- card-body.// -->
        </aside> <!-- col.// -->
    </div>
</div>
</body>
</html>
