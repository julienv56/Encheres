<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Profil</title>
</head>
<body>


<c:choose>
    <c:when test="${!empty sessionScope.user}">
        <div>
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse"
                                data-target="#myNavbar">
                            <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                                class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav">
                            <li><a href="/Encheres">ENI-Enchere</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">

                            <c:if test="${!empty sessionScope.user}">
                                <li><a href="ServletProfil"><span class="glyphicon glyphicon-user"></span> Mon
                                    profil</a></li>
                                <li><a data-toggle="modal" data-target="#myModalDeco"><span
                                        class="glyphicon glyphicon-log-out"></span> Se deconnecter</a></li>
                                <!-- Modal deco -->
                                <div class="modal fade" id="myModalDeco">
                                    <div class="modal-dialog modal-dialog-centered" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h3 class="modal-title">Confirmation</h3>
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                Etes-vous sur de vouloir vous deconnecter ?
                                            </div>
                                            <div class="modal-footer">
                                                <form action="<%=request.getContextPath()%>/ServletLogout"
                                                      method="post">
                                                    <button type="submit" class="btn btn-danger">
                                                        Oui
                                                    </button>
                                                    <button type="button" class="btn btn-secondary"
                                                            data-dismiss="modal">
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
                                <a href="login.jsp"> <span style="cursor: pointer"
                                                           class="glyphicon glyphicon-log-in"></span> Se connecter</a>
                                </c:if>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="jumbotron">
                <div class="container text-center">
                    <h3>Profil de ${sessionScope.user.pseudo}</h3>
                </div>
            </div>
            <div class="jumbotron">
                <div class="container text-center">
                    <div name="profil">
                        <c:if test="${!empty sessionScope.user}">
                            <table class="table">
                                <tbody>
                                <tr>
                                    <th scope="row">Pseudo</th>
                                    <td>${sessionScope.user.pseudo}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Nom</th>
                                    <td>${sessionScope.user.nom}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Prenom</th>
                                    <td>${sessionScope.user.prenom}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Email</th>
                                    <td>${sessionScope.user.email}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Telephone</th>
                                    <td>${sessionScope.user.telephone}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Rue</th>
                                    <td>${sessionScope.user.rue}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Code Postal</th>
                                    <td>${sessionScope.user.code_postal}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Ville</th>
                                    <td>${sessionScope.user.ville}</td>
                                </tr>

                                </tbody>
                            </table>
                            <div style="text-align: left">
                                <button type="button" class="btn btn-danger" data-toggle="modal"
                                        data-target="#modalCenterSupp">
                                    Supprimer profil
                                </button>
                                <button type="button" class="btn btn-primary" data-toggle="modal"
                                        data-target="#modalCenterEdit">
                                    Editer le profil
                                </button>
                            </div>

                            <!-- Modal supp -->
                            <div class="modal fade" id="modalCenterSupp">
                                <div class="modal-dialog modal-dialog-centered" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h3 class="modal-title">Confirmation
                                                suppression</h3>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            Etes-vous sur de vouloir supprimer le profil ?
                                        </div>
                                        <div class="modal-footer">
                                            <form action="<%=request.getContextPath()%>/ServletProfil" method="post">
                                                <button type="submit" class="btn btn-danger" href="/ServletProfil">
                                                    Supprimer
                                                </button>
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                                    Fermer
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Modal edit-->
                            <div class="modal fade" id="modalCenterEdit">
                                <div class="modal-dialog modal-dialog-centered" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title">Confirmation
                                                suppression</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            Etes-vous sur de vouloir supprimer le profil ?
                                        </div>
                                        <div class="modal-footer">
                                            <form action="<%=request.getContextPath()%>/ServletProfil" method="post">
                                                <button type="submit" class="btn btn-danger" href="/ServletProfil">
                                                    Supprimer
                                                </button>
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                                    Fermer
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#myNavbar">
                        <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                            class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li><a href="/Encheres">ENI-Enchere</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">

                        <c:if test="${!empty sessionScope.user}">
                            <li><a href="ServletProfil"><span class="glyphicon glyphicon-user"></span> Mon
                                profil</a></li>
                            <li><a data-toggle="modal" data-target="#myModalDeco"><span
                                    class="glyphicon glyphicon-log-out">Se deconnecter</span>
                            </a></li>
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
                                <
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
                                                <input name="pseudo" class="form-control" placeholder="pseudo"
                                                       type="text">
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
                        </c:if>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <h3 style="text-align: center">Erreur, vous devez d'abord vous connecter</h3>
    </c:otherwise>
</c:choose>
</body>
</html>