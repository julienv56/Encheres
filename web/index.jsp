<%--
  Created by IntelliJ IDEA.
  User: moi
  Date: 21/01/2020
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Home</title>
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
            <!--             <a href="#"><img src="{{ asset('img/parkIcon.jpg') }}" style="width:50px;height: 50px"></a> -->
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="#">ENI-Enchere</a></li>
                <!--                 <li><a href="#">About</a></li> -->
                <!--                 <li><a href="{{ path('animalsList') }}">List</a></li> -->
                <!--                 <li><a href="#">Contact</a></li> -->
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="register.jsp"><span class="glyphicon glyphicon-log-in"></span>
                    S'inscrire</a></li>
                <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span>
                    Se connecter</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="jumbotron">
    <div class="container text-center">
        <h3>Liste des encheres</h3>
    </div>
</div>
<div class="jumbotron">
    <div class="container">

        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search"
                   placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Filtrer</button>
        </form>

        <div class="dropdown" style="padding-top: 5px; padding-left: 5px">
            <label>Categorie</label>

            <button class="btn btn-default dropdown-toggle" type="button"
                    id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="true">
                Selectionner <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">

                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Separated link</a></li>
            </ul>
        </div>
    </div>

</div>
</body>
</html>
