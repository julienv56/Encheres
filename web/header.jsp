<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
    <title>Enchères</title>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top" style="z-index: 100000 !important;">
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
                    <li><a href="/Encheres/ServletListCategorie">Vendre un article</a></li>
                </c:if>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                <c:if test="${!empty sessionScope.user}">
                <li><a href="/Encheres/userConnect/profil.jsp"><span class="glyphicon glyphicon-user"></span> Mon profil</a>
                </li>
                <li><a data-toggle="modal" data-target="#myModalDeco"><span
                        class="glyphicon glyphicon-log-out"></span> Se deconnecter</a></li>

                <!-- Deconnexion -->
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
                <li><a data-toggle="modal" data-target="#myModalRegister"><span
                        class="glyphicon glyphicon-log-in"></span>
                    S'inscrire</a></li>
                <li>
                <li><a data-toggle="modal" data-target="#myModalCo"><span
                        class="glyphicon glyphicon-log-out"></span> Se connecter</a></li>

                <!-- Modal register -->
                <div class="modal fade" id="myModalRegister">
                    <div class="modal-dialog modal-dialog-centered" role="form">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h3 class="modal-title">Enregistrement</h3>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form class="form-group" action="<%=request.getContextPath()%>/register" method="post">
                                <div class="container register-form">
                                    <div class="form">
                                        <div class="form-content">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" placeholder="Pseudo"
                                                               name="pseudo"/>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" placeholder="Prenom"
                                                               name="prenom"/>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" placeholder="Nom"
                                                               name="nom"/>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" placeholder="Email"
                                                               name="email"/>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" placeholder="Telephone"
                                                               name="telephone"/>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" placeholder="Rue"
                                                               name="rue"/>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="text" class="form-control"
                                                               placeholder="Code postal" name="codePostal"/>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" placeholder="Ville"
                                                               name="ville"/>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="password" class="form-control"
                                                               placeholder="Mot de passe" name="MotDePasse"/>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-success">S'enregistrer</button>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                        Fermer
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

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

                                    <div style="text-align: right" class="btn-group-toggle" data-toggle="buttons">
                                        <label class="btn btn-success active">
                                            <input name="remind" type="checkbox" checked autocomplete="off"> Se souvenir de moi
                                        </label>
                                    </div>
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
