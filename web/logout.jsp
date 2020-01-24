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
    <title>logout</title>
</head>
<body>
<c:choose>
    <c:when test="${!empty sessionScope.user}">
        <blockquote class="blockquote text-center">
            <form class="form-group" action="<%=request.getContextPath()%>/ServletLogout" method="post">
                <h3>Valider la déconnexion du profil ${sessionScope.user.pseudo}</h3>
                <br/>
                <button class="btn btn-danger" type="submit">Deconnexion</button>
            </form>

    </c:when>
    <c:otherwise>
        <h3>Erreur, vous devez d'avord vous connecter</h3>
    </c:otherwise>
</c:choose>
</body>
</html>