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
<%-- Vérification de la présence d'un objet utilisateur en session --%>
<c:if test="${!empty sessionScope.user}">
    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
    <p class="succes">Vous êtes connecté(e) avec le pseudo : ${sessionScope.user}</p>
</c:if>

<%--<%--%>
<%--    //allow access only if session exists--%>
<%--    String user = null;--%>
<%--    if (session.getAttribute("user") == null) {--%>
<%--        response.sendRedirect("index.jsp");--%>
<%--    } else user = (String) session.getAttribute("user");--%>
<%--    String sessionID = null;--%>
<%--    Cookie[] cookies = request.getCookies();--%>
<%--    boolean connected = false;--%>
<%--    if (cookies != null) {--%>
<%--        for (Cookie cookie : cookies) {--%>
<%--            if (cookie.getName().equals("user")) {--%>
<%--                user = cookie.getValue();--%>
<%--                connected = true;--%>
<%--            }--%>
<%--            if (cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();--%>
<%--        }--%>
<%--    }--%>
<%--%>--%>
<%--<h3>Hi <%=user %>, Login successful.--%>
<%--    &lt;%&ndash;    Your Session ID=<%=sessionID %>&ndash;%&gt;--%>
<%--</h3>--%>
<br>
<%--<form action="ServletLogout" method="post">--%>
<%--    <input type="submit" value="Logout">--%>
<%--</form>--%>
</body>
</html>
