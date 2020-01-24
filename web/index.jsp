<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: moi
  Date: 21/01/2020
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
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
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#myNavbar">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="#">ENI-Enchere</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                <c:if test="${!empty sessionScope.user}">
                    <li><a href="profil.jsp"><span class="glyphicon glyphicon-user"></span> Mon profil</a></li>
                    <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Se deconnecter</a></li>
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
<div class="jumbotron">
    <div class="container text-center">
        <c:if test="${!empty sessionScope.user}">
            <h3>Bonjour ${sessionScope.user}, voici la liste des encheres</h3>
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
                   placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Filtrer</button>
        </form>

        <form action="<%=request.getContextPath() %>/categorie" method="get">
            <div class="form-group" style="width: 200px">
                <label for="sel1">Categorie:</label>
                <select class="form-control" id="categoryId" name="category">
                    <option value="">Selectionner :</option>
                    <c:forEach items="${lstCategorie}" var="category">
                        <option value="${category.no_categorie}">${category.libelle}</option>
                    </c:forEach>
                </select>
            </div>
        </form>
        <form action="<%=request.getContextPath() %>/listeArticles" method="get">

            <c:forEach items="${lstArticles}" var="article">


            <div class="col">
                <div class="row">
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="card">
                            <img class="card-img-top" src="https://dummyimage.com/200x200/55595c/fff"
                                 alt="Card image cap">
                            <div class="card-body">
                                <h4 class="card-title"><a href="#" title="View Product">${article.getNomArticle()}</a>
                                </h4>
                                <p class="card-text">${article.getDescription()}</p>
                                <p>${article.getUtilisateur().pseudo}</p>
                                <div class="row">
                                    <div class="col" style="width: 300px">
                                        <p class="btn btn-danger btn-block">${article.getMiseAPrix()} points</p>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
        </form>
    </div>
</div>
</body>
</html>


<%--//                                    Cookie[] cookies = request.getCookies();--%>
<%--//                                    if (cookies != null) {--%>
<%--//                                        for (Cookie cookie : cookies) {--%>
<%--//                                            String test = cookie.getComment();--%>
<%--//                                            out.println("<h1>" + test + "</h1>");--%>

<%--//                            if ((cookie.getName() == "JSESSIONID") && (cookie.getName() == "pseudo")) {--%>
<%--//                                out.println("<a href=\"login.jsp\"><span class=\"glyphicon glyphicon-log-in\"></span> je detecte 2 cookie / Se deconnecter</a>");--%>
<%--//                            } else if (cookie.getName().equals("JSESSIONID")) {--%>
<%--//                                out.println("<a href=\"login.jsp\"><span class=\"glyphicon glyphicon-log-in\"></span> je detecte 1 cookie / Se connecter </a>");--%>
<%--//                            }--%>
<%--}--%>
<%--}--%>