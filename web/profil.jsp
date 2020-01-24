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
                        <li><a href="ServletProfil"><span class="glyphicon glyphicon-user"></span> Mon profil</a></li>
                        <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Se deconnecter</a>
                        </li>
                    </c:if>
                    <c:if test="${empty sessionScope.user}">
                    <li><a href="register.jsp"><span class="glyphicon glyphicon-log-in"></span>
                        S'inscrire</a></li>
                    <li>
                        <a href="login.jsp"> <span class="glyphicon glyphicon-log-in"></span> Se connecter</a>
                        </c:if>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <blockquote class="blockquote text-center">
        <c:if test="${!empty sessionScope.user}">
        <dl class="row">
            <dt class="col-sm-3">Pseudo</dt>
            <dd class="col-sm-9">${sessionScope.user.pseudo}</dd>
            <br>
            <dt class="col-sm-3">Nom</dt>
            <dd class="col-sm-9">${sessionScope.user.nom}</dd>

            <dt class="col-sm-3">Prénom</dt>
            <dd class="col-sm-9">${sessionScope.user.prenom}</dd>

            <dt class="col-sm-3">Email</dt>
            <dd class="col-sm-9">${sessionScope.user.email}</dd>

            <dt class="col-sm-3">Téléphone</dt>
            <dd class="col-sm-9">${sessionScope.user.telephone}</dd>

            <dt class="col-sm-3">Rue</dt>
            <dd class="col-sm-9">${sessionScope.user.rue}</dd>

            <dt class="col-sm-3">Code postal</dt>
            <dd class="col-sm-9">${sessionScope.user.code_postal}</dd>

            <dt class="col-sm-3">Ville</dt>
            <dd class="col-sm-9">${sessionScope.user.ville}</dd>
            </c:if>
    </blockquote>

</div>
<button style="position: absolute" class="btn btn-danger" type="submit">Modifier</button>
</body>
</html>
