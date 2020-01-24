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
    <title>login</title>
</head>
<body>
<%--<blockquote class="blockquote text-center">--%>
<%--    <form class="form-group" action="<%=request.getContextPath()%>/login" method="post">--%>
<%--        Pseudo:<input type="text" name="pseudo"/><br/>--%>
<%--        Mot de passe:<input type="password" name="MotDePasse"/><br/>--%>
<%--        <br/>--%>
<%--        <input type="submit" value="Se connecter"/>--%>
<%--    </form>--%>
<%--    <form action="register.jsp">--%>
<%--        <input type="submit" value="S'enregistrer"/>--%>
<%--    </form>--%>
<%--</blockquote>--%>

<div class="card">
    <article class="card-body">
        <h4 class="card-title text-center mb-4 mt-1">Se connecter</h4>
        <hr>
        <form action="<%=request.getContextPath()%>/login" method="post">
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="pseudo" class="form-control" placeholder="pseudo" type="text">
                </div> <!-- input-group.// -->
            </div> <!-- form-group// -->
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text-center"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <input name="MotDePasse" class="form-control" placeholder="******" type="password">
                </div>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block"> Login</button>
            </div>
            <p class="text-center"><a href="register.jsp" class="btn">S'enregistrer</a></p>
        </form>
    </article>
</div> <!-- card.// -->


</body>
</html>
