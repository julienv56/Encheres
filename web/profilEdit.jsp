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
    <title>Mon Profil</title>
</head>
<body>
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
<table class="table">
    <tbody>
    <tr>
        <th scope="row">Pseudo</th>
        <td><input name="pseudoEdited" class="form-control" type="text"></td>
        <th scope="row">Nom</th>
        <td><input name="nomEdited" class="form-control" type="text"></td>
    </tr>
    <tr>
        <th scope="row">Prenom</th>
        <td><input name="prenomEdited" class="form-control" type="text"></td>
        <th scope="row">Email</th>
        <td><input name="emailEdited" class="form-control" type="text"></td>
    </tr>
    <tr>
        <th scope="row">Telephone</th>
        <td><input name="telephoneEdited" class="form-control" type="text"></td>
        <th scope="row">Rue</th>
        <td><input name="rueEdited" class="form-control" type="text"></td>
    </tr>
    <tr>
        <th scope="row">Code Postal</th>
        <td><input name="codePostalEdited" class="form-control" type="text"></td>
        <th scope="row">Ville</th>
        <td><input name="villeEdited" class="form-control" type="text"></td>
    </tr>
    <tr>
        <th scope="row">Mot de passe actuel</th>
        <td><input name="password" class="form-control" type="password"></td>
        <th></th>
        <td></td>
    </tr>
    <tr>
        <th scope="row">Nouveau mot de passe</th>
        <td><input name="newPasswordEdited" class="form-control" type="password"></td>
        <th scope="row">Confirmation</th>
        <td><input name="confirmNewPasswordEdited" class="form-control" type="password"></td>
    </tr>
    </tbody>
</table>

<div style="text-align: center">
    <button type="button" class="btn btn-primary" data-toggle="modal"
            data-target="#modalCenterSave">
        Enregistrer
    </button>
    <button type="button" class="btn btn-danger" data-toggle="modal"
            data-target="#modalCenterSupp">
        Supprimer profil
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
</body>
</html>