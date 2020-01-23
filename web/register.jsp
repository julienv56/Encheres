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
    <title>log in success</title>
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
                <li><a href="register.jsp"><span class="glyphicon glyphicon-log-in"></span>
                    S'inscrire</a></li>
                <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span>
                    Se connecter</a></li>
            </ul>
        </div>
    </div>
</nav>
<form class="form-group" action="<%=request.getContextPath()%>/register" method="post">
    Pseudo:<input type="text" name="pseudo"/><br/>
    Nom:<input type="text" name="nom"/><br/>
    prenom:<input type="text" name="prenom"/><br/>
    Email:<input type="text" name="email"/><br/>
    Téléphone:<input type="text" name="telephone"/><br/>
    Rue:<input type="text" name="rue"/><br/>
    Code postal:<input type="text" name="codePostal"/><br/>
    Ville:<input type="text" name="ville"/><br/>
    Mot de passe:<input type="password" name="MotDePasse"/><br/>
    <input type="checkbox" name="admin" hidden/><br/>
    <input type="number" name="credit" value="0" hidden/><br/>

    <br/>
    <input type="submit" value="Register"/>

</form>
<form class="form-inline" action="login.jsp">
    <input type="submit" value="login"/>
</form>
</body>
</html>
