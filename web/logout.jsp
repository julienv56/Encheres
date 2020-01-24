<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="refresh" content="2;/Encheres"/>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>logout</title>
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
<c:if test="${!empty sessionScope.user}">
    <form class="form-group" action="<%=request.getContextPath()%>/ServletLogout" method="post">
        <h3>Valider la deconnection du profil ${sessionScope.user}</h3>
        <br/>
        <input type="submit" value="Valider"/>
    </form>
</c:if>
</body>
</html>