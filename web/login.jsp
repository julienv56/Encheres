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
<blockquote class="blockquote text-center">
    <form class="form-group" action="<%=request.getContextPath()%>/login" method="post">
        Pseudo:<input type="text" name="pseudo"/><br/>
        Mot de passe:<input type="password" name="MotDePasse"/><br/>
        <br/>
        <input type="submit" value="Se connecter"/>
    </form>
    <form action="register.jsp">
        <input type="submit" value="S'enregistrer"/>
    </form>
</blockquote>
</body>
</html>
